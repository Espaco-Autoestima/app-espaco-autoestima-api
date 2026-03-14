package br.com.espacoautoestima.schedulling.application.controllers.products;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    // Use 200 status code for successful retrieval of resources
    @GetMapping
    public String listProducts() {
        return "List of products";
    }

    // Use 201 status code for successful creation of a resource
    @PostMapping
    public String createProduct() {
        return "Product created";
    }

    // Use 204 status code for successful deletion of a resource
    @PutMapping
    public String updateProduct() {
        return "Product updated";
    }

    // Use 204 status code for successful deletion of a resource
    @DeleteMapping
    public String deleteProduct() {
        return "Product deleted";
    }
}
