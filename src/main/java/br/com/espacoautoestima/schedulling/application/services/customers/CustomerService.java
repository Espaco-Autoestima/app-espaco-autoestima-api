package br.com.espacoautoestima.schedulling.application.services.customers;

import br.com.espacoautoestima.schedulling.application.model.entities.CustomerEntity;
import br.com.espacoautoestima.schedulling.application.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerEntity createCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    public CustomerEntity updateCustomer(Long idCustomer) {
        CustomerEntity customer = customerRepository.findById(idCustomer).orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerRepository.save(customer);
    }

    public CustomerEntity deleteCustomer(Long idCustomer) {
        CustomerEntity customer = customerRepository.findById(idCustomer).orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
        return customer;
    }
}
