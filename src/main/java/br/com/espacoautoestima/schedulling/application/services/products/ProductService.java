package br.com.espacoautoestima.schedulling.application.services.products;

import br.com.espacoautoestima.schedulling.application.adapters.dto.product.ProductDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.product.ProductDTOResponse;
import br.com.espacoautoestima.schedulling.application.infrastructure.repositories.ProductRepository;
import br.com.espacoautoestima.schedulling.application.mappers.product.ProductRequestMapper;
import br.com.espacoautoestima.schedulling.application.mappers.product.ProductResponseMapper;
import br.com.espacoautoestima.schedulling.application.model.entities.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductRequestMapper productRequestMapper;
    private final ProductResponseMapper productResponseMapper;

    public ProductService(ProductRepository productRepository, ProductRequestMapper productRequestMapper, ProductResponseMapper productResponseMapper) {
        this.productRepository = productRepository;
        this.productRequestMapper = productRequestMapper;
        this.productResponseMapper = productResponseMapper;
    }

    public List<ProductDTOResponse> getAllProducts() {
        List<ProductEntity> productEntity = productRepository.findAll();
        return productEntity.stream()
                .map(productResponseMapper::toDtoResponse)
                .toList();
    }

    public ProductDTOResponse getProductById(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found for search"));
        return productResponseMapper.toDtoResponse(productEntity);
    }

    public List<ProductDTOResponse> getProductByName(String name) {
        List<ProductEntity> productEntity = productRepository.findByName(name);
        return productEntity.stream()
                .map(productResponseMapper::toDtoResponse)
                .toList();
    }

    @Transactional
    public void createProduct(ProductDTORequest product) {
        ProductEntity newProduct = productRequestMapper.saveEntityFromDto(product);
        productRepository.save(newProduct);
    }

    @Transactional
    public void updateProduct(Long productId, ProductDTORequest product) {
        ProductEntity existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found for update"));
        productRequestMapper.updateEntityFromDto(product, existingProduct);
        ProductEntity updatedProduct = existingProduct;
        productRepository.save(updatedProduct);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        ProductEntity existingProduct = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found for delete"));
        productRepository.delete(existingProduct);
    }
}
