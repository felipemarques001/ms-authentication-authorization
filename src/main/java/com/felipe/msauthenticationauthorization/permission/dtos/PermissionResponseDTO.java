package com.felipe.msauthenticationauthorization.permission.dtos;

import com.felipe.msauthenticationauthorization.permission.Permission;

import java.util.UUID;

public record PermissionResponseDTO(
        UUID id,
        String name,
        Boolean active
) {

    public static PermissionResponseDTO createPermissionResponseDTO(Permission permission) {
        return new PermissionResponseDTO(
                permission.getId(),
                permission.getName(),
                permission.getActive()
        );
    }
}
