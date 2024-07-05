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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        Long clientId = 1L;
        Client client = new Client();
        client.setId(clientId);
        client.setName("Test");

        given(clientService.findById(clientId)).willReturn(client);

        this.mockMvc.perform(get("/clients/{id}", clientId))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id").value(clientId))
                .andExpect((ResultMatcher) jsonPath("$.name").value("Test"));
    }

    @Test
    public void testCreateClient() throws Exception {
        ClientDataCreate newClientData = new ClientDataCreate("TESTE", "12341234");

        ObjectMapper objectMapper = new ObjectMapper();
        String newClientDataJson = objectMapper.writeValueAsString(newClientData);

        this.mockMvc.perform(post("/client")
                .contentType("application/json")
                .content(newClientDataJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateClient() throws Exception {

    }

    @Test
    public void testDeleteClientById() throws Exception {
        //given
        Long clientId = 1L;
        Client client = new Client();
        client.setName("Rua");
        client.setZipCode("11111111");

        //when
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/clients/1"))
                .andExpect(MockMvcResultMatchers
                        //then
                        .status().isNoContent());
    }
}
