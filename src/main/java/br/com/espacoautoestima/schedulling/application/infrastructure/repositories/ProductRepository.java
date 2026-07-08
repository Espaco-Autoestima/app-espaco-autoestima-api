package br.com.espacoautoestima.schedulling.application.infrastructure.repositories;

import br.com.espacoautoestima.schedulling.application.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByName(String name);
}
