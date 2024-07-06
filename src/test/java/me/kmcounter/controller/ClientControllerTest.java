package me.kmcounter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kmcounter.controllers.ClientController;
import me.kmcounter.domain.model.Client;
import me.kmcounter.dtos.client.ClientDataCreate;
import me.kmcounter.service.client.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    public void testFindById() throws Exception {
        ClientDataCreate clientDataCreate = new ClientDataCreate("Client Test", "11112222");

        Client createdClient = new Client ("Client Test", "11112222");
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
    public void testCreateClient() throws Exception {

    }

    @Test
    public void testUpdateClient() throws Exception {

    }

    @Test
    public void testDeleteClientById() throws Exception {

    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
