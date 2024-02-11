package com.felipe.msauthenticationauthorization.application.dtos;

import com.felipe.msauthenticationauthorization.application.Application;

import java.util.UUID;

public record ApplicationResponseDTO (
        UUID id,
        String name,
        String accessKey
){
    public static ApplicationResponseDTO createApplicationResponseDTO(Application application) {
        return new ApplicationResponseDTO(
                application.getId(),
                application.getName(),
                application.getAccessKey()
        );
    }
}
