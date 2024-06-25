package me.kmcounter.service.client.impl;

import me.kmcounter.domain.model.Client;
import me.kmcounter.domain.repository.ClientRepository;
import me.kmcounter.dtos.client.ClientDataUpdate;
import me.kmcounter.dtos.client.ClientDataCreate;
import me.kmcounter.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Client createNewClient(ClientDataCreate dataClient) {
        return clientRepository.save(new Client(dataClient));
    }

    @Override
    public void updateClient(ClientDataUpdate data) {

        var clientToUpdate = clientRepository.getReferenceById(data.id());

        clientToUpdate.updateClientInfo(data);
    }



    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }


}

