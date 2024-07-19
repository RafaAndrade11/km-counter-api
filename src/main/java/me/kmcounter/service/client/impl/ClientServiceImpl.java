package me.kmcounter.service.client.impl;

import me.kmcounter.domain.model.Client;
import me.kmcounter.domain.repository.ClientRepository;
import me.kmcounter.dtos.client.ClientDataCreate;
import me.kmcounter.dtos.client.ClientDataUpdate;
import me.kmcounter.infra.exceptions.ClientAlreadyExistsException;
import me.kmcounter.infra.exceptions.ClientNotFoundException;
import me.kmcounter.infra.exceptions.InvalidClientDataException;
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
        if (clientRepository.existsByZipCode(dataClient.zipCode())) {
            throw new ClientAlreadyExistsException();
        }
        return clientRepository.save(new Client(dataClient));
    }

    @Override
    public void updateClient(ClientDataUpdate data) {
        if (clientRepository.existsByName(data.name()) || clientRepository.existsByZipCode(data.zipCode())) {
            throw new InvalidClientDataException();
        }
        var clientToUpdate = clientRepository.getReferenceById(data.id());
        clientToUpdate.updateClientInfo(data);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}

