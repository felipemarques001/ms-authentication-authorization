package com.felipe.msauthenticationauthorization.user;

import com.felipe.msauthenticationauthorization.user.dtos.LoginUserRequestDTO;
import com.felipe.msauthenticationauthorization.user.dtos.LoginUserResponseDTO;
import com.felipe.msauthenticationauthorization.user.dtos.UserRequestDTO;
import com.felipe.msauthenticationauthorization.user.dtos.UserResponseDTO;
import com.felipe.msauthenticationauthorization.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<APIGlobalResponseDTO> create(@RequestBody @Valid UserRequestDTO dto) {
        UserResponseDTO response = service.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new APIGlobalResponseDTO(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> findById(@PathVariable UUID id) {
        UserResponseDTO response = service.findById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(response));
    }

    @GetMapping
    public ResponseEntity<APIGlobalResponseDTO> findAll() {
        List<UserResponseDTO> response = service.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> updateById(@RequestBody @Valid UserRequestDTO dto,
                                                           @PathVariable UUID id) {
        UserResponseDTO response = service.updateById(dto, id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        service.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PostMapping("/login")
    public ResponseEntity<APIGlobalResponseDTO> login(@RequestBody @Valid LoginUserRequestDTO dto) {
        LoginUserResponseDTO jwtToken = service.loginUser(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(jwtToken));
    }

    @GetMapping("/verify-permission/{permission}")
    public ResponseEntity<Void> verifyPermission(@PathVariable String permission) {
        boolean authorized = service.verifyPermission(permission);

        return authorized
                ? ResponseEntity.status(HttpStatus.OK).build()
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
