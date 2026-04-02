package com.example.service;


import com.example.pojo.Department;
import com.example.pojo.Pageresult;

import java.util.List;

public interface DepartmentService {


    void delete(Integer id);

    void add(Department department);

    Department getById(Integer id);

    void update(Department department);

    Pageresult<Department> page(Integer start, Integer pageSize, String name);
}
