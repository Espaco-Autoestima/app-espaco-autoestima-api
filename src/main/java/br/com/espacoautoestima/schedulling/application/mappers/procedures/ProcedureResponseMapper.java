package br.com.espacoautoestima.schedulling.application.mappers.procedures;

import br.com.espacoautoestima.schedulling.application.adapters.dto.procedure.ProcedureDTOResponse;
import br.com.espacoautoestima.schedulling.application.model.entities.ProcedureEntity;
import br.com.espacoautoestima.schedulling.core.domain.Procedure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProcedureResponseMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "procedureDTOResponse.name")
    @Mapping(target = "description", source = "procedureDTOResponse.description")
    public abstract ProcedureEntity toEntity(ProcedureDTOResponse procedureDTOResponse);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "procedureEntity.name")
    @Mapping(target = "description", source = "procedureEntity.description")
    public abstract Procedure toDomain(ProcedureEntity procedureEntity);

    @Mapping(target = "id", source = "procedureEntity.id")
    @Mapping(target = "name", source = "procedureEntity.name")
    @Mapping(target = "description", source = "procedureEntity.description")
    public abstract ProcedureDTOResponse toDtoResponse(ProcedureEntity procedureEntity);
}
