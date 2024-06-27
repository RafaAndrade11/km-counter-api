package me.kmcounter.service.route.impl;

import jakarta.persistence.EntityNotFoundException;
import me.kmcounter.domain.model.Client;
import me.kmcounter.domain.model.Route;
import me.kmcounter.domain.repository.ClientRepository;
import me.kmcounter.domain.repository.RouteRepository;
import me.kmcounter.dtos.RouteDataCreate;
import me.kmcounter.dtos.RouteDataUpdate;
import me.kmcounter.service.route.RouteService;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;

    private ClientRepository clientRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
    @Override
    public Route createNewRoute(RouteDataCreate data) {
//        Client originClient = clientRepository.findById(data.originClient().getId())
//                .orElseThrow(() -> new EntityNotFoundException("Origin client not found!"));
//        Client destinationClient = clientRepository.findById(data.destinationClient().getId())
//                .orElseThrow(() -> new EntityNotFoundException("Destination client not found!"));

//        double distance = 123; //will be implemented with Google api

//        RouteDataCreate route = new RouteDataCreate(originClient, destinationClient, distance);
        return routeRepository.save(new Route(data));

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
