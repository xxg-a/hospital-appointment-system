package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private Integer id;
    private Integer patientId;
    private String doctorId;
    private Integer scheduleId;
    private String visitReason;

    private String name;
}
