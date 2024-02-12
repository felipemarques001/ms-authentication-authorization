package com.felipe.msauthenticationauthorization.group.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.UUID;

public record GroupRequestDTO(
        @NotBlank(message = "The value of 'name' cannot be empty")
        String name,
        @NotBlank(message = "The value of 'access key' cannot be empty")
        String accessKey,
        @NotEmpty(message = "In order to create a group is necessary sent at least one permission")
        List<UUID> permissionIds
) {
}