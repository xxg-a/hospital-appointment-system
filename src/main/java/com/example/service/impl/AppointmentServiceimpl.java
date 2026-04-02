package com.example.service.impl;

import com.example.mapper.AppointmentMapper;
import com.example.pojo.Appointment;
import com.example.pojo.DoctorV0;
import com.example.pojo.Pageresult;
import com.example.service.AppointmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceimpl implements AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public Pageresult<Appointment> page(Integer start, Integer pageSize, String name) {
        PageHelper.startPage(start, pageSize);
        List<Appointment> list = appointmentMapper.list(name);
        Page<Appointment> page = (Page<Appointment>) list;

        return new Pageresult<Appointment>(page.getTotal(),page.getResult());
    }

    @Override
    public void delete(Integer id) {
        appointmentMapper.delete(id);
    }

    @Override
    public void add(Appointment appointment) {
        appointmentMapper.add(appointment);
    }

    @Override
    public Appointment getInfo(Integer id) {
        return appointmentMapper.getInfo(id);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentMapper.update(appointment);
    }

}
