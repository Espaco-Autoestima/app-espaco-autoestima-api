package br.com.espacoautoestima.schedulling.application.infrastructure.repositories;

import br.com.espacoautoestima.schedulling.application.model.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    List<SupplierEntity> findByName(String name);
}
