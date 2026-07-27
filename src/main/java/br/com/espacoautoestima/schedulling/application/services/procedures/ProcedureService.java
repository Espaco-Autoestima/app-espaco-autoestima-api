package br.com.espacoautoestima.schedulling.application.services.procedures;

import br.com.espacoautoestima.schedulling.application.adapters.dto.procedure.ProcedureDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.procedure.ProcedureDTOResponse;
import br.com.espacoautoestima.schedulling.application.infrastructure.repositories.ProcedureRepository;
import br.com.espacoautoestima.schedulling.application.mappers.procedure.ProcedureRequestMapper;
import br.com.espacoautoestima.schedulling.application.mappers.procedure.ProcedureResponseMapper;
import br.com.espacoautoestima.schedulling.application.model.entities.ProcedureEntity;
import br.com.espacoautoestima.schedulling.application.services.customers.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProcedureService {

    private final ProcedureRepository procedureRepository;
    private final ProcedureRequestMapper procedureRequestMapper;
    private final ProcedureResponseMapper procedureResponseMapper;

    private Logger logger = Logger.getLogger(ProcedureService.class.getName());

    public ProcedureService(ProcedureRepository procedureRepository, ProcedureRequestMapper procedureRequestMapper, ProcedureResponseMapper procedureResponseMapper) {
        this.procedureRepository = procedureRepository;
        this.procedureRequestMapper = procedureRequestMapper;
        this.procedureResponseMapper = procedureResponseMapper;
    }

    public List<ProcedureDTOResponse> getAllProcedures() {
        logger.info("Listing all procedures:");
        List<ProcedureEntity> procedureEntity = procedureRepository.findAll();
        return procedureEntity.stream()
                .map(procedureResponseMapper::toDtoResponse)
                .toList();
    }

    public ProcedureDTOResponse getProcedureById(Long procedureId) {
        logger.info("Searching for procedure by ID:");
        ProcedureEntity procedureEntity = procedureRepository
                .findById(procedureId)
                .orElseThrow(() -> new RuntimeException("Procedure not found for search"));
        return procedureResponseMapper.toDtoResponse(procedureEntity);
    }

    public List<ProcedureDTOResponse> getProcedureByName(String name) {
        logger.info("Searching for procedure by name:");
        List<ProcedureEntity> proceduresEntity = procedureRepository.findByName(name);
        return proceduresEntity.stream()
                .map(procedureResponseMapper::toDtoResponse)
                .toList();
    }

    @Transactional
    public void createProcedure(ProcedureDTORequest procedure) {
        logger.info("Creating new procedure:");
        ProcedureEntity newProcedure = procedureRequestMapper.saveEntityFromDto(procedure);
        procedureRepository.save(newProcedure);
    }

    @Transactional
    public void updateProcedure(Long procedureId, ProcedureDTORequest procedure) {
        logger.info("Updating procedure:");
        ProcedureEntity existingProcedure = procedureRepository.findById(procedureId)
                .orElseThrow(() -> new RuntimeException("Procedure not found for update"));
        procedureRequestMapper.updateEntityFromDto(procedure, existingProcedure);
        ProcedureEntity updatedProcedure = existingProcedure;
        procedureRepository.save(updatedProcedure);
    }

    @Transactional
    public void deleteProcedure(Long procedureId) {
        logger.info("Deleting procedure:");
        ProcedureEntity existingProcedure = procedureRepository
                .findById(procedureId)
                .orElseThrow(() -> new RuntimeException("Procedure not found for delete"));
        procedureRepository.delete(existingProcedure);
    }
}
