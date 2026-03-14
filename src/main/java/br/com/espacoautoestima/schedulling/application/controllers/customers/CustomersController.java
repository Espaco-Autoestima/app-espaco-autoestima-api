package br.com.espacoautoestima.schedulling.application.controllers.customers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
public class CustomersController {

    // Use 200 status code for successful retrieval of resources
    @GetMapping
    public String listCustomers() {
        return "List of customers";
    }

    // Use 201 status code for successful creation of a resource
    @PostMapping
    public String createCustomer() {
        return "Customer created";
    }

    // Use 204 status code for successful deletion of a resource
    @PutMapping
    public String updateCustomer() {
        return "Customer updated";
    }

    // Use 204 status code for successful deletion of a resource
    @DeleteMapping
    public String deleteCustomer() {
        return "Customer deleted";
    }
}
