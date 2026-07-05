package br.com.espacoautoestima.schedulling.application.adapters.controllers.procedures;

import br.com.espacoautoestima.schedulling.application.adapters.dto.ProcedureDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.ProcedureDTOResponse;
import br.com.espacoautoestima.schedulling.application.services.procedures.ProcedureService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/procedures")
public class ProcedureController {

    private final ProcedureService procedureService;

    public ProcedureController(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }

    @GetMapping
    public ResponseEntity<List<ProcedureDTOResponse>> listProcedures() {
        List<ProcedureDTOResponse> procedures = procedureService.getAllProcedures();
        return ResponseEntity.status(200).body(procedures);
    }

    @GetMapping("/{idProcedure}")
    public ResponseEntity<ProcedureDTOResponse> getProcedureById(@PathVariable Long idProcedure) {
        ProcedureDTOResponse procedure = procedureService.getProcedureById(idProcedure);
        return ResponseEntity.status(200).body(procedure);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProcedureDTOResponse>> getProcedureByName(@RequestParam String name) {
        List<ProcedureDTOResponse> procedures = procedureService.getProcedureByName(name);
        return ResponseEntity.status(200).body(procedures);
    }

    @PostMapping
    public ResponseEntity<Void> createProcedure(@NotNull @RequestBody ProcedureDTORequest procedure) {
        procedureService.createProcedure(procedure);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/{idProcedure}")
    public ResponseEntity<Void> updateProcedure(@PathVariable Long idProcedure, @NotNull @RequestBody ProcedureDTORequest procedure) {
        procedureService.updateProcedure(idProcedure, procedure);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{idProcedure}")
    public ResponseEntity<Void> deleteProcedure(@PathVariable Long idProcedure) {
        procedureService.deleteProcedure(idProcedure);
        return ResponseEntity.status(204).build();
    }
}
