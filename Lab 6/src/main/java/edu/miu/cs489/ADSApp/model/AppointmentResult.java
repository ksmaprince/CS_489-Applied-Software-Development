package edu.miu.cs489.ADSApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResult {
    private String dentistName;
    private Integer patNo;
    private String patName;
    private String appointmentDateTime;
    private String surgeryNo;


}
