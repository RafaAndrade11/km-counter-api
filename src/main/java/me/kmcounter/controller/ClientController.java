package me.kmcounter.controller;

import jakarta.transaction.Transactional;
import me.kmcounter.domain.model.Client;
import me.kmcounter.dtos.client.ClientDataCreate;
import me.kmcounter.service.client.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

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
    public ResponseEntity<Client> createClient(@RequestBody ClientDataCreate clientToCreate) {
        var userCreated = clientService.createNewClient(clientToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.ok(userCreated);
    }


}
