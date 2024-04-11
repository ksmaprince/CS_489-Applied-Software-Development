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
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "Last name can't be blank or null")
    private String lastName;
    @Column(length = 15)
    private String contactPhoneNo;

    @Column(length = 45)
    private String email;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", unique = true, nullable = true)
    private Address address;

    @Column(length = 25)
    private String dob;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;


    public Patient(Integer patientId, String firstName, String lastName, String contactPhoneNo, String email, Address address, String dob) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactPhoneNo = contactPhoneNo;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactPhoneNo='" + contactPhoneNo + '\'' +
                ", email='" + email + '\'' +
                ", mailingAddress=" + address +
                ", dob='" + dob + '\'' +
                '}';
    }
}
