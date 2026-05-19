package com.example.service.impl;

import com.example.mapper.ScheduleMapper;
import com.example.pojo.Pageresult;
import com.example.pojo.Patient;
import com.example.pojo.Schedule;
import com.example.service.ScheduleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceimpl implements ScheduleService {
    @Autowired
    private ScheduleMapper schedulemapper;

    @Override
    public Pageresult<Schedule> page(Integer start, Integer pageSize, String name) {
        PageHelper.startPage(start, pageSize);
        List<Schedule> list = schedulemapper.list(name);
        Page<Schedule> page = (Page<Schedule>) list;

        return new Pageresult<Schedule>(page.getTotal(),page.getResult());
    }

    @Override
    public void add(Schedule schedule) {
        schedulemapper.add(schedule);
    }

    @Override
    public void delete(Integer id) {
        schedulemapper.delete(id);
    }

    @Override
    public Schedule getInfo(Integer id) {
        return schedulemapper.getInfo(id);
    }

    @Override
    public void update(Schedule schedule) {
        schedulemapper.update(schedule);
    }
}