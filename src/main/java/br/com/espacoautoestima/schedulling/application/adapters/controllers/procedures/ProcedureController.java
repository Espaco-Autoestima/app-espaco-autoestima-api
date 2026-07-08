package br.com.espacoautoestima.schedulling.application.adapters.controllers.procedures;

import br.com.espacoautoestima.schedulling.application.adapters.dto.procedure.ProcedureDTORequest;
import br.com.espacoautoestima.schedulling.application.adapters.dto.procedure.ProcedureDTOResponse;
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
    public ResponseEntity<ProcedureDTOResponse> getProcedureById(@PathVariable Long procedureId) {
        ProcedureDTOResponse procedure = procedureService.getProcedureById(procedureId);
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
    public ResponseEntity<Void> updateProcedure(@PathVariable Long procedureId, @NotNull @RequestBody ProcedureDTORequest procedure) {
        procedureService.updateProcedure(procedureId, procedure);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{idProcedure}")
    public ResponseEntity<Void> deleteProcedure(@PathVariable Long procedureId) {
        procedureService.deleteProcedure(procedureId);
        return ResponseEntity.status(204).build();
    }
}
