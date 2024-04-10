package edu.miu.cs489.ADSApp.service;

import edu.miu.cs489.ADSApp.model.Patient;

import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);

    List<Patient> getAllPatient();

    Patient getPatientById(Integer patientId);

    Patient updatePatient(Patient patient);

    void deletePatientById(Integer patientId);
}
