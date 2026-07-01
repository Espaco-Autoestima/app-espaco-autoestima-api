package br.com.espacoautoestima.schedulling.application.mappers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.ProcedureDTORequest;
import br.com.espacoautoestima.schedulling.application.model.entities.ProcedureEntity;
import br.com.espacoautoestima.schedulling.core.domain.Procedure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProcedureRequestMapper {

    @Mapping(target = "id", source = "procedureDTORequest.id")
    @Mapping(target = "name", source = "procedureDTORequest.name")
    @Mapping(target = "description", source = "procedureDTORequest.description")
    public abstract ProcedureEntity saveEntityFromDto(ProcedureDTORequest procedureDTORequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "procedureDTORequest.name")
    @Mapping(target = "description", source = "procedureDTORequest.description")
    public abstract void updateEntityFromDto(ProcedureDTORequest procedureDTORequest, @MappingTarget ProcedureEntity procedureEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    public abstract Procedure toDomain(ProcedureEntity procedureEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    public abstract ProcedureDTORequest toDtoRequest(Procedure procedure);
}
