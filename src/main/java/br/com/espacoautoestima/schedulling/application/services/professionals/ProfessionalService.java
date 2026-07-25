package br.com.espacoautoestima.schedulling.application.services.professionals;

import br.com.espacoautoestima.schedulling.application.adapters.dto.professional.ProfessionalDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.professional.ProfessionalDTOResponse;
import br.com.espacoautoestima.schedulling.application.infrastructure.repositories.ProfessionalRepository;
import br.com.espacoautoestima.schedulling.application.mappers.professionals.ProfessionalRequestMapper;
import br.com.espacoautoestima.schedulling.application.mappers.professionals.ProfessionalResponseMapper;
import br.com.espacoautoestima.schedulling.application.model.entities.ProfessionalEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {

    private final ProfessionalRepository professionalRepository;
    private final ProfessionalRequestMapper professionalRequestMapper;
    private final ProfessionalResponseMapper professionalResponseMapper;

    public ProfessionalService(ProfessionalRepository professionalRepository, ProfessionalRequestMapper professionalRequestMapper, ProfessionalResponseMapper professionalResponseMapper) {
        this.professionalRepository = professionalRepository;
        this.professionalRequestMapper = professionalRequestMapper;
        this.professionalResponseMapper = professionalResponseMapper;
    }

    public List<ProfessionalDTOResponse> getAllProfessionals() {
        List<ProfessionalEntity> professionalEntity = professionalRepository.findAll();
        return professionalEntity.stream()
                .map(professionalResponseMapper::toDtoResponse)
                .toList();
    }

    public ProfessionalDTOResponse getProfessionalById(Long professionalId) {
        ProfessionalEntity professionalEntity = professionalRepository.findById(professionalId)
                .orElseThrow(() -> new RuntimeException("Professional not found for search"));
        return professionalResponseMapper.toDtoResponse(professionalEntity);
    }

    public List<ProfessionalDTOResponse> getProfessionalByName(String name) {
        List<ProfessionalEntity> professionalEntity = professionalRepository.findByName(name);
        return professionalEntity.stream()
                .map(professionalResponseMapper::toDtoResponse)
                .toList();
    }

    @Transactional
    public void createProfessional(ProfessionalDTORequest professional) {
        ProfessionalEntity newProfessional = professionalRequestMapper.saveEntityFromDto(professional);
        professionalRepository.save(newProfessional);
    }

    @Transactional
    public void updateProfessional(Long professionalId, ProfessionalDTORequest professional) {
        ProfessionalEntity existingProfessional = professionalRepository.findById(professionalId)
                .orElseThrow(() -> new RuntimeException("Professional not found for update"));
        professionalRequestMapper.updateFromEntity(professional, existingProfessional);
        ProfessionalEntity updatedProfessional = existingProfessional;
        professionalRepository.save(updatedProfessional);
    }

    public void deleteProfessional(Long professionalId) {
        ProfessionalEntity existingProfessional = professionalRepository
                .findById(professionalId)
                .orElseThrow(() -> new RuntimeException("Professional not found for delete"));
        professionalRepository.delete(existingProfessional);
    }
}
