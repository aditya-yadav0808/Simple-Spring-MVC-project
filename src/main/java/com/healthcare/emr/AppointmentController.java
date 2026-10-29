package com.healthcare.emr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

interface AppointmentRepository extends JpaRepository<Appointment, Long> {}

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController extends CrudController<Appointment> {
    AppointmentController(AppointmentRepository repo) { super(repo); }
}
