package br.com.espacoautoestima.schedulling.application.mappers.suppliers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.supplier.SupplierDTORequest;
import br.com.espacoautoestima.schedulling.application.model.entities.SupplierEntity;
import br.com.espacoautoestima.schedulling.core.domain.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SupplierRequestMapper {

    @Mapping(target = "id", source = "supplierDTORequest.id")
    @Mapping(target = "name", source = "supplierDTORequest.name")
    @Mapping(target = "email", source = "supplierDTORequest.email")
    @Mapping(target = "phoneNumber", source = "supplierDTORequest.phoneNumber")
    @Mapping(target = "companyName", source = "supplierDTORequest.companyName")
    public abstract SupplierEntity saveEntityFromDto(SupplierDTORequest supplierDTORequest);

    @Mapping(target = "id", source = "supplierDTORequest.id")
    @Mapping(target = "name", source = "supplierDTORequest.name")
    @Mapping(target = "email", source = "supplierDTORequest.email")
    @Mapping(target = "phoneNumber", source = "supplierDTORequest.phoneNumber")
    @Mapping(target = "companyName", source = "supplierDTORequest.companyName")
    public void updateFromEntity(SupplierDTORequest supplierDTORequest, @MappingTarget SupplierEntity supplierEntity);

    @Mapping(target = "id", source = "supplierEntity.id")
    @Mapping(target = "name", source = "supplierEntity.name")
    @Mapping(target = "email", source = "supplierEntity.email")
    @Mapping(target = "phoneNumber", source = "supplierEntity.phoneNumber")
    @Mapping(target = "companyName", source = "supplierEntity.companyName")
    public abstract Supplier toDomain(SupplierEntity supplierEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "companyName", source = "companyName")
    public abstract SupplierDTORequest toDtoRequest(Supplier supplier);
}
