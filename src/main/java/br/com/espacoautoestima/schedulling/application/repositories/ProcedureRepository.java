package br.com.espacoautoestima.schedulling.application.repositories;

import br.com.espacoautoestima.schedulling.application.model.entities.ProcedureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> {
}
