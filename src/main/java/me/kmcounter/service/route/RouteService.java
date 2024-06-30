package me.kmcounter.service.route;

import me.kmcounter.domain.model.Route;
import me.kmcounter.dtos.RouteDataCreate;
import me.kmcounter.dtos.RouteDataUpdate;

public interface RouteService {

    Route createNewRoute (RouteDataCreate route) throws Exception;

    Route findById(Long id);

    void deleteRouteById(Long id);

}
