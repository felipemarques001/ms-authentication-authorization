package com.felipe.msauthenticationauthorization.application;

import com.felipe.msauthenticationauthorization.application.dtos.ApplicationRequestDTO;
import com.felipe.msauthenticationauthorization.application.dtos.ApplicationResponseDTO;
import com.felipe.msauthenticationauthorization.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<APIGlobalResponseDTO> create(@RequestBody @Valid ApplicationRequestDTO dto) {
        ApplicationResponseDTO response = service.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new APIGlobalResponseDTO(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> findById(@PathVariable UUID id) {
        ApplicationResponseDTO response = service.findById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(response));
    }

    @GetMapping
    public ResponseEntity<APIGlobalResponseDTO> findAll() {
        List<ApplicationResponseDTO> response = service.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> updateById(@RequestBody @Valid ApplicationRequestDTO dto,
                                                           @PathVariable UUID id) {
        ApplicationResponseDTO response = service.updateById(dto, id);

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
