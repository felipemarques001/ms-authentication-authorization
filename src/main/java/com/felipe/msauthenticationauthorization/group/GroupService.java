package com.felipe.msauthenticationauthorization.group;

import com.felipe.msauthenticationauthorization.application.ApplicationRepository;
import com.felipe.msauthenticationauthorization.exceptions.FieldAlreadyInUseException;
import com.felipe.msauthenticationauthorization.exceptions.ResourceNotFoundException;
import com.felipe.msauthenticationauthorization.group.dtos.GroupRequestDTO;
import com.felipe.msauthenticationauthorization.group.dtos.GroupResponseDTO;
import com.felipe.msauthenticationauthorization.permission.Permission;
import com.felipe.msauthenticationauthorization.permission.PermissionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final ApplicationRepository applicationRepository;
    private final PermissionRepository permissionRepository;

    public GroupService(GroupRepository groupRepository,
                        ApplicationRepository applicationRepository,
                        PermissionRepository permissionRepository) {
        this.groupRepository = groupRepository;
        this.applicationRepository = applicationRepository;
        this.permissionRepository = permissionRepository;
    }

    @Transactional
    public GroupResponseDTO create(GroupRequestDTO dto) {
        // Find the application
        var applicationOp = applicationRepository.findByAccessKey(dto.accessKey());
        if(applicationOp.isEmpty())
            throw new ResourceNotFoundException("Application", "access key", dto.accessKey());

        // Verify if there is a group with the same name at the founded application
        var foundedGroup = groupRepository
                .findByNameAndApplicationId(dto.name(), applicationOp.get().getId());
        if(foundedGroup.isPresent())
            throw new FieldAlreadyInUseException("name", dto.name());

        // Find all permissions and save in a list
        var groupPermissions = new ArrayList<Permission>();
        for(UUID id : dto.permissionIds()) {
            var permissionOp = permissionRepository.findById(id);
            if(permissionOp.isEmpty())
                throw new ResourceNotFoundException("Permission", "ID", id.toString());

            groupPermissions.add(permissionOp.get());
        }

        // Save the group in the database and return a response DTO
        var newGroup = new Group(dto.name(), applicationOp.get(), groupPermissions);
        var savedGroup = groupRepository.save(newGroup);

        return GroupResponseDTO
                .createGroupResponseDTO(savedGroup);
    }

    public GroupResponseDTO findById(UUID id) {
        var groupOp = groupRepository.findById(id);
        if(groupOp.isEmpty())
            throw new ResourceNotFoundException("Group", "ID", id.toString());

        return GroupResponseDTO
                .createGroupResponseDTO(groupOp.get());
    }

    public List<GroupResponseDTO> findAll() {
        var groupResponseDTOList = new ArrayList<GroupResponseDTO>();
        var savedGroupList = groupRepository.findAll();

        savedGroupList.forEach(group ->
            groupResponseDTOList
                    .add(GroupResponseDTO
                            .createGroupResponseDTO(group)
                    )
        );

        return groupResponseDTOList;
    }

    @Transactional
    public GroupResponseDTO updateById(GroupRequestDTO dto, UUID id) {
        var groupOp = groupRepository.findById(id);
        if(groupOp.isEmpty())
            throw new ResourceNotFoundException("Group", "ID", id.toString());

        // Find the application
        var applicationOp = applicationRepository.findByAccessKey(dto.accessKey());
        if(applicationOp.isEmpty())
            throw new ResourceNotFoundException("Application", "access key", dto.accessKey());

        // Verify if there is a group with the same name at the founded application
        var foundedGroup = groupRepository
                .findByNameAndApplicationId(dto.name(), applicationOp.get().getId());
        if(foundedGroup.isPresent() && !(foundedGroup.equals(groupOp)))
            throw new FieldAlreadyInUseException("name", dto.name());

        // Find all permissions and save in a list
        var groupPermissions = new ArrayList<Permission>();
        for(UUID pId : dto.permissionIds()) {
            var permissionOp = permissionRepository.findById(pId);
            if(permissionOp.isEmpty())
                throw new ResourceNotFoundException("Permission", "ID", pId.toString());

            groupPermissions.add(permissionOp.get());
        }

        groupOp.get().setName(dto.name());
        groupOp.get().setApplication(applicationOp.get());
        groupOp.get().setPermissions(groupPermissions);

        var updatedGroup = groupRepository.save(groupOp.get());

        return GroupResponseDTO
                .createGroupResponseDTO(updatedGroup);
    }

    @Transactional
    public void deleteById(UUID id) {
        if(!(groupRepository.existsById(id)))
            throw new ResourceNotFoundException("Group", "ID", id.toString());

        groupRepository.deleteById(id);
    }
}
