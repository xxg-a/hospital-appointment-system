package com.example.service.impl;


import com.example.mapper.DoctorMapper;
import com.example.pojo.Doctor;
import com.example.pojo.DoctorV0;
import com.example.pojo.Pageresult;
import com.example.service.DoctorService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceimpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;
    @Override
    public Pageresult<DoctorV0> page(Integer start, Integer pageSize,String name,Integer departmentId) {

        PageHelper.startPage(start, pageSize);
        List<DoctorV0> list = doctorMapper.list(name,departmentId);
        Page<DoctorV0> page = (Page<DoctorV0>) list;

        return new Pageresult<DoctorV0>(page.getTotal(),page.getResult());
    }

    @Override
    public void add(Doctor doctor) {
        doctorMapper.add(doctor);
    }

    @Override
    public void delete(Integer id) {
        doctorMapper.delete(id);
    }

    @Override
    public Doctor getInfo(Integer id) {
        return doctorMapper.getInfo(id);

    }

    @Override
    public void update(Doctor doctor) {
        doctorMapper.update(doctor);
    }
}
