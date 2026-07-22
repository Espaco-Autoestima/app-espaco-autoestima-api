package br.com.espacoautoestima.schedulling.application.adapters.controllers.products;

import br.com.espacoautoestima.schedulling.application.adapters.dto.product.ProductDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.product.ProductDTOResponse;
import br.com.espacoautoestima.schedulling.application.services.products.ProductService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTOResponse>> listProducts() {
        List<ProductDTOResponse> products = productService.getAllProducts();
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTOResponse> getProductById(@PathVariable Long productId) {
        ProductDTOResponse product = productService.getProductById(productId);
        return ResponseEntity.status(200).body(product);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTOResponse>> getProductByName(@RequestParam String name) {
        List<ProductDTOResponse> products = productService.getProductByName(name);
        return ResponseEntity.status(200).body(products);
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@NotNull @RequestBody ProductDTORequest productDTORequest) {
        productService.createProduct(productDTORequest);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long productId, @NotNull @RequestBody ProductDTORequest productDTORequest) {
        productService.updateProduct(productId, productDTORequest);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.status(204).build();
    }
}
