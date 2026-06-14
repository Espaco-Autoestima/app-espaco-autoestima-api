package br.com.espacoautoestima.schedulling.application.adapters.controllers.customers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.CustomerDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.CustomerDTOResponse;
import br.com.espacoautoestima.schedulling.application.model.entities.CustomerEntity;
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

    // Analyze if is necessary to return a list of customers
    @GetMapping("/{idCustomer}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long idCustomer) {
        CustomerEntity customer = customerService.getCustomerById(idCustomer);
        return ResponseEntity.status(200).body(customer);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CustomerEntity>> getCustomerByName(@RequestParam String name) {
        List<CustomerEntity> customers = customerService.getCustomerByName(name);
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@NotNull @RequestBody CustomerDTORequest customer) {
        customerService.createCustomer(new CustomerEntity(null, customer.getName(), customer.getEmail(), customer.getPhoneNumber(), customer.getCpf()));
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/{idCustomer}")
    public ResponseEntity<Void> updateCustomer(@PathVariable Long idCustomer, @NotNull @RequestBody CustomerDTORequest customer) {
        customerService.updateCustomer(new CustomerEntity(idCustomer, customer.getName(), customer.getEmail(), customer.getPhoneNumber(), customer.getCpf()));
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long idCustomer) {
        customerService.deleteCustomer(idCustomer);
        return ResponseEntity.status(204).build();
    }
}
