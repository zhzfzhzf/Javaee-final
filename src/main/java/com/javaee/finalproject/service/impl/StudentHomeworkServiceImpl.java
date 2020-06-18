package com.javaee.finalproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javaee.finalproject.entity.Homework;
import com.javaee.finalproject.entity.StudentHomework;
import com.javaee.finalproject.mapper.StudentHomeworkMapper;
import com.javaee.finalproject.service.StudentHomeworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentHomeworkServiceImpl extends ServiceImpl<StudentHomeworkMapper, StudentHomework> implements StudentHomeworkService {

    @Override
    public void insert_student_homework(String account, String id, String homework_content, String title) {
        Date time=new Date();
        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId(account);
        studentHomework.setHomeworkId(id);
        studentHomework.setHomeworkContent(homework_content);
        studentHomework.setTime(time);
        studentHomework.setHomeworkTitle(title);
        baseMapper.insert(studentHomework);
    }

    @Override
    public List<StudentHomework> select_all() {
        List<StudentHomework> studentHomeworkList = baseMapper.selectList(null);
        return studentHomeworkList;
    }
}
