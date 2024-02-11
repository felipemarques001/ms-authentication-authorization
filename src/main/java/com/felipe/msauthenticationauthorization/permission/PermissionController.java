package com.felipe.msauthenticationauthorization.permission;

import com.felipe.msauthenticationauthorization.permission.dtos.PermissionRequestDTO;
import com.felipe.msauthenticationauthorization.permission.dtos.PermissionResponseDTO;
import com.felipe.msauthenticationauthorization.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/permissions")
public class PermissionController {

    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<APIGlobalResponseDTO> create(@RequestBody @Valid PermissionRequestDTO dto) {
        PermissionResponseDTO response = service.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new APIGlobalResponseDTO(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> findById(@PathVariable UUID id) {
        PermissionResponseDTO response = service.findById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(response));
    }

    @GetMapping
    public ResponseEntity<APIGlobalResponseDTO> findAll() {
        List<PermissionResponseDTO> response = service.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> updateById(@RequestBody @Valid PermissionRequestDTO dto,
                                                           @PathVariable UUID id) {
        PermissionResponseDTO response = service.updateById(dto, id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> deleteById(@PathVariable UUID id) {
        service.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
