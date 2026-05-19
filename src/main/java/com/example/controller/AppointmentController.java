package com.example.controller;

import com.example.mapper.AppointmentMapper;
import com.example.pojo.Appointment;
import com.example.pojo.DoctorV0;
import com.example.pojo.Pageresult;
import com.example.pojo.Result;
import com.example.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer start, @RequestParam(defaultValue = "10") Integer pageSize, String name){
        Pageresult<Appointment> pageResult = appointmentService.page(start,pageSize,name);
        return Result.success(pageResult);
    }
    @DeleteMapping
    public Result delete(@RequestParam Integer id){
        appointmentService.delete(id);
        return Result.success(null);
    }
    @PostMapping
    public Result add(@RequestBody Appointment appointment){
        appointmentService.add(appointment);
        return Result.success(null);
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        Appointment appointment = appointmentService.getInfo(id);
        return Result.success(appointment);
    }
    @PutMapping
    public Result update(@RequestBody Appointment appointment){
        appointmentService.update(appointment);
        return Result.success(null);
    }



}
