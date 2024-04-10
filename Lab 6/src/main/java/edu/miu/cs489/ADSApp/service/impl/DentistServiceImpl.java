package edu.miu.cs489.ADSApp.service.impl;

import edu.miu.cs489.ADSApp.model.Dentist;
import edu.miu.cs489.ADSApp.repository.DentistRepository;
import edu.miu.cs489.ADSApp.service.DentistService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {
    private DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist saveDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist getDentistById(Integer dentistId) {
        return dentistRepository.findById(dentistId).orElse(null);
    }

    @Override
    public Dentist updateDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentistById(Integer dentistId) {
        dentistRepository.deleteById(dentistId);
    }
}
