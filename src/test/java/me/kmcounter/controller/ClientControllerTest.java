package me.kmcounter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kmcounter.controllers.ClientController;
import me.kmcounter.domain.model.Client;
import me.kmcounter.dtos.client.ClientDataCreate;
import me.kmcounter.dtos.client.ClientDataUpdate;
import me.kmcounter.service.client.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClientService clientService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindById() throws Exception {
        ClientDataCreate clientDataCreate = new ClientDataCreate("Client Test", "11112222");

        Client createdClient = new Client("Client Test", "11112222");
        createdClient.setId(1L);

        when(clientService.findById(1L)).thenReturn(createdClient);

        mockMvc.perform(get("/clients/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clientDataCreate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Client Test")))
                .andExpect(jsonPath("$.zipCode", is("11112222")));
    }

    @Test
    public void testCreateClient() throws Exception {
        ClientDataCreate clientDataCreate = new ClientDataCreate("Client Test", "11112222");

        Client createdClient = new Client("Client Test", "11112222");
        createdClient.setId(1L);

        when(clientService.createNewClient(clientDataCreate)).thenReturn(createdClient);

        mockMvc.perform(post("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clientDataCreate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Client Test")))
                .andExpect(jsonPath("$.zipCode", is("11112222")));
    }
    @Test
    public void testUpdateClientById() throws Exception {
        ClientDataUpdate clientDataUpdate = new ClientDataUpdate(1L, "Updated Name", "12345678");

        doNothing().when(clientService).updateClient(clientDataUpdate);

        mockMvc.perform(put("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientDataUpdate)))
                .andExpect(status().isOk());

        verify(clientService).updateClient(clientDataUpdate);
    }
    @Test
    public void testDeleteClientById() throws Exception {
        Client createdClient = new Client("Client Test", "11112222");
        createdClient.setId(1L);

        doNothing().when(clientService).deleteClientById(createdClient.getId());

        mockMvc.perform(delete("/clients/1"))
                .andExpect(status().isNoContent());

        verify(clientService, times(1)).deleteClientById(createdClient.getId());
    }
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
