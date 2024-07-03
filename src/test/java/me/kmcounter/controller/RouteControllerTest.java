package me.kmcounter.controller;

import me.kmcounter.controllers.RouteController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RouteController.class)
public class RouteControllerTest {
    @Autowired
    private MockMvc mockMvc;

}
