package com.felipe.msauthenticationauthorization.application;

import com.felipe.msauthenticationauthorization.application.dtos.ApplicationRequestDTO;
import com.felipe.msauthenticationauthorization.application.dtos.ApplicationResponseDTO;
import com.felipe.msauthenticationauthorization.exceptions.FieldAlreadyInUseException;
import com.felipe.msauthenticationauthorization.exceptions.ResourceNotFoundException;
import com.felipe.msauthenticationauthorization.group.Group;
import com.felipe.msauthenticationauthorization.group.GroupRepository;
import com.felipe.msauthenticationauthorization.group.GroupService;
import com.felipe.msauthenticationauthorization.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public ApplicationService(ApplicationRepository applicationRepository,
                              GroupRepository groupRepository,
                              UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public ApplicationResponseDTO create(ApplicationRequestDTO dto) {
        if(applicationRepository.existsByAccessKey(dto.accessKey()))
            throw new FieldAlreadyInUseException("access key", dto.accessKey());

        var savedApplication = applicationRepository.save(new Application(dto));

        return ApplicationResponseDTO
                .createApplicationResponseDTO(savedApplication);
    }

    public ApplicationResponseDTO findById(UUID id) {
        var applicationOp = applicationRepository.findById(id);
        if(applicationOp.isEmpty())
            throw new ResourceNotFoundException("Application", "ID", id.toString());

        return ApplicationResponseDTO
                .createApplicationResponseDTO(applicationOp.get());
    }

    public List<ApplicationResponseDTO> findAll() {
        var applicationResponseDTOList = new ArrayList<ApplicationResponseDTO>();
        var savedApplicationList = applicationRepository.findAll();

        savedApplicationList.forEach(application ->
                applicationResponseDTOList
                        .add(ApplicationResponseDTO
                                .createApplicationResponseDTO(application)
                        )
        );

        return applicationResponseDTOList;
    }

    @Transactional
    public ApplicationResponseDTO updateById(ApplicationRequestDTO dto, UUID id){
        if(applicationRepository.existsByAccessKey(dto.accessKey()))
            throw new FieldAlreadyInUseException("access key", dto.accessKey());

        var applicationOp = applicationRepository.findById(id);
        if(applicationOp.isEmpty())
            throw new ResourceNotFoundException("Application", "ID", id.toString());

        applicationOp.get().setName(dto.name());
        applicationOp.get().setAccessKey(dto.accessKey());

        var updatedApplication = applicationRepository.save(applicationOp.get());

        return ApplicationResponseDTO
                .createApplicationResponseDTO(updatedApplication);
    }

    @Transactional
    public void deleteById(UUID id) {
        if(!applicationRepository.existsById(id))
            throw new ResourceNotFoundException("Application", "ID", id.toString());

        var applicationUsers = userRepository.findByApplicationId(id);
        applicationUsers.forEach(user ->
                userRepository.deleteById(user.getId())
        );

        List<Group> applicationGroups = groupRepository.findByApplicationId(id);
        applicationGroups.forEach(group ->
            groupRepository.deleteById(group.getId())
        );

        applicationRepository.deleteById(id);
    }
}
