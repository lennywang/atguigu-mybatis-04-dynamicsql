package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamicSQL {

    public List<Employee> getEmployeeByConditionIf(Employee employee);

    public List<Employee> getEmployeeByConditionTrim(Employee employee);

    public List<Employee> getEmployeeByConditionChoose(Employee employee);

    public void updateEmployee(Employee employee);

    public List<Employee> getEmployeeByConditionForeach(@Param("ids") List<Integer> ids);

}
