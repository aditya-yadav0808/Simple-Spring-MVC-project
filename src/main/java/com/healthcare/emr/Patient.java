package com.healthcare.emr;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @NotBlank public String name;
    public LocalDate dateOfBirth;
    public String gender;
    public String phone;
    public String insuranceId;
}
