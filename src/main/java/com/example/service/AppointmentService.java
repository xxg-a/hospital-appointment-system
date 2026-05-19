package com.example.service;

import com.example.pojo.Appointment;
import com.example.pojo.Pageresult;

public interface AppointmentService {

    Pageresult<Appointment> page(Integer start, Integer pageSize, String name);

    void delete(Integer id);

    void add(Appointment appointment);

    Appointment getInfo(Integer id);

    void update(Appointment appointment);
}
