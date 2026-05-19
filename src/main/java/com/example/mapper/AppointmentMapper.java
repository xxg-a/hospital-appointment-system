package com.example.mapper;

import com.example.pojo.Appointment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppointmentMapper {

    List<Appointment> list(String name);

    @Delete("delete from appointment where id=#{id}")
    void delete(Integer id);

    @Insert("insert into appointment(patient_id,doctor_id,schedule_id,visit_reason) values(#{patientId},#{doctorId},#{scheduleId},#{visitReason})")
    void add(Appointment appointment);

    @Select("select appointment.id,appointment.patient_id,doctor.name,appointment.doctor_id,appointment.schedule_id,appointment.visit_reason from appointment" +
            " left join doctor on appointment.doctor_id=doctor.id  where appointment.id=#{id}")
    Appointment getInfo(Integer id);

    @Update("update appointment set patient_id=#{patientId},doctor_id=#{doctorId},schedule_id=#{scheduleId},visit_reason=#{visitReason} where id=#{id}")
    void update(Appointment appointment);
}
