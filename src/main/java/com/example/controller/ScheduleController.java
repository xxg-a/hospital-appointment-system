package com.example.controller;

import com.example.pojo.Pageresult;
import com.example.pojo.Patient;
import com.example.pojo.Result;
import com.example.pojo.Schedule;
import com.example.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleservice;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer start, @RequestParam(defaultValue = "10") Integer pageSize, String name) {
        Pageresult<Schedule> pageResult = scheduleservice.page(start, pageSize, name);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result add(@RequestBody Schedule schedule){
        scheduleservice.add(schedule);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id){
        scheduleservice.delete(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo( @PathVariable Integer id){
        Schedule schedule = scheduleservice.getInfo(id);
        return Result.success(schedule);

    }
    @PutMapping
    public Result update(@RequestBody Schedule schedule){
        scheduleservice.update(schedule);
        return Result.success();
    }

}
