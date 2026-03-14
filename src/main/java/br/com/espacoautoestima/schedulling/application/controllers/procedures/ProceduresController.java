package br.com.espacoautoestima.schedulling.application.controllers.procedures;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/procedures")
public class ProceduresController {

    // Use 200 status code for successful retrieval of resources
    @GetMapping
    public String listProcedures() {
        return "List of procedures";
    }

    // Use 201 status code for successful creation of a resource
    @PostMapping
    public String createProcedure() {
        return "Procedure created";
    }

    // Use 204 status code for successful deletion of a resource
    @PutMapping
    public String updateProcedure() {
        return "Procedure updated";
    }

    // Use 204 status code for successful deletion of a resource
    @DeleteMapping
    public String deleteProcedure() {
        return "Procedure deleted";
    }
}
