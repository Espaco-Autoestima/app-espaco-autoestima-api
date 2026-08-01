package br.com.espacoautoestima.schedulling.application.mappers.suppliers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.supplier.SupplierDTOResponse;
import br.com.espacoautoestima.schedulling.application.model.entities.SupplierEntity;
import br.com.espacoautoestima.schedulling.core.domain.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierResponseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "supplierDTOResponse.name")
    @Mapping(target = "email", source = "supplierDTOResponse.email")
    @Mapping(target = "phoneNumber", source = "supplierDTOResponse.phoneNumber")
    @Mapping(target = "companyName", source = "supplierDTOResponse.companyName")
    public abstract SupplierEntity toEntity(SupplierDTOResponse supplierDTOResponse);

    @Mapping(target = "id", source = "supplierEntity.id")
    @Mapping(target = "name", source = "supplierEntity.name")
    @Mapping(target = "email", source = "supplierEntity.email")
    @Mapping(target = "phoneNumber", source = "supplierEntity.phoneNumber")
    @Mapping(target = "companyName", source = "supplierEntity.companyName")
    public abstract Supplier toDomain(SupplierEntity supplierEntity);

    @Mapping(target = "id", source = "supplierEntity.id")
    @Mapping(target = "name", source = "supplierEntity.name")
    @Mapping(target = "email", source = "supplierEntity.email")
    @Mapping(target = "phoneNumber", source = "supplierEntity.phoneNumber")
    @Mapping(target = "companyName", source = "supplierEntity.companyName")
    public abstract SupplierDTOResponse toDtoResponse(SupplierEntity supplierEntity);
}
