package me.kmcounter.dtos.route;

import jakarta.validation.constraints.NotBlank;
import me.kmcounter.domain.model.Client;

public record RouteDataCreate(
        Client originClient,
        Client destinationClient
) {
}
