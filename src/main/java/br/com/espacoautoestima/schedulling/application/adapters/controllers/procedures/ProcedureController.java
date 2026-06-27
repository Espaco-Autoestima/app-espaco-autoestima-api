package br.com.espacoautoestima.schedulling.application.adapters.controllers.procedures;

import br.com.espacoautoestima.schedulling.application.services.procedures.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/procedures")
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @GetMapping
    public String listProcedures() {
        return "List of procedures";
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
