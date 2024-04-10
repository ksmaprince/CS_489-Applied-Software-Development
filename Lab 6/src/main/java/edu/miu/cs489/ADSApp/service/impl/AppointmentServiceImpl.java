package edu.miu.cs489.ADSApp.service.impl;

import edu.miu.cs489.ADSApp.model.Appointment;
import edu.miu.cs489.ADSApp.repository.AppointmentRepository;
import edu.miu.cs489.ADSApp.service.AppointmentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointmentById(Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
