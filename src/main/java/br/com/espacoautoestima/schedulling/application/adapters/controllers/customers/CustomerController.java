package br.com.espacoautoestima.schedulling.application.adapters.controllers.customers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.customer.CustomerDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.customer.CustomerDTOResponse;
import br.com.espacoautoestima.schedulling.application.services.customers.CustomerService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTOResponse>> listCustomers() {
        List<CustomerDTOResponse> customers = customerService.getAllCustomers();
        return ResponseEntity.status(200).body(customers);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTOResponse> getCustomerById(@PathVariable Long customerId) {
        CustomerDTOResponse customer = customerService.getCustomerById(customerId);
        return ResponseEntity.status(200).body(customer);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CustomerDTOResponse>> getCustomerByName(@RequestParam String name) {
        List<CustomerDTOResponse> customers = customerService.getCustomerByName(name);
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@NotNull @RequestBody CustomerDTORequest customer) {
        customerService.createCustomer(customer);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Long customerId, @NotNull @RequestBody CustomerDTORequest customer) {
        customerService.updateCustomer(customerId, customer);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.status(204).build();
    }
}
