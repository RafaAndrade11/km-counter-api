package me.kmcounter.controllers;

import jakarta.validation.Valid;
import me.kmcounter.domain.model.Route;
import me.kmcounter.dtos.route.RouteDataCreate;
import me.kmcounter.service.route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> findById(@PathVariable Long id) {

        return ResponseEntity.ok(routeService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody @Valid RouteDataCreate routeDataCreate) throws Exception {

        routeService.createNewRoute(routeDataCreate);

        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Route> deleteRouteById(@RequestBody Long id) throws Exception {

        routeService.deleteRouteById(id);

        return ResponseEntity.noContent().build();
    }
}
