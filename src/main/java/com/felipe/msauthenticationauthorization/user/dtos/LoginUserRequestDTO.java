package com.felipe.msauthenticationauthorization.user.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginUserRequestDTO(
        @NotBlank(message = "The value of 'username' cannot be empty")
        String username,

        @NotBlank(message = "The value of 'password' cannot be empty")
        String password,

        @NotBlank(message = "The value of 'access key' cannot be empty")
        String accessKey
) {
}
