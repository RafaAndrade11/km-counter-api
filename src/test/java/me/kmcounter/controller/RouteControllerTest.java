package me.kmcounter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kmcounter.controllers.RouteController;
import me.kmcounter.domain.model.Client;
import me.kmcounter.domain.model.Route;
import me.kmcounter.dtos.route.RouteDataCreate;
import me.kmcounter.service.route.RouteService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RouteController.class)
public class RouteControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RouteService routeService;

    @Test
    public void testFindById() throws Exception {
        Client originClient = new Client("Client Test", "11112222");
        originClient.setId(1L);
        Client destinationClient = new Client("Client Test", "11113333");
        destinationClient.setId(2L);

        RouteDataCreate routeDataCreate = new RouteDataCreate(originClient, destinationClient);

        Route createdRoute = new Route(routeDataCreate);
        createdRoute.setId(1L);

        when(routeService.findById(1L)).thenReturn(createdRoute);

        mockMvc.perform(get("/routes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(routeDataCreate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));

        verify(routeService, times(1)).findById(createdRoute.getId());
    }
    @Test
    public void testCreateRoute() throws Exception {
        Client originClient = new Client("Client Test", "11112222");
        originClient.setId(1L);
        Client destinationClient = new Client("Client Test", "11113333");
        destinationClient.setId(2L);

        RouteDataCreate routeDataCreate = new RouteDataCreate(originClient, destinationClient);

        Route createdRoute = new Route(routeDataCreate);
        createdRoute.setId(1L);

        when(routeService.createNewRoute(routeDataCreate)).thenReturn(createdRoute);

        mockMvc.perform(post("/routes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(routeDataCreate)))
                .andExpect(status().isOk());
    }
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
