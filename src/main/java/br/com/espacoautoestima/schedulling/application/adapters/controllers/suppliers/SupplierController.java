package br.com.espacoautoestima.schedulling.application.adapters.controllers.suppliers;

import br.com.espacoautoestima.schedulling.application.adapters.dto.supplier.SupplierDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.supplier.SupplierDTOResponse;
import br.com.espacoautoestima.schedulling.application.services.suppliers.SupplierService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTOResponse>> listSuppliers() {
        List<SupplierDTOResponse> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.status(200).body(suppliers);
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<SupplierDTOResponse> getSupplierById(@PathVariable Long supplierId) {
        SupplierDTOResponse supplier = supplierService.getSupplierById(supplierId);
        return ResponseEntity.status(200).body(supplier);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SupplierDTOResponse>> getSupplierByName(@RequestParam String name) {
        List<SupplierDTOResponse> suppliers = supplierService.getSupplierByName(name);
        return ResponseEntity.status(200).body(suppliers);
    }

    @PostMapping
    public ResponseEntity<Void> createSupplier(@NotNull @RequestBody SupplierDTORequest supplierDTORequest) {
        supplierService.createSupplier(supplierDTORequest);
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/{supplierId}")
    public ResponseEntity<Void> updateSupplier(@PathVariable Long supplierId, @NotNull @RequestBody SupplierDTORequest supplierDTORequest) {
        supplierService.updateSupplier(supplierId, supplierDTORequest);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long supplierId) {
        supplierService.deleteSupplier(supplierId);
        return ResponseEntity.status(200).build();
    }
}
