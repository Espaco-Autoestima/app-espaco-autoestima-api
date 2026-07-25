package br.com.espacoautoestima.schedulling.application.mappers.professionals;

import br.com.espacoautoestima.schedulling.application.adapters.dto.professional.ProfessionalDTORequest;
import br.com.espacoautoestima.schedulling.application.model.entities.ProfessionalEntity;
import br.com.espacoautoestima.schedulling.core.domain.Professional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfessionalRequestMapper {

    @Mapping(target = "id", source = "professionalDTORequest.id")
    @Mapping(target = "name", source = "professionalDTORequest.name")
    @Mapping(target = "phoneNumber", source = "professionalDTORequest.phoneNumber")
    @Mapping(target = "email", source = "professionalDTORequest.email")
    @Mapping(target = "speciality", source = "professionalDTORequest.speciality")
    public abstract ProfessionalEntity saveEntityFromDto(ProfessionalDTORequest professionalDTORequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "professionalDTORequest.name")
    @Mapping(target = "phoneNumber", source = "professionalDTORequest.phoneNumber")
    @Mapping(target = "email", source = "professionalDTORequest.email")
    @Mapping(target = "speciality", source = "professionalDTORequest.speciality")
    public void updateFromEntity(ProfessionalDTORequest professionalDTORequest, @MappingTarget ProfessionalEntity professionalEntity);

    @Mapping(target = "id", source = "professionalEntity.id")
    @Mapping(target = "name", source = "professionalEntity.name")
    @Mapping(target = "phoneNumber", source = "professionalEntity.phoneNumber")
    @Mapping(target = "email", source = "professionalEntity.email")
    @Mapping(target = "speciality", source = "professionalEntity.speciality")
    public abstract Professional toDomain(ProfessionalEntity professionalEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "speciality", source = "speciality")
    public abstract ProfessionalDTORequest toDtoRequest(Professional professional);
}
