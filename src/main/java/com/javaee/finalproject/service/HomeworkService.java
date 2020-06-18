package com.javaee.finalproject.service;

import com.javaee.finalproject.entity.Homework;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface HomeworkService extends IService<Homework> {

    List<Homework> get_student_homework(String account);

    List<Homework> get_all_homework();

    void add_homework(String homework_title, String homework_id);
}
