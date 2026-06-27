package br.com.espacoautoestima.schedulling.application.mappers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.ProcedureDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.ProcedureDTOResponse;
import br.com.espacoautoestima.schedulling.application.model.entities.ProcedureEntity;
import br.com.espacoautoestima.schedulling.core.domain.Procedure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProcedureResponseMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "procedureDTO.name")
    @Mapping(target = "description", source = "procedureDTO.description")
    public abstract ProcedureEntity toEntity(ProcedureDTORequest procedureDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    public abstract Procedure toDomain(ProcedureEntity procedureEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    public abstract ProcedureDTOResponse toDtoResponse(ProcedureEntity procedureEntity);
}
