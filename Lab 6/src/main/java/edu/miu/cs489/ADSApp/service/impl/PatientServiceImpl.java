package edu.miu.cs489.ADSApp.service.impl;

import edu.miu.cs489.ADSApp.model.Patient;
import edu.miu.cs489.ADSApp.repository.PatientRepository;
import edu.miu.cs489.ADSApp.service.PatientService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatientById(Integer patientId) {
        patientRepository.deleteById(patientId);
    }
}
