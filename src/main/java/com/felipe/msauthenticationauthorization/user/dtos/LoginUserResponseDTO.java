package com.felipe.msauthenticationauthorization.user.dtos;

import com.felipe.msauthenticationauthorization.permission.Permission;

import java.util.List;

public record LoginUserResponseDTO(
        List<String> permissions,
        String jwtToken
) {
}
