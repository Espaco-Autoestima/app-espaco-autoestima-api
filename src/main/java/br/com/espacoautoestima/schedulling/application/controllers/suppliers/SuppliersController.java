package br.com.espacoautoestima.schedulling.application.controllers.suppliers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/suppliers")
public class SuppliersController {

    // Use 200 status code for successful retrieval of resources
    @GetMapping
    public String listSuppliers() {
        return "List of suppliers";
    }

    // Use 201 status code for successful creation of a resource
    @PostMapping
    public String createSupplier() {
        return "Supplier created";
    }

    // Use 204 status code for successful deletion of a resource
    @PutMapping
    public String updateSupplier() {
        return "Supplier updated";
    }

    // Use 204 status code for successful deletion of a resource
    @DeleteMapping
    public String deleteSupplier() {
        return "Supplier deleted";
    }
}
