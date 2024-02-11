package com.felipe.msauthenticationauthorization.application;

import com.felipe.msauthenticationauthorization.application.dtos.ApplicationRequestDTO;
import com.felipe.msauthenticationauthorization.application.dtos.ApplicationResponseDTO;
import com.felipe.msauthenticationauthorization.exceptions.FieldAlreadyInUseException;
import com.felipe.msauthenticationauthorization.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
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
        if(!(applicationRepository.existsById(id)))
            throw new ResourceNotFoundException("Application", "ID", id.toString());

        applicationRepository.deleteById(id);
    }
}
