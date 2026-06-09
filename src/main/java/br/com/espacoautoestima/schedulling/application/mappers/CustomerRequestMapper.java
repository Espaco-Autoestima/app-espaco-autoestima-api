package br.com.espacoautoestima.schedulling.application.mappers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.CustomerDTORequest;
import br.com.espacoautoestima.schedulling.application.model.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "customerDTORequest.name")
    @Mapping(target = "email", source = "customerDTORequest.email")
    @Mapping(target = "phoneNumber", source = "customerDTORequest.phoneNumber")
    @Mapping(target = "cpf", source = "customerDTORequest.cpf")

    public abstract CustomerEntity toEntity(CustomerDTORequest customerDTORequest);
}
