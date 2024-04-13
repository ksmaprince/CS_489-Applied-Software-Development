package edu.cs489.adssysem.service.impl;

import edu.cs489.adssysem.dto.patient.PatientRequest;
import edu.cs489.adssysem.dto.patient.PatientResponse;
import edu.cs489.adssysem.exception.PatientNotFoundException;
import edu.cs489.adssysem.model.Address;
import edu.cs489.adssysem.model.Patient;
import edu.cs489.adssysem.repository.PatientRepository;
import edu.cs489.adssysem.service.PatientService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientResponse savePatient(PatientRequest patientRequest) {
        Patient newPatient = new Patient(
                0,
                patientRequest.firstName(),
                patientRequest.lastName(),
                patientRequest.contactPhoneNo(),
                patientRequest.email(),
                patientRequest.dob(),
                new Address(
                        0,
                        patientRequest.address().getStreet(),
                        patientRequest.address().getCity(),
                        patientRequest.address().getState(),
                        patientRequest.address().getZip()
                        )
        );
        Patient patient = patientRepository.save(newPatient);
        return new PatientResponse(
                patient.getPatientId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getContactPhoneNo(),
                patient.getEmail(),
                patient.getDob(),
                new Address(
                        patient.getAddress().getAddressId(),
                        patient.getAddress().getStreet(),
                        patient.getAddress().getCity(),
                        patient.getAddress().getState(),
                        patient.getAddress().getZip()));
    }

    @Override
    public List<PatientResponse> getAllPatient() {
        return patientRepository.findAll(Sort.by("lastName"))
                .stream()
                .map(p -> new PatientResponse(p.getPatientId(), p.getFirstName(), p.getLastName(), p.getContactPhoneNo(), p.getEmail(), p.getDob(), (p.getAddress() != null) ? new Address(p.getAddress().getAddressId(), p.getAddress().getStreet(), p.getAddress().getCity(), p.getAddress().getState(), p.getAddress().getZip()) : null)).toList();
    }

    @Override
    public PatientResponse getPatientById(Integer patientId) throws PatientNotFoundException {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()){
            Patient p = patientOptional.get();
            return new PatientResponse(p.getPatientId(), p.getFirstName(), p.getLastName(), p.getContactPhoneNo(), p.getEmail(), p.getDob(), p.getAddress()!=null? new Address(p.getAddress().getAddressId(), p.getAddress().getStreet(), p.getAddress().getCity(), p.getAddress().getState(), p.getAddress().getZip()) : null);
        }else {
           throw  new PatientNotFoundException(String.format("Error: Patient with Id, %d, is not found.", patientId));
        }
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
