package com.felipe.msauthenticationauthorization.user.dtos;

import com.felipe.msauthenticationauthorization.group.Group;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record UserRequestDTO (

        @NotBlank(message = "The value of 'name' cannot be empty")
        String name,

        @NotBlank(message = "The value of 'username' cannot be empty")
        String username,

        @NotBlank(message = "The value of 'password' cannot be empty")
        String password,

        @NotBlank(message = "The value of 'access key' cannot be empty")
        String accessKey,

        @NotEmpty(message = "In order to create a user is necessary sent at least one group")
        List<Group>groups
){
}
