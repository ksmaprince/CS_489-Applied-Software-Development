package edu.miu.cs489.ADSApp.service;

import edu.miu.cs489.ADSApp.model.Appointment;
import edu.miu.cs489.ADSApp.model.AppointmentResult;

import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);

    List<Appointment> getAllAppointment();

    Appointment getAppointmentById(Integer appointmentId);

    Appointment updateAppointment(Appointment appointment);

    void deleteAppointmentById(Integer appointmentId);

}
