package com.example.service;

import com.example.pojo.Pageresult;
import com.example.pojo.Patient;

public interface PatientService {
    Pageresult<Patient> page(Integer start, Integer pageSize, String name);

    void add(Patient patient);

    void delete(Integer id);

    Patient getInfo(Integer id);

    void update(Patient patient);
}
