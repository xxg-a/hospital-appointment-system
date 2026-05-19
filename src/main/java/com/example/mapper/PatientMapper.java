package com.example.mapper;

import com.example.pojo.Patient;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatientMapper {

    public List<Patient> list(String name);

    @Insert("insert into patient(phone,password,id_card,name) values(#{phone},#{password},#{idCard},#{name})")
    void add(Patient patient);

    @Delete("delete from patient where id=#{id}")
    void delete(Integer id);

    @Select("select * from patient where id=#{id}")
    Patient getInfo(Integer id);

    @Update("update patient set phone=#{phone},password=#{password},id_card=#{idCard},name=#{name} where id=#{id}")
    void update(Patient patient);
}
