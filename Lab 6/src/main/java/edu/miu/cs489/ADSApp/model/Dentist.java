package edu.miu.cs489.ADSApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dentist")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentistId;
    private String firstName;
    @Column(nullable = false)
    @NotBlank(message = "Last name can't be null or blank")
    private String lastName;

    @Column(length = 15)
    private String contactPhoneNumber;
    @Column(length = 45)
    private String email;
    private String specialization;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;

}
