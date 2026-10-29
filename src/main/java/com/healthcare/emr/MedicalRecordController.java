package com.healthcare.emr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {}

@RestController
@RequestMapping("/api/records")
public class MedicalRecordController extends CrudController<MedicalRecord> {
    MedicalRecordController(MedicalRecordRepository repo) { super(repo); }
}
