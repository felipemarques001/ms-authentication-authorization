package com.felipe.msauthenticationauthorization.permission;

import com.felipe.msauthenticationauthorization.exceptions.ResourceNotFoundException;
import com.felipe.msauthenticationauthorization.permission.dtos.PermissionRequestDTO;
import com.felipe.msauthenticationauthorization.permission.dtos.PermissionResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Transactional
    public PermissionResponseDTO create(PermissionRequestDTO dto) {
        // Handling the permission name
        String permissionName = dto.name().trim();
        permissionName = permissionName.replace(" ", "-");

        var newPermission = new Permission(permissionName, dto.active());
        var savedPermission = permissionRepository.save(newPermission);

        return PermissionResponseDTO
                .createPermissionResponseDTO(savedPermission);
    }

    public PermissionResponseDTO findById(UUID id) {
        var permissionOp = permissionRepository.findById(id);
        if(permissionOp.isEmpty())
            throw new ResourceNotFoundException("Permission", "ID", id.toString());

        return PermissionResponseDTO
                .createPermissionResponseDTO(permissionOp.get());
    }

    public List<PermissionResponseDTO> findAll() {
        var permissionResponseDTOList = new ArrayList<PermissionResponseDTO>();
        var savedApplicationList = permissionRepository.findAll();

        savedApplicationList.forEach(application ->
            permissionResponseDTOList
                    .add(PermissionResponseDTO
                            .createPermissionResponseDTO(application)
                    )
        );

        return permissionResponseDTOList;
    }

    @Transactional
    public PermissionResponseDTO updateById(PermissionRequestDTO dto, UUID id) {
        var permissionOp = permissionRepository.findById(id);
        if(permissionOp.isEmpty())
            throw new ResourceNotFoundException("Permission", "ID", id.toString());

        permissionOp.get().setName(dto.name());
        permissionOp.get().setActive(dto.active());

        var updatedPermission = permissionRepository.save(permissionOp.get());

        return PermissionResponseDTO
                .createPermissionResponseDTO(updatedPermission);
    }

    @Transactional
    public void deleteById(UUID id) {
        if(!(permissionRepository.existsById(id)))
            throw new ResourceNotFoundException("Permission", "ID", id.toString());

        permissionRepository.deleteById(id);
    }
}
