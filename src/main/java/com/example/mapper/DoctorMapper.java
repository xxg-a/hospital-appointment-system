package com.example.mapper;

import com.example.pojo.Doctor;
import com.example.pojo.DoctorV0;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapper {



    public List<DoctorV0> list(String name,Integer departmentId);

    @Insert("insert into doctor (name,department_id,work_id,password,status) values(#{name},#{departmentId},#{workId},#{password},#{status})")
    void add(Doctor doctor);

    @Delete("delete from doctor where id =#{id}")
    void delete(Integer id);

    @Select("select * from doctor where id =#{id}")
    Doctor getInfo(Integer id);

    void update(Doctor doctor);
}
