package com.healthcare.emr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

interface PatientRepository extends JpaRepository<Patient, Long> {}

@RestController
@RequestMapping("/api/patients")
public class PatientController extends CrudController<Patient> {
    PatientController(PatientRepository repo) { super(repo); }
}
