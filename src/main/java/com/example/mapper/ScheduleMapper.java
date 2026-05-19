package com.example.mapper;

import com.example.pojo.Schedule;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    List<Schedule> list(String name);

    @Insert("insert into schedule(doctor_id,date,total_quota,remaining_quota) values(#{doctorId},#{date},#{totalQuota},#{remainingQuota})")
    void add(Schedule schedule);

    @Delete("delete from schedule where id=#{id}")
    void delete(Integer id);

    @Select("select schedule.id,schedule.doctor_id,doctor.name,schedule.date,schedule.total_quota,schedule.remaining_quota from schedule" +
            " left join doctor on schedule.doctor_id=doctor.id where schedule.id=#{id}")
    Schedule getInfo(Integer id);

    @Update("update schedule set doctor_id=#{doctorId},date=#{date},total_quota=#{totalQuota},remaining_quota=#{remainingQuota} where id=#{id}")
    void update(Schedule schedule);
}
