package br.com.espacoautoestima.schedulling.application.services.suppliers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.supplier.SupplierDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.supplier.SupplierDTOResponse;
import br.com.espacoautoestima.schedulling.application.infrastructure.repositories.SupplierRepository;
import br.com.espacoautoestima.schedulling.application.mappers.suppliers.SupplierRequestMapper;
import br.com.espacoautoestima.schedulling.application.mappers.suppliers.SupplierResponseMapper;
import br.com.espacoautoestima.schedulling.application.model.entities.SupplierEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;
    private SupplierRequestMapper supplierRequestMapper;
    private SupplierResponseMapper supplierResponseMapper;

    private Logger logger = Logger.getLogger(SupplierService.class.getName());

    public SupplierService(SupplierRepository supplierRepository, SupplierRequestMapper supplierRequestMapper, SupplierResponseMapper supplierResponseMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierRequestMapper = supplierRequestMapper;
        this.supplierResponseMapper = supplierResponseMapper;
    }

    public List<SupplierDTOResponse> getAllSuppliers() {
        logger.info("Listing all suppliers:");
        List<SupplierEntity> supplierEntities = supplierRepository.findAll();
        return supplierEntities.stream()
                .map(supplierResponseMapper::toDtoResponse)
                .toList();
    }

    public SupplierDTOResponse getSupplierById(Long supplierId) {
        logger.info("Searching for supplier by ID:");
        SupplierEntity supplierEntity = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found for search"));
        return supplierResponseMapper.toDtoResponse(supplierEntity);
    }

    public List<SupplierDTOResponse> getSupplierByName(String name) {
        logger.info("Searching for supplier by name:");
        List<SupplierEntity> supplierEntity = supplierRepository.findByName(name);
        return supplierEntity.stream()
                .map(supplierResponseMapper::toDtoResponse)
                .toList();
    }

    @Transactional
    public void createSupplier(SupplierDTORequest supplierDTORequest) {
        logger.info("Creating new supplier:");
        SupplierEntity newSupplier = supplierRequestMapper.saveEntityFromDto(supplierDTORequest);
        supplierRepository.save(newSupplier);
    }

    @Transactional
    public void updateSupplier(Long supplierId, SupplierDTORequest supplierDTORequest) {
        logger.info("Updating supplier:");
        SupplierEntity existingSupplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found for update"));
        supplierRequestMapper.updateFromEntity(supplierDTORequest, existingSupplier);
        SupplierEntity updatedSupplier = existingSupplier;
        supplierRepository.save(updatedSupplier);
    }

    public void deleteSupplier(Long supplierId) {
        logger.info("Deleting supplier:");
        SupplierEntity existingSupplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found for delete"));
        supplierRepository.delete(existingSupplier);
    }
}
