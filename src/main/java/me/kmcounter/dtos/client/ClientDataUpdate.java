package me.kmcounter.dtos.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientDataUpdate(
        @NotNull(message = "Id cannot be null!") Long id,
        String name,
        String zipCode
) {
}
