package br.com.espacoautoestima.schedulling.application.repositories;

import br.com.espacoautoestima.schedulling.application.model.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
