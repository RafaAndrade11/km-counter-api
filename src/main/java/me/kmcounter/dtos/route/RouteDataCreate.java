package me.kmcounter.dtos.route;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import me.kmcounter.domain.model.Client;

public record RouteDataCreate(
        @NotNull(message = "Origin Client cannot be null!") Client originClient,
        @NotNull(message = "Origin Client cannot be null!")Client destinationClient
) {
}
