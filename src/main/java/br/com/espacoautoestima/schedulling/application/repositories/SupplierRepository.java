package br.com.espacoautoestima.schedulling.application.repositories;

import br.com.espacoautoestima.schedulling.application.model.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
}
