package com.felipe.msauthenticationauthorization.group;

import com.felipe.msauthenticationauthorization.group.dtos.GroupRequestDTO;
import com.felipe.msauthenticationauthorization.group.dtos.GroupResponseDTO;
import com.felipe.msauthenticationauthorization.utils.APIGlobalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    private final GroupService service;


    public GroupController(GroupService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<APIGlobalResponseDTO> create(@RequestBody @Valid GroupRequestDTO dto) {
        GroupResponseDTO response = service.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new APIGlobalResponseDTO(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> findById(@PathVariable UUID id) {
        GroupResponseDTO response = service.findById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(response));
    }

    @GetMapping
    public ResponseEntity<APIGlobalResponseDTO> findAll() {
        List<GroupResponseDTO> response = service.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new APIGlobalResponseDTO(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIGlobalResponseDTO> updateById(@RequestBody @Valid GroupRequestDTO dto,
                                                           @PathVariable UUID id) {
        var response = service.updateById(dto, id);

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
}
