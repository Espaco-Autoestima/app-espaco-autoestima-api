package br.com.espacoautoestima.schedulling.application.infrastructure.repositories;

import br.com.espacoautoestima.schedulling.application.model.entities.ProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, Long> {

    List<ProfessionalEntity> findByName(String name);
}
