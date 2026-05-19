package com.example.controller;

import com.example.pojo.DoctorV0;
import com.example.pojo.Pageresult;
import com.example.pojo.Patient;
import com.example.pojo.Result;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/patients")
@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer start, @RequestParam(defaultValue = "10") Integer pageSize, String name) {
        Pageresult<Patient> pageResult = patientService.page(start, pageSize, name);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result add(@RequestBody Patient patient){
        patientService.add(patient);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id){
        patientService.delete(id);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        Patient patient = patientService.getInfo(id);
        return Result.success(patient);
    }

    @PutMapping
    public Result update(@RequestBody Patient patient){
        patientService.update(patient);
        return Result.success();
    }

}
