package me.kmcounter.controller;

import me.kmcounter.controllers.DistanceController;
import me.kmcounter.domain.model.Client;
import me.kmcounter.service.distance.DistanceMatrixService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DistanceController.class)
public class DistanceControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DistanceMatrixService distanceMatrixService;

    @Test
    public void getDistanceTest() throws Exception{
        Client originClient = new Client("Rua Arara", "26030130");
        Client destinationClient = new Client("Rua Tomaso Tome", "09571340");
        originClient.setId(1l);
        destinationClient.setId(2l);

        long result = 431;

        when(distanceMatrixService.getDistance(originClient.getZipCode(), destinationClient.getZipCode())).thenReturn(result);


    }
}
