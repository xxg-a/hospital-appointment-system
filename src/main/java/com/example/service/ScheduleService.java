package com.example.service;

import com.example.pojo.Pageresult;
import com.example.pojo.Schedule;

public interface ScheduleService {

    Pageresult<Schedule> page(Integer start, Integer pageSize, String name);

    void add(Schedule schedule);

    void delete(Integer id);

    Schedule getInfo(Integer id);

    void update(Schedule schedule);
}
