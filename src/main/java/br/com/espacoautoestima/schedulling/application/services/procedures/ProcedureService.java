package br.com.espacoautoestima.schedulling.application.services.procedures;

import br.com.espacoautoestima.schedulling.application.infrastructure.repositories.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;
}
