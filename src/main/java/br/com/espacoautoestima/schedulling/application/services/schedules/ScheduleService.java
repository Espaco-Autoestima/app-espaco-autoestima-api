package br.com.espacoautoestima.schedulling.application.services.schedules;

import br.com.espacoautoestima.schedulling.application.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
}
