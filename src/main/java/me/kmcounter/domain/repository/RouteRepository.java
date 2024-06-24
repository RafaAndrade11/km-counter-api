package me.kmcounter.domain.repository;

import me.kmcounter.domain.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
