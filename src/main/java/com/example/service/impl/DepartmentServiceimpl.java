package com.example.service.impl;
import com.example.mapper.DepartmentMapper;
import com.example.pojo.Appointment;
import com.example.pojo.Department;
import com.example.pojo.Pageresult;
import com.example.service.DepartmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceimpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void delete(Integer id) {
        departmentMapper.delete(id);
    }
    @Override
    public void add(Department department) {
        departmentMapper.add(department);
    }
    @Override
    public Department getById(Integer id) {
        return departmentMapper.getById(id);
    }
    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public Pageresult<Department> page(Integer start, Integer pageSize, String name) {
        PageHelper.startPage(start, pageSize);
        List<Department> list = departmentMapper.list(name);
        Page<Department> page = (Page<Department>) list;

        return new Pageresult<Department>(page.getTotal(),page.getResult());
    }

}
