package me.kmcounter.dtos.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientDataUpdate(
        @NotNull Long id,
        String name,
        String zipCode
) {
}
