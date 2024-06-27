package me.kmcounter.dtos;

import jakarta.validation.constraints.NotBlank;
import me.kmcounter.domain.model.Client;

public record RouteDataCreate(
        Client originClient,
        Client destinationClient
) {
}
