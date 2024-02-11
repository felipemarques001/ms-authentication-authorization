package com.felipe.msauthenticationauthorization.application.dtos;

import jakarta.validation.constraints.NotBlank;

public record ApplicationRequestDTO (
        @NotBlank(message = "The value of name cannot be empty")
        String name,

        @NotBlank(message = "The value of access key cannot be empty")
        String accessKey
){
}
