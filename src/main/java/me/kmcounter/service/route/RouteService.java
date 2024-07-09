package me.kmcounter.service.route;

import me.kmcounter.domain.model.Route;
import me.kmcounter.dtos.route.RouteDataCreate;

public interface RouteService {

    Route createNewRoute (RouteDataCreate route) throws Exception;

    Route findById(Long id);

    void deleteRouteById(Long id);

}
