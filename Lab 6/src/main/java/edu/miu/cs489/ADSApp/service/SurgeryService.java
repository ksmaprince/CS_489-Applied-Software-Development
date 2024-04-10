package edu.miu.cs489.ADSApp.service;

import edu.miu.cs489.ADSApp.model.Surgery;

import java.util.List;

public interface SurgeryService {
    Surgery saveSurgery(Surgery surgery);

    List<Surgery> getAllSurgeries();

    Surgery getSurgeryById(Integer surgeryId);

    Surgery updateSurgery(Surgery surgery);

    void deleteSurgery(Integer surgeryId);

}
