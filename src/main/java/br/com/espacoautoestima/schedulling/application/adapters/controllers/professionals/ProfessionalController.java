package br.com.espacoautoestima.schedulling.application.adapters.controllers.professionals;

import br.com.espacoautoestima.schedulling.application.services.professionals.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/professionals")
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    // Use 200 status code for successful retrieval of resources
    @GetMapping
    public String listProfessionals() {
        return "List of professionals";
    }

    // Use 201 status code for successful creation of a resource
    @PostMapping
    public String createProfessional() {
        return "Professional created";
    }

    // Use 204 status code for successful deletion of a resource
    @PutMapping
    public String updateProfessional() {
        return "Professional updated";
    }

    // Use 204 status code for successful deletion of a resource
    @DeleteMapping
    public String deleteProfessional() {
        return "Professional deleted";
    }
}
