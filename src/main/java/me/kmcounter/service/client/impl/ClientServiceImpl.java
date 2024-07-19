package me.kmcounter.service.client.impl;

import me.kmcounter.domain.model.Client;
import me.kmcounter.domain.repository.ClientRepository;
import me.kmcounter.dtos.client.ClientDataUpdate;
import me.kmcounter.dtos.client.ClientDataCreate;
import me.kmcounter.infra.exceptions.ClientNotFoundException;
import me.kmcounter.service.client.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
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

