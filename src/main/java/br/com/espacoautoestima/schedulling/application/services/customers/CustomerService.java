package br.com.espacoautoestima.schedulling.application.services.customers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.CustomerDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.CustomerDTOResponse;
import br.com.espacoautoestima.schedulling.application.mappers.CustomerRequestMapper;
import br.com.espacoautoestima.schedulling.application.mappers.CustomerResponseMapper;
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

    public CustomerDTOResponse getCustomerById(Long idCustomer) {
        CustomerEntity customerEntity = customerRepository
                .findById(idCustomer)
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
    public void updateCustomer(Long idCustomer, CustomerDTORequest customer) {
        CustomerEntity existingCustomer = customerRepository.findById(idCustomer)
                .orElseThrow(() -> new RuntimeException("Customer not found for update"));

        customerRequestMapper.updateEntityFromDto(customer, existingCustomer);
        CustomerEntity updatedCustomer = existingCustomer;
        customerRepository.save(updatedCustomer);
    }

    @Transactional
    public void deleteCustomer(Long idCustomer) {
        CustomerEntity existingCustomer = customerRepository
                .findById(idCustomer)
                .orElseThrow(() -> new RuntimeException("Customer not found for delete"));
        customerRepository.delete(existingCustomer);
    }
}
