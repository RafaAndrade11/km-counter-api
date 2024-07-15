package me.kmcounter.dtos.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientDataCreate(
        @NotBlank(message = "Name is mandatory!") String name,
        @NotNull(message = "Zip Code cannot be null!") String zipCode
) {
}
