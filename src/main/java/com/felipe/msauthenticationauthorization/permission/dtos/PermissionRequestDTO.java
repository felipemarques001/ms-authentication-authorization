package com.felipe.msauthenticationauthorization.permission.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PermissionRequestDTO(
        @NotBlank(message = "The value of 'name' cannot be empty")
        String name,
        @NotNull(message = "The value of 'active' cannot be empty")
        Boolean active
) {
}
