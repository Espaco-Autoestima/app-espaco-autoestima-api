package br.com.espacoautoestima.schedulling.application.services.professionals;

import br.com.espacoautoestima.schedulling.application.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;
}
