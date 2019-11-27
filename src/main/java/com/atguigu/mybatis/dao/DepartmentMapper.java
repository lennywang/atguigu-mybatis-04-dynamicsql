package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Department;

public interface DepartmentMapper {

    public Department getDepartmentById(Integer id);

    public Department getDepartmentByIdPlus(Integer id);
}
