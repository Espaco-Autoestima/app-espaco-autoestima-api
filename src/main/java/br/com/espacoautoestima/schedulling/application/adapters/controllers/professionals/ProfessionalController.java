package br.com.espacoautoestima.schedulling.application.adapters.controllers.professionals;

import br.com.espacoautoestima.schedulling.application.adapters.dto.professional.ProfessionalDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.professional.ProfessionalDTOResponse;
import br.com.espacoautoestima.schedulling.application.services.professionals.ProfessionalService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/professionals")
public class ProfessionalController {

    private ProfessionalService professionalService;

    public ProfessionalController(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalDTOResponse>> listProfessionals() {
        List<ProfessionalDTOResponse> professionals = professionalService.getAllProfessionals();
        return ResponseEntity.status(200).body(professionals);
    }

    @GetMapping("/{professionalId}")
    public ResponseEntity<ProfessionalDTOResponse> getProfessionalById(@PathVariable Long professionalId) {
        ProfessionalDTOResponse professional = professionalService.getProfessionalById(professionalId);
        return ResponseEntity.status(200).body(professional);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProfessionalDTOResponse>> getProfessionalByName(@RequestParam String name) {
        List<ProfessionalDTOResponse> professionals = professionalService.getProfessionalByName(name);
        return ResponseEntity.status(200).body(professionals);
    }

    @PostMapping
    public ResponseEntity<Void> createProfessional(@NotNull @RequestBody ProfessionalDTORequest professionalDTORequest) {
        professionalService.createProfessional(professionalDTORequest);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/{professionalId}")
    public ResponseEntity<Void> updateProfessional(@PathVariable Long professionalId, @NotNull @RequestBody ProfessionalDTORequest professionalDTORequest) {
        professionalService.updateProfessional(professionalId, professionalDTORequest);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{professionalId}")
    public ResponseEntity<Void> deleteProfessional(@PathVariable Long professionalId) {
        professionalService.deleteProfessional(professionalId);
        return ResponseEntity.status(200).build();
    }
}
