package com.healthcare.emr;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long patientId;
    public Long doctorId;
    public LocalDateTime appointmentTime;
    public String status = "SCHEDULED";
}
