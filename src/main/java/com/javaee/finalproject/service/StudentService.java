package com.javaee.finalproject.service;

import com.javaee.finalproject.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface StudentService extends IService<Student> {

    String getPassword(String account);

    List<Student> get_all_student();

    void add_student(String id, String name);
}
