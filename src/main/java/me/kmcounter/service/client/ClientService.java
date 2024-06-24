package me.kmcounter.service.client;

import me.kmcounter.domain.model.Client;
import me.kmcounter.dtos.client.ClientDataCreate;
import me.kmcounter.dtos.client.ClientDataUpdate;

public interface ClientService {

    Client createNewClient(ClientDataCreate client);

    Client findById(Long id);

    void deleteClientById(Long id);

    void updateClient(ClientDataUpdate data);
}
