package br.com.espacoautoestima.schedulling.application.mappers.product;

import br.com.espacoautoestima.schedulling.application.adapters.dto.product.ProductDTOResponse;
import br.com.espacoautoestima.schedulling.application.model.entities.ProductEntity;
import br.com.espacoautoestima.schedulling.core.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "productDTOResponse.name")
    @Mapping(target = "description", source = "productDTOResponse.description")
    @Mapping(target = "expirationDate", source = "productDTOResponse.expirationDate")
    @Mapping(target = "quantity", source = "productDTOResponse.quantity")
    @Mapping(target = "brand", source = "productDTOResponse.brand")
    @Mapping(target = "price", source = "productDTOResponse.price")
    public abstract ProductEntity toEntity(ProductDTOResponse productDTOResponse);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "productEntity.name")
    @Mapping(target = "description", source = "productEntity.description")
    @Mapping(target = "expirationDate", source = "productEntity.expirationDate")
    @Mapping(target = "quantity", source = "productEntity.quantity")
    @Mapping(target = "brand", source = "productEntity.brand")
    @Mapping(target = "price", source = "productEntity.price")
    public abstract Product toDomain(ProductEntity productEntity);

    @Mapping(target = "id", source = "productEntity.id")
    @Mapping(target = "name", source = "productEntity.name")
    @Mapping(target = "description", source = "productEntity.description")
    @Mapping(target = "expirationDate", source = "productEntity.expirationDate")
    @Mapping(target = "quantity", source = "productEntity.quantity")
    @Mapping(target = "brand", source = "productEntity.brand")
    @Mapping(target = "price", source = "productEntity.price")
    public abstract ProductDTOResponse toDtoResponse(ProductEntity productEntity);
}
