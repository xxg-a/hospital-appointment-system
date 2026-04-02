package com.example.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    private Integer id;
    private String name;
    private String password;
    private String workId;
    private String departmentId;
    private Integer status;



}
