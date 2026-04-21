package br.com.espacoautoestima.schedulling.application.repositories;

import br.com.espacoautoestima.schedulling.application.model.entities.ProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, Long> {
}
