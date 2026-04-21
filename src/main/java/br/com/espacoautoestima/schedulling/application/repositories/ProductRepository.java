package br.com.espacoautoestima.schedulling.application.repositories;

import br.com.espacoautoestima.schedulling.application.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
