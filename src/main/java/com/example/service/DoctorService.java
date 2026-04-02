package com.example.service;

import com.example.pojo.Doctor;
import com.example.pojo.DoctorV0;
import com.example.pojo.Pageresult;

public interface DoctorService {


    Pageresult<DoctorV0> page(Integer start, Integer pageSize,String name,Integer departmentId);

    void add(Doctor doctor);

    void delete(Integer id);

    Doctor getInfo(Integer id);

    void update(Doctor doctor);
}
