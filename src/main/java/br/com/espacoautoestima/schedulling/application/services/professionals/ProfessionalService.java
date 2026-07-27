package br.com.espacoautoestima.schedulling.application.services.professionals;

import br.com.espacoautoestima.schedulling.application.adapters.dto.professional.ProfessionalDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.professional.ProfessionalDTOResponse;
import br.com.espacoautoestima.schedulling.application.infrastructure.repositories.ProfessionalRepository;
import br.com.espacoautoestima.schedulling.application.mappers.professionals.ProfessionalRequestMapper;
import br.com.espacoautoestima.schedulling.application.mappers.professionals.ProfessionalResponseMapper;
import br.com.espacoautoestima.schedulling.application.model.entities.ProfessionalEntity;
import br.com.espacoautoestima.schedulling.application.services.products.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProfessionalService {

    private final ProfessionalRepository professionalRepository;
    private final ProfessionalRequestMapper professionalRequestMapper;
    private final ProfessionalResponseMapper professionalResponseMapper;

    private Logger logger = Logger.getLogger(ProfessionalService.class.getName());

    public ProfessionalService(ProfessionalRepository professionalRepository, ProfessionalRequestMapper professionalRequestMapper, ProfessionalResponseMapper professionalResponseMapper) {
        this.professionalRepository = professionalRepository;
        this.professionalRequestMapper = professionalRequestMapper;
        this.professionalResponseMapper = professionalResponseMapper;
    }

    public List<ProfessionalDTOResponse> getAllProfessionals() {
        logger.info("Listing all professionals:");
        List<ProfessionalEntity> professionalEntity = professionalRepository.findAll();
        return professionalEntity.stream()
                .map(professionalResponseMapper::toDtoResponse)
                .toList();
    }

    public ProfessionalDTOResponse getProfessionalById(Long professionalId) {
        logger.info("Searching for professional by ID:");
        ProfessionalEntity professionalEntity = professionalRepository.findById(professionalId)
                .orElseThrow(() -> new RuntimeException("Professional not found for search"));
        return professionalResponseMapper.toDtoResponse(professionalEntity);
    }

    public List<ProfessionalDTOResponse> getProfessionalByName(String name) {
        logger.info("Searching for professional by name:");
        List<ProfessionalEntity> professionalEntity = professionalRepository.findByName(name);
        return professionalEntity.stream()
                .map(professionalResponseMapper::toDtoResponse)
                .toList();
    }

    @Transactional
    public void createProfessional(ProfessionalDTORequest professional) {
        logger.info("Creating new professional:");
        ProfessionalEntity newProfessional = professionalRequestMapper.saveEntityFromDto(professional);
        professionalRepository.save(newProfessional);
    }

    @Transactional
    public void updateProfessional(Long professionalId, ProfessionalDTORequest professional) {
        logger.info("Updating professional:");
        ProfessionalEntity existingProfessional = professionalRepository.findById(professionalId)
                .orElseThrow(() -> new RuntimeException("Professional not found for update"));
        professionalRequestMapper.updateFromEntity(professional, existingProfessional);
        professionalRepository.save(existingProfessional);
    }

    @Transactional
    public void deleteProfessional(Long professionalId) {
        logger.info("Deleting professional:");
        ProfessionalEntity existingProfessional = professionalRepository
                .findById(professionalId)
                .orElseThrow(() -> new RuntimeException("Professional not found for delete"));
        professionalRepository.delete(existingProfessional);
    }
}
