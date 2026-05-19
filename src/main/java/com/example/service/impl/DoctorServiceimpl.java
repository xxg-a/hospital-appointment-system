package com.example.service.impl;

import com.example.mapper.DoctorMapper;
import com.example.pojo.Doctor;
import com.example.pojo.DoctorV0;
import com.example.pojo.Pageresult;
import com.example.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 医生模块业务实现类
 *
 * @author xx
 * @date 2025
 */
@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * 医生分页条件查询
     */
    @Override
    public Pageresult<DoctorV0> page(Integer start, Integer pageSize, String name, Integer departmentId) {
        // 参数校验
        Assert.notNull(start, "页码不能为空");
        Assert.notNull(pageSize, "每页条数不能为空");
        Assert.isTrue(start > 0, "页码必须大于0");
        Assert.isTrue(pageSize > 0, "每页条数必须大于0");

        // 分页查询
        PageHelper.startPage(start, pageSize);
        List<DoctorV0> list = doctorMapper.list(name, departmentId);

        // 安全封装分页结果
        PageInfo<DoctorV0> pageInfo = new PageInfo<>(list);
        return new Pageresult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 新增医生
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Doctor doctor) {
        Assert.notNull(doctor, "医生信息不能为空");
        Assert.hasText(doctor.getDoctorName(), "医生姓名不能为空");

        doctorMapper.add(doctor);
        log.info("新增医生成功：{}", doctor.getDoctorName());
    }

    /**
     * 删除医生
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        Assert.notNull(id, "医生ID不能为空");

        // 校验医生是否存在
        Doctor doctor = doctorMapper.getInfo(id);
        if (doctor == null) {
            log.error("删除失败，医生不存在，id:{}", id);
            throw new RuntimeException("医生不存在，无法删除");
        }

        doctorMapper.delete(id);
        log.info("删除医生成功，id:{}", id);
    }

    /**
     * 根据ID查询医生详情
     */
    @Override
    public Doctor getInfo(Integer id) {
        Assert.notNull(id, "医生ID不能为空");
        return doctorMapper.getInfo(id);
    }

    /**
     * 更新医生信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Doctor doctor) {
        Assert.notNull(doctor, "医生信息不能为空");
        Assert.notNull(doctor.getId(), "医生ID不能为空");

        // 校验是否存在
        Doctor exist = doctorMapper.getInfo(doctor.getId());
        if (exist == null) {
            log.error("更新失败，医生不存在，id:{}", doctor.getId());
            throw new RuntimeException("医生不存在，无法更新");
        }

        doctorMapper.update(doctor);
        log.info("更新医生成功，id:{}", doctor.getId());
    }
}