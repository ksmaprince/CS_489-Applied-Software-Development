package edu.miu.cs489.ADSApp.service.impl;

import edu.miu.cs489.ADSApp.model.Surgery;
import edu.miu.cs489.ADSApp.repository.SurgeryRepository;
import edu.miu.cs489.ADSApp.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    private SurgeryRepository surgeryRepository;

    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public Surgery saveSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery getSurgeryById(Integer surgeryId) {
        return surgeryRepository.findById(surgeryId).orElse(null);
    }

    @Override
    public Surgery updateSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public void deleteSurgery(Integer surgeryId) {
        surgeryRepository.deleteById(surgeryId);
    }
}
