package com.healthcare.emr;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class MedicalRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long patientId;
    public Long doctorId;
    public String diagnosis;
    @Column(length = 2000) public String prescription;
    @Column(length = 2000) public String labReport;
    public LocalDate recordDate = LocalDate.now();
}
