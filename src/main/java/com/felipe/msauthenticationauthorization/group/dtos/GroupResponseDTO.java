package com.felipe.msauthenticationauthorization.group.dtos;

import com.felipe.msauthenticationauthorization.application.Application;
import com.felipe.msauthenticationauthorization.group.Group;
import com.felipe.msauthenticationauthorization.permission.Permission;

import java.util.List;
import java.util.UUID;

public record GroupResponseDTO(
        UUID id,
        String name,
        Application application,
        List<Permission> permissions
) {
    public static GroupResponseDTO createGroupResponseDTO(Group group) {
        return new GroupResponseDTO(
                group.getId(),
                group.getName(),
                group.getApplication(),
                group.getPermissions()
        );
    }
}
