package edu.cs489.adssysem.controller;

import edu.cs489.adssysem.dto.patient.PatientRequest;
import edu.cs489.adssysem.dto.patient.PatientResponse;
import edu.cs489.adssysem.exception.PatientNotFoundException;
import edu.cs489.adssysem.model.Patient;
import edu.cs489.adssysem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/list")
    public ResponseEntity<List<PatientResponse>> getAllPatient(){
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @GetMapping("/get/{patientId}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Integer patientId) throws PatientNotFoundException {
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

    @PostMapping("/register")
    public ResponseEntity<PatientResponse> addNewPatient(@RequestBody PatientRequest patientRequest){
        return ResponseEntity.ok(patientService.savePatient(patientRequest));
    }
}
