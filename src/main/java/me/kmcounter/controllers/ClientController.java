package me.kmcounter.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import me.kmcounter.domain.model.Client;
import me.kmcounter.dtos.client.ClientDataCreate;
import me.kmcounter.dtos.client.ClientDataUpdate;
import me.kmcounter.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        var user = clientService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody @Valid ClientDataCreate clientToCreate) {
        var userCreated = clientService.createNewClient(clientToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.ok(userCreated);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient(@RequestBody ClientDataUpdate data) {

        clientService.updateClient(data);

        return ResponseEntity.ok("Client successfully updated!");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteClientById(@PathVariable @Valid Long id) {
        clientService.deleteClientById(id);

        return ResponseEntity.noContent().build();

    }
}
