package br.com.espacoautoestima.schedulling.application.adapters.controllers.customers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.CustomerDTORequest;
import br.com.espacoautoestima.schedulling.application.model.entities.CustomerEntity;
import br.com.espacoautoestima.schedulling.application.services.customers.CustomerService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Reformulate the endpoint to follow RESTful conventions and return a list of customers
    @GetMapping
    public List<CustomerEntity> listCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@NotNull @RequestBody CustomerDTORequest customer) {
        customerService.createCustomer(new CustomerEntity(null, customer.getName(), customer.getEmail(), customer.getPhoneNumber(), customer.getCpf()));
        return ResponseEntity.status(201).body("Customer created");
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
