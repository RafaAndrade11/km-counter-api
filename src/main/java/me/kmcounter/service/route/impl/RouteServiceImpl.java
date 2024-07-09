package me.kmcounter.service.route.impl;

import jakarta.persistence.EntityNotFoundException;
import me.kmcounter.domain.model.Client;
import me.kmcounter.domain.model.Route;
import me.kmcounter.domain.repository.ClientRepository;
import me.kmcounter.domain.repository.RouteRepository;
import me.kmcounter.dtos.route.RouteDataCreate;
import me.kmcounter.service.distance.DistanceMatrixService;
import me.kmcounter.service.route.RouteService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ClientRepository clientRepository;
    private final DistanceMatrixService distanceMatrixService;

    public RouteServiceImpl(RouteRepository routeRepository, ClientRepository clientRepository, DistanceMatrixService distanceMatrixService) {
        this.routeRepository = routeRepository;
        this.clientRepository = clientRepository;
        this.distanceMatrixService = distanceMatrixService;
    }
    @Override
    public Route createNewRoute(RouteDataCreate data) throws Exception {
        Client originClient = clientRepository.findById(data.originClient().getId())
                .orElseThrow(() -> new EntityNotFoundException("Origin client not found!"));
        Client destinationClient = clientRepository.findById(data.destinationClient().getId())
                .orElseThrow(() -> new EntityNotFoundException("Destination client not found!"));

        double distance = distanceMatrixService.getDistance(originClient.getZipCode(), destinationClient.getZipCode()); // Será implementado com a API do Google

        Route route = new Route(originClient, destinationClient, distance);
        return routeRepository.save(route);
    }

    @Override
    public Route findById(Long id) {
        return routeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteRouteById(Long id) {
        routeRepository.deleteById(id);
    }

}
