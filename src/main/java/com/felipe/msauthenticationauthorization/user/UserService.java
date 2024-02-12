package com.felipe.msauthenticationauthorization.user;

import com.felipe.msauthenticationauthorization.application.ApplicationRepository;
import com.felipe.msauthenticationauthorization.exceptions.FieldAlreadyInUseException;
import com.felipe.msauthenticationauthorization.exceptions.GroupNotBelongApplicationException;
import com.felipe.msauthenticationauthorization.exceptions.ResourceNotFoundException;
import com.felipe.msauthenticationauthorization.exceptions.UserNotBelongApplicationException;
import com.felipe.msauthenticationauthorization.group.Group;
import com.felipe.msauthenticationauthorization.group.GroupRepository;
import com.felipe.msauthenticationauthorization.user.dtos.UserRequestDTO;
import com.felipe.msauthenticationauthorization.user.dtos.UserResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;
    private final GroupRepository groupRepository;

    public UserService(UserRepository userRepository,
                       ApplicationRepository applicationRepository,
                       GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.applicationRepository = applicationRepository;
        this.groupRepository = groupRepository;
    }

    @Transactional
    public UserResponseDTO create(UserRequestDTO dto) {
        var applicationOp = applicationRepository.findByAccessKey(dto.accessKey());
        if(applicationOp.isEmpty())
            throw new ResourceNotFoundException("Application", "access key", dto.accessKey());

        var userOp = userRepository
                .findByUsernameAndApplicationId(dto.username(), applicationOp.get().getId());
        if(userOp.isPresent())
            throw new FieldAlreadyInUseException("username", dto.username());

        // Verify if the groups exist and if they belong at the application of context
        var userGroups = new ArrayList<Group>();
        for(UUID id : dto.groupIds()) {
            var groupOp = groupRepository.findById(id);

            if(groupOp.isEmpty())
                throw new ResourceNotFoundException("Group", "ID", id.toString());

            if(!(groupOp.get().getApplication().equals(applicationOp.get())))
                throw new GroupNotBelongApplicationException();

            userGroups.add(groupOp.get());
        }

        var newUser = new User(dto, applicationOp.get(), userGroups);
        var savedUser = userRepository.save(newUser);

        return UserResponseDTO
                .createUserResponseDTO(savedUser);
    }

    public UserResponseDTO findById(UUID id) {
        var userOp = userRepository.findById(id);
        if(userOp.isEmpty())
            throw new ResourceNotFoundException("User", "ID", id.toString());

        return UserResponseDTO
                .createUserResponseDTO(userOp.get());
    }

    public List<UserResponseDTO> findAll() {
        var userResponseDTOList = new ArrayList<UserResponseDTO>();
        var savedUserList = userRepository.findAll();

        savedUserList.forEach(user ->
            userResponseDTOList
                    .add(UserResponseDTO
                            .createUserResponseDTO(user)
                    )
        );

        return userResponseDTOList;
    }

    @Transactional
    public UserResponseDTO updateById(UserRequestDTO dto, UUID id) {
        // Verify if there is an application with the access key sent
        var applicationOp = applicationRepository.findByAccessKey(dto.accessKey());
        if(applicationOp.isEmpty())
            throw new ResourceNotFoundException("Application", "access key", dto.accessKey());

        // Verify if there is an application with the ID sent
        var userOp = userRepository.findById(id);
        if(userOp.isEmpty())
            throw new ResourceNotFoundException("User", "ID", id.toString());

        // Verify if there is a user at the application with the data sent
        if(!userOp.get().getApplication().equals(applicationOp.get()))
            throw new UserNotBelongApplicationException();

        // Verify if there is a user with same name (that was sent in the DTO) at the application of context
        var userWithSameNameOp = userRepository
                .findByUsernameAndApplicationId(dto.username(), applicationOp.get().getId());
        if(userWithSameNameOp.isPresent() && !(userWithSameNameOp.get().equals(userOp.get())))
            throw new FieldAlreadyInUseException("username", dto.username());

        // Verify if the groups exist and if they belong at the application of context
        var userGroups = new ArrayList<Group>();
        for(UUID groupId : dto.groupIds()) {
            var groupOp = groupRepository.findById(groupId);

            if(groupOp.isEmpty())
                throw new ResourceNotFoundException("Group", "ID", groupId.toString());

            if(!(groupOp.get().getApplication().equals(applicationOp.get())))
                throw new GroupNotBelongApplicationException();

            userGroups.add(groupOp.get());
        }

        userOp.get().setName(dto.name());
        userOp.get().setUsername(dto.username());
        userOp.get().setPassword(dto.password());
        userOp.get().setGroups(userGroups);

        var updatedUser = userRepository.save(userOp.get());

        return UserResponseDTO
                .createUserResponseDTO(updatedUser);
    }

    @Transactional
    public void deleteById(UUID id) {
        if(!(userRepository.existsById(id)))
            throw new ResourceNotFoundException("User", "ID", id.toString());

        userRepository.deleteById(id);
    }
}
