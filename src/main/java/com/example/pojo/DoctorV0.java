package com.example.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorV0 {

    private Integer id;
    private String name;
    private String departmentId;
    private String departmentname;
    private Integer status;



}
