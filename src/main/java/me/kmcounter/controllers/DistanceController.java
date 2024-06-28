package me.kmcounter.controllers;

import me.kmcounter.service.distance.GeocodingService;
import me.kmcounter.service.distance.OpenRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {

    @Autowired
    private GeocodingService geocodingService;

    @Autowired
    private OpenRouteService openRouteService;

    @GetMapping("/distance")
    public double getDistance(@RequestParam String startCep, @RequestParam String endCep) {
        try {
            String startCoordinates = geocodingService.getCoordinatesFromCep(startCep);
            String endCoordinates = geocodingService.getCoordinatesFromCep(endCep);
            return openRouteService.getDistance(startCoordinates, endCoordinates);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
