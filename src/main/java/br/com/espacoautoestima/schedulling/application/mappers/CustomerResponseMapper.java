package br.com.espacoautoestima.schedulling.application.mappers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.CustomerDTOResponse;
import br.com.espacoautoestima.schedulling.application.model.entities.CustomerEntity;
import br.com.espacoautoestima.schedulling.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// Check if is necessary includes 'uses' for other mappers
@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "customerEntity.name")
    @Mapping(target = "email", source = "customerEntity.email")
    @Mapping(target = "phoneNumber", source = "customerEntity.phoneNumber")
    @Mapping(target = "cpf", source = "customerEntity.cpf")
    public abstract CustomerDTOResponse toDtoResponse(CustomerEntity customerEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "customerEntity.name")
    @Mapping(target = "email", source = "customerEntity.email")
    @Mapping(target = "phoneNumber", source = "customerEntity.phoneNumber")
    @Mapping(target = "cpf", source = "customerEntity.cpf")
    public abstract Customer toDomain(CustomerEntity customerEntity);
}
