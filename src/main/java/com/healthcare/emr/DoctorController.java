package com.healthcare.emr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

interface DoctorRepository extends JpaRepository<Doctor, Long> {}

@RestController
@RequestMapping("/api/doctors")
public class DoctorController extends CrudController<Doctor> {
    DoctorController(DoctorRepository repo) { super(repo); }
}
