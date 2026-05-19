package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private Integer id;
    private Integer doctorId;
    private LocalDate date;
    private Integer totalQuota;
    private Integer remainingQuota;

    private String name;
}
