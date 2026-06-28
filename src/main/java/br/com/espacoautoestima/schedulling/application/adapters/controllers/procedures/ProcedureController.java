package br.com.espacoautoestima.schedulling.application.adapters.controllers.procedures;

import br.com.espacoautoestima.schedulling.application.adapters.dto.ProcedureDTOResponse;
import br.com.espacoautoestima.schedulling.application.services.procedures.ProcedureService;
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

    @PostMapping
    public String createProcedure() {
        return "Procedure created";
    }

    @PutMapping
    public String updateProcedure() {
        return "Procedure updated";
    }

    @DeleteMapping
    public String deleteProcedure() {
        return "Procedure deleted";
    }
}
