package com.example.mapper;

import com.example.pojo.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {


    @Delete("DELETE FROM department WHERE id = #{id}")
    void delete(Integer id);

    @Insert("INSERT INTO department (name,floor,parent_id) VALUES (#{name},#{floor},#{parentId})")
    void add(Department department);

    @Select("SELECT id, name,floor,parent_id FROM department WHERE id=#{id}")
    Department getById(Integer id);

    @Update("UPDATE department SET name=#{name},floor=#{floor},parent_id=#{parentId} WHERE id=#{id}")
    void update(Department department);

    List<Department> list(String name);
}
