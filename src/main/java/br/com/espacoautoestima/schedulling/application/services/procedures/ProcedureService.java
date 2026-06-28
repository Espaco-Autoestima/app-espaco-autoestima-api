package br.com.espacoautoestima.schedulling.application.services.procedures;

import br.com.espacoautoestima.schedulling.application.adapters.dto.ProcedureDTOResponse;
import br.com.espacoautoestima.schedulling.application.infrastructure.repositories.ProcedureRepository;
import br.com.espacoautoestima.schedulling.application.mappers.ProcedureRequestMapper;
import br.com.espacoautoestima.schedulling.application.mappers.ProcedureResponseMapper;
import br.com.espacoautoestima.schedulling.application.model.entities.ProcedureEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedureService {

    private final ProcedureRepository procedureRepository;
    private final ProcedureRequestMapper procedureRequestMapper;
    private final ProcedureResponseMapper procedureResponseMapper;

    public ProcedureService(ProcedureRepository procedureRepository, ProcedureRequestMapper procedureRequestMapper, ProcedureResponseMapper procedureResponseMapper) {
        this.procedureRepository = procedureRepository;
        this.procedureRequestMapper = procedureRequestMapper;
        this.procedureResponseMapper = procedureResponseMapper;
    }

    public List<ProcedureDTOResponse> getAllProcedures() {
        List<ProcedureEntity> procedureEntity = procedureRepository.findAll();
        return procedureEntity.stream()
                .map(procedureResponseMapper::toDtoResponse)
                .toList();
    }

    public ProcedureDTOResponse getProcedureById(Long idProcedure) {
        ProcedureEntity procedureEntity = procedureRepository
                .findById(idProcedure)
                .orElseThrow(() -> new RuntimeException("Procedure not found for search"));
        return procedureResponseMapper.toDtoResponse(procedureEntity);
    }

    public List<ProcedureDTOResponse> getProcedureByName(String name) {
        List<ProcedureEntity> proceduresEntity = procedureRepository.findByName(name);
        return proceduresEntity.stream()
                .map(procedureResponseMapper::toDtoResponse)
                .toList();
    }
}
