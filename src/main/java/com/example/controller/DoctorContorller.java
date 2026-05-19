package com.example.controller;

import com.example.pojo.Doctor;
import com.example.pojo.Result;
import com.example.pojo.DoctorV0;
import com.example.pojo.Pageresult;
import com.example.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/doctors")
@RestController
public class DoctorContorller {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer start, @RequestParam(defaultValue = "10") Integer pageSize,String name,Integer departmentId){
        Pageresult<DoctorV0> pageResult = doctorService.page(start,pageSize,name,departmentId);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result add(@RequestBody Doctor doctor){
        doctorService.add(doctor);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id){
        doctorService.delete(id);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        Doctor doctor = doctorService.getInfo(id);
        return Result.success(doctor);

    }

    @PutMapping
    public Result update(@RequestBody Doctor doctor){
        doctorService.update(doctor);
        return Result.success();
    }
}
