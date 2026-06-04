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
    public ResponseEntity<String> createCustomer(@NotNull @RequestBody CustomerDTORequest customer) {
        customerService.createCustomer(new CustomerEntity(null, customer.getName(), customer.getEmail(), customer.getPhoneNumber(), customer.getCpf()));
        return ResponseEntity.status(201).body("Customer created");
    }

    @PatchMapping("/{idCustomer}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long idCustomer, @NotNull @RequestBody CustomerDTORequest customer) {
        customerService.updateCustomer(new CustomerEntity(idCustomer, customer.getName(), customer.getEmail(), customer.getPhoneNumber(), customer.getCpf()));
        return ResponseEntity.status(204).body("Customer updated");
    }

    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long idCustomer) {
        customerService.deleteCustomer(idCustomer);
        return ResponseEntity.status(204).body("Customer deleted");
    }
}
