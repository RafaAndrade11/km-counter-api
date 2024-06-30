package me.kmcounter.controllers;

import me.kmcounter.service.distance.DistanceMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {

    @Autowired
    private DistanceMatrixService distanceMatrixService;

    @GetMapping("/distance")
    public long getDistance(@RequestParam String origin, @RequestParam String destination) {
        try {
            return distanceMatrixService.getDistance(origin, destination);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
