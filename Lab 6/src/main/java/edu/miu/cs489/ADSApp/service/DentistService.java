package edu.miu.cs489.ADSApp.service;

import edu.miu.cs489.ADSApp.model.Dentist;

import java.util.List;

public interface DentistService {
    Dentist saveDentist(Dentist dentist);

    List<Dentist> getAllDentists();

    Dentist getDentistById(Integer dentistId);

    Dentist updateDentist(Dentist dentist);

    void deleteDentistById(Integer dentistId);
}
