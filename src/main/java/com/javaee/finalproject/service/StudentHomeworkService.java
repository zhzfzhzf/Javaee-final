package com.javaee.finalproject.service;

import com.javaee.finalproject.entity.Homework;
import com.javaee.finalproject.entity.StudentHomework;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface StudentHomeworkService extends IService<StudentHomework> {

    void insert_student_homework(String id, String student_id, String homework_content, String title);

    List<StudentHomework> select_all();
}
