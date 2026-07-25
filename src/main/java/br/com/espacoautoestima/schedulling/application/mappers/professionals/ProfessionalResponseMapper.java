package br.com.espacoautoestima.schedulling.application.mappers.professionals;

import br.com.espacoautoestima.schedulling.application.adapters.dto.professional.ProfessionalDTOResponse;
import br.com.espacoautoestima.schedulling.application.model.entities.ProfessionalEntity;
import br.com.espacoautoestima.schedulling.core.domain.Professional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessionalResponseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "professionalDTOResponse.name")
    @Mapping(target = "phoneNumber", source = "professionalDTOResponse.phoneNumber")
    @Mapping(target = "email", source = "professionalDTOResponse.email")
    @Mapping(target = "speciality", source = "professionalDTOResponse.speciality")
    public abstract ProfessionalEntity toEntity(ProfessionalDTOResponse professionalDTOResponse);

    @Mapping(target = "id", source = "professionalEntity.id")
    @Mapping(target = "name", source = "professionalEntity.name")
    @Mapping(target = "phoneNumber", source = "professionalEntity.phoneNumber")
    @Mapping(target = "email", source = "professionalEntity.email")
    @Mapping(target = "speciality", source = "professionalEntity.speciality")
    public abstract Professional toDomain(ProfessionalEntity professionalEntity);

    @Mapping(target = "id", source = "professionalEntity.id")
    @Mapping(target = "name", source = "professionalEntity.name")
    @Mapping(target = "phoneNumber", source = "professionalEntity.phoneNumber")
    @Mapping(target = "email", source = "professionalEntity.email")
    @Mapping(target = "speciality", source = "professionalEntity.speciality")
    public abstract ProfessionalDTOResponse toDtoResponse(ProfessionalEntity professionalEntity);
}
