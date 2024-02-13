package com.felipe.msauthenticationauthorization.user.dtos;

import com.felipe.msauthenticationauthorization.application.Application;
import com.felipe.msauthenticationauthorization.group.Group;
import com.felipe.msauthenticationauthorization.user.User;

import java.util.List;
import java.util.UUID;

public record UserResponseDTO (
        UUID id,
        String name,
        String username,
        String applicationName,
        List<Group> groups
){
    public static UserResponseDTO createUserResponseDTO(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getName(),
            user.getUsername(),
            user.getApplication().getName(),
            user.getGroups()
        );
    }
}
