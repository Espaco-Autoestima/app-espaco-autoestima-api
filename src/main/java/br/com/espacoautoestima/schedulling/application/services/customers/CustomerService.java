package br.com.espacoautoestima.schedulling.application.services.customers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.customer.CustomerDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.customer.CustomerDTOResponse;
import br.com.espacoautoestima.schedulling.application.mappers.customer.CustomerRequestMapper;
import br.com.espacoautoestima.schedulling.application.mappers.customer.CustomerResponseMapper;
import br.com.espacoautoestima.schedulling.application.model.entities.CustomerEntity;
import br.com.espacoautoestima.schedulling.application.infrastructure.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerRequestMapper customerRequestMapper;
    private final CustomerResponseMapper customerResponseMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerRequestMapper customerRequestMapper, CustomerResponseMapper customerResponseMapper) {
        this.customerRepository = customerRepository;
        this.customerRequestMapper = customerRequestMapper;
        this.customerResponseMapper = customerResponseMapper;
    }

    public List<CustomerDTOResponse> getAllCustomers() {
        List<CustomerEntity> customersEntity = customerRepository.findAll();
        return customersEntity.stream()
                .map(customerResponseMapper::toDtoResponse)
                .toList();
    }

    public CustomerDTOResponse getCustomerById(Long customerId) {
        CustomerEntity customerEntity = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found for search"));
        return customerResponseMapper.toDtoResponse(customerEntity);
    }

    public List<CustomerDTOResponse> getCustomerByName(String name) {
        List<CustomerEntity> customersEntity = customerRepository.findByName(name);
        return customersEntity.stream()
                .map(customerResponseMapper::toDtoResponse)
                .toList();
    }

    @Transactional
    public void createCustomer(CustomerDTORequest customer) {
        CustomerEntity newCustomer = customerRequestMapper.saveEntityFromDto(customer);
        customerRepository.save(newCustomer);
    }

    @Transactional
    public void updateCustomer(Long customerId, CustomerDTORequest customer) {
        CustomerEntity existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found for update"));
        customerRequestMapper.updateEntityFromDto(customer, existingCustomer);
        CustomerEntity updatedCustomer = existingCustomer;
        customerRepository.save(updatedCustomer);
    }

    @Transactional
    public void deleteCustomer(Long customerId) {
        CustomerEntity existingCustomer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found for delete"));
        customerRepository.delete(existingCustomer);
    }
}
