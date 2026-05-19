package com.example.service.impl;

import com.example.mapper.PatientMapper;
import com.example.pojo.DoctorV0;
import com.example.pojo.Pageresult;
import com.example.pojo.Patient;
import com.example.service.PatientService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceimpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public Pageresult<Patient> page(Integer start, Integer pageSize, String name) {
        PageHelper.startPage(start, pageSize);
        List<Patient> list = patientMapper.list(name);
        Page<Patient> page = (Page<Patient>) list;

        return new Pageresult<Patient>(page.getTotal(),page.getResult());
    }

    @Override
    public void add(Patient patient) {
        patientMapper.add(patient);
    }

    @Override
    public void delete(Integer id) {
        patientMapper.delete(id);
    }

    @Override
    public Patient getInfo(Integer id) {
        return patientMapper.getInfo(id);
    }

    @Override
    public void update(Patient patient) {
        patientMapper.update(patient);
    }
}
