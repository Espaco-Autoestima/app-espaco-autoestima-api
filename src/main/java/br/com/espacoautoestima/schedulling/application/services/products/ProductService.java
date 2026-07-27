package br.com.espacoautoestima.schedulling.application.services.products;

import br.com.espacoautoestima.schedulling.application.adapters.dto.product.ProductDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.product.ProductDTOResponse;
import br.com.espacoautoestima.schedulling.application.infrastructure.repositories.ProductRepository;
import br.com.espacoautoestima.schedulling.application.mappers.product.ProductRequestMapper;
import br.com.espacoautoestima.schedulling.application.mappers.product.ProductResponseMapper;
import br.com.espacoautoestima.schedulling.application.model.entities.ProductEntity;
import br.com.espacoautoestima.schedulling.application.services.procedures.ProcedureService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductRequestMapper productRequestMapper;
    private final ProductResponseMapper productResponseMapper;

    private Logger logger = Logger.getLogger(ProductService.class.getName());

    public ProductService(ProductRepository productRepository, ProductRequestMapper productRequestMapper, ProductResponseMapper productResponseMapper) {
        this.productRepository = productRepository;
        this.productRequestMapper = productRequestMapper;
        this.productResponseMapper = productResponseMapper;
    }

    public List<ProductDTOResponse> getAllProducts() {
        logger.info("Listing all products:");
        List<ProductEntity> productEntity = productRepository.findAll();
        return productEntity.stream()
                .map(productResponseMapper::toDtoResponse)
                .toList();
    }

    public ProductDTOResponse getProductById(Long productId) {
        logger.info("Searching for product by ID:");
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found for search"));
        return productResponseMapper.toDtoResponse(productEntity);
    }

    public List<ProductDTOResponse> getProductByName(String name) {
        logger.info("Searching for product by name:");
        List<ProductEntity> productEntity = productRepository.findByName(name);
        return productEntity.stream()
                .map(productResponseMapper::toDtoResponse)
                .toList();
    }

    @Transactional
    public void createProduct(ProductDTORequest product) {
        logger.info("Creating new product:");
        ProductEntity newProduct = productRequestMapper.saveEntityFromDto(product);
        productRepository.save(newProduct);
    }

    @Transactional
    public void updateProduct(Long productId, ProductDTORequest product) {
        logger.info("Updating product:");
        ProductEntity existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found for update"));
        productRequestMapper.updateEntityFromDto(product, existingProduct);
        ProductEntity updatedProduct = existingProduct;
        productRepository.save(updatedProduct);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        logger.info("Deleting product:");
        ProductEntity existingProduct = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found for delete"));
        productRepository.delete(existingProduct);
    }
}
