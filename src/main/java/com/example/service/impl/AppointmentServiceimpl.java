package com.example.service.impl;

import com.example.mapper.AppointmentMapper;
import com.example.pojo.Appointment;
import com.example.pojo.Pageresult;
import com.example.service.AppointmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 预约模块业务实现类
 *
 * @author xxx
 * @date 2025-xx-xx
 */
@Slf4j
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    /**
     * 分页条件查询预约列表
     */
    @Override
    public Pageresult<Appointment> page(Integer start, Integer pageSize, String name) {
        // 参数校验
        Assert.notNull(start, "页码不能为空");
        Assert.notNull(pageSize, "每页条数不能为空");
        Assert.isTrue(start > 0, "页码必须大于0");
        Assert.isTrue(pageSize > 0, "每页条数必须大于0");

        // 分页
        PageHelper.startPage(start, pageSize);
        List<Appointment> list = appointmentMapper.list(name);

        // 封装分页结果（更安全）
        PageInfo<Appointment> pageInfo = new PageInfo<>(list);
        return new Pageresult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 删除预约
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        Assert.notNull(id, "预约ID不能为空");

        // 校验是否存在
        Appointment appointment = appointmentMapper.getInfo(id);
        if (appointment == null) {
            log.error("删除失败，预约不存在，id:{}", id);
            throw new RuntimeException("预约不存在，无法删除");
        }

        appointmentMapper.delete(id);
        log.info("删除预约成功，id:{}", id);
    }

    /**
     * 新增预约
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Appointment appointment) {
        Assert.notNull(appointment, "预约信息不能为空");
        // 可扩展：重复预约校验、医生排班校验等
        appointmentMapper.add(appointment);
        log.info("新增预约成功，患者姓名:{}", appointment.getName());
    }

    /**
     * 根据ID查询预约详情
     */
    @Override
    public Appointment getInfo(Integer id) {
        Assert.notNull(id, "预约ID不能为空");
        return appointmentMapper.getInfo(id);
    }

    /**
     * 更新预约信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Appointment appointment) {
        Assert.notNull(appointment, "预约信息不能为空");
        Assert.notNull(appointment.getId(), "预约ID不能为空");

        // 校验是否存在
        Appointment exist = appointmentMapper.getInfo(appointment.getId());
        if (exist == null) {
            log.error("更新失败，预约不存在，id:{}", appointment.getId());
            throw new RuntimeException("预约不存在，无法更新");
        }

        appointmentMapper.update(appointment);
        log.info("更新预约成功，id:{}", appointment.getId());
    }
}