package com.example.controller;

import com.example.pojo.Appointment;
import com.example.pojo.Department;
import com.example.pojo.Pageresult;
import com.example.pojo.Result;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/depts")
    public Result page(@RequestParam(defaultValue = "1") Integer start, @RequestParam(defaultValue = "10") Integer pageSize, String name){
        Pageresult<Department> pageResult = departmentService.page(start,pageSize,name);
        return Result.success(pageResult);
    }

    @DeleteMapping("/depts")
    public Result delete(@RequestParam Integer id) {
        System.out.println("删除科室" + id);
        departmentService.delete(id);
        return Result.success();
    }
    @PostMapping("/depts")
    public Result add(@RequestBody Department department){
        System.out.println("增加科室"+department);
        departmentService.add(department);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer id){
        System.out.println("查询科室"+id);
        Department department=departmentService.getById(id);
        return Result.success(department);
    }
    @PutMapping("/depts")
    public Result update(@RequestBody Department department){
        System.out.println("修改科室"+department);
        departmentService.update(department);
        return Result.success();
    }
}
