package br.com.espacoautoestima.schedulling.application.mappers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.CustomerDTORequest;
import br.com.espacoautoestima.schedulling.application.model.entities.CustomerEntity;
import br.com.espacoautoestima.schedulling.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "customerDTORequest.name")
    @Mapping(target = "email", source = "customerDTORequest.email")
    @Mapping(target = "phoneNumber", source = "customerDTORequest.phoneNumber")
    @Mapping(target = "cpf", source = "customerDTORequest.cpf")
    public abstract CustomerEntity toEntity(CustomerDTORequest customerDTORequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "customerDTORequest.name")
    @Mapping(target = "email", source = "customerDTORequest.email")
    @Mapping(target = "phoneNumber", source = "customerDTORequest.phoneNumber")
    @Mapping(target = "cpf", source = "customerDTORequest.cpf")
    public abstract Customer toDomain(CustomerDTORequest customerDTORequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "cpf", source = "cpf")
    public abstract CustomerDTORequest toDtoRequest(Customer customer);
}
