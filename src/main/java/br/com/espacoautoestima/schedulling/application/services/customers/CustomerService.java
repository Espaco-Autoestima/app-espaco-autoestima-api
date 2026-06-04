package br.com.espacoautoestima.schedulling.application.services.customers;

import br.com.espacoautoestima.schedulling.application.model.entities.CustomerEntity;
import br.com.espacoautoestima.schedulling.application.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerEntity getCustomerById(Long idCustomer) {
        return customerRepository
                .findById(idCustomer)
                .orElseThrow(() -> new RuntimeException("Customer not found for search"));
    }

    public List<CustomerEntity> getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    @Transactional
    public CustomerEntity createCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public CustomerEntity updateCustomer(CustomerEntity customer) {
        CustomerEntity existingCustomer = customerRepository
                .findById(customer.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found for update"));
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setCpf(customer.getCpf());
        return customerRepository.save(existingCustomer);
    }

    @Transactional
    public CustomerEntity deleteCustomer(Long idCustomer) {
        CustomerEntity customer = customerRepository
                .findById(idCustomer)
                .orElseThrow(() -> new RuntimeException("Customer not found for delete"));
        customerRepository.delete(customer);
        return customer;
    }
}
