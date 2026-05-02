package br.com.espacoautoestima.schedulling.application.adapters.controllers.schedules;

import br.com.espacoautoestima.schedulling.application.services.schedules.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    // Use 200 status code for successful retrieval of resources
    @GetMapping
    public String listSchedules() {
        return "List of schedules";
    }

    // Use 201 status code for successful creation of a resource
    @PostMapping
    public String createSchedule() {
        return "Schedule created";
    }

    // Use 204 status code for successful deletion of a resource
    @PutMapping
    public String updateSchedule() {
        return "Schedule updated";
    }

    // Use 204 status code for successful deletion of a resource
    @DeleteMapping
    public String deleteSchedule() {
        return "Schedule deleted";
    }
}
