package br.com.espacoautoestima.schedulling.application.mappers.product;

import br.com.espacoautoestima.schedulling.application.adapters.dto.product.ProductDTORequest;
import br.com.espacoautoestima.schedulling.application.model.entities.ProductEntity;
import br.com.espacoautoestima.schedulling.core.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {

    @Mapping(target = "id", source = "productDTORequest.id")
    @Mapping(target = "name", source = "productDTORequest.name")
    @Mapping(target = "description", source = "productDTORequest.description")
    @Mapping(target = "expirationDate", source = "productDTORequest.expirationDate")
    @Mapping(target = "quantity", source = "productDTORequest.quantity")
    @Mapping(target = "brand", source = "productDTORequest.brand")
    @Mapping(target = "price", source = "productDTORequest.price")
    public abstract ProductEntity saveEntityFromDto(ProductDTORequest productDTORequest);

    @Mapping(target = "id", source = "productDTORequest.id")
    @Mapping(target = "name", source = "productDTORequest.name")
    @Mapping(target = "description", source = "productDTORequest.description")
    @Mapping(target = "expirationDate", source = "productDTORequest.expirationDate")
    @Mapping(target = "quantity", source = "productDTORequest.quantity")
    @Mapping(target = "brand", source = "productDTORequest.brand")
    @Mapping(target = "price", source = "productDTORequest.price")
    public void updateEntityFromDto(ProductDTORequest productDTORequest, @MappingTarget ProductEntity productEntity);

    @Mapping(target = "id", source = "productEntity.id")
    @Mapping(target = "name", source = "productEntity.name")
    @Mapping(target = "description", source = "productEntity.description")
    @Mapping(target = "expirationDate", source = "productEntity.expirationDate")
    @Mapping(target = "quantity", source = "productEntity.quantity")
    @Mapping(target = "brand", source = "productEntity.brand")
    @Mapping(target = "price", source = "productEntity.price")
    public abstract Product toDomain(ProductEntity productEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "expirationDate", source = "expirationDate")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "price", source = "price")
    public abstract ProductDTORequest toDtoRequest(Product product);
}
