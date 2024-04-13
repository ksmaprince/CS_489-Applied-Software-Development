package edu.cs489.adssysem.service;


import edu.cs489.adssysem.dto.patient.PatientRequest;
import edu.cs489.adssysem.dto.patient.PatientResponse;
import edu.cs489.adssysem.exception.PatientNotFoundException;
import edu.cs489.adssysem.model.Patient;

import java.util.List;

public interface PatientService {
    PatientResponse savePatient(PatientRequest patientRequest);

    List<PatientResponse> getAllPatient();

    PatientResponse getPatientById(Integer patientId) throws PatientNotFoundException;

    PatientResponse updatePatient(Patient patient);

    void deletePatientById(Integer patientId);
}
