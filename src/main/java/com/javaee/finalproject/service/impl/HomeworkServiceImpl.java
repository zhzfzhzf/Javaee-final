package com.javaee.finalproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javaee.finalproject.entity.Homework;
import com.javaee.finalproject.entity.StudentHomework;
import com.javaee.finalproject.mapper.HomeworkMapper;
import com.javaee.finalproject.service.HomeworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaee.finalproject.service.StudentHomeworkService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class HomeworkServiceImpl extends ServiceImpl<HomeworkMapper, Homework> implements HomeworkService {

    @Autowired
    private StudentHomeworkService studentHomeworkService;

    @Override
    public List<Homework> get_student_homework(String id) {
        QueryWrapper<StudentHomework> list1 = new QueryWrapper<>();
        List<String> homework_ids = new ArrayList<>();
        List<Homework> homeworkList ;
        QueryWrapper<Homework> list2 = new QueryWrapper<>();
        List<StudentHomework> studentHomeworks = studentHomeworkService.list(list1);
        if(!studentHomeworks.isEmpty()){
            for(StudentHomework studentHomework: studentHomeworks){
                homework_ids.add(studentHomework.getHomeworkId());
            }
            list2.notIn("id", homework_ids);
            homeworkList = baseMapper.selectList(list2);
        }else{
            homeworkList = baseMapper.selectList(null);
        }

        return homeworkList;
    }

    @Override
    public List<Homework> get_all_homework() {
        List<Homework> homeworkList = baseMapper.selectList(null);
        return homeworkList;
    }

    @Override
    public void add_homework(String homework_title, String homework_id) {
        Integer count = baseMapper.selectCount(null);
        Date time=new Date();
        Homework homework = new Homework();
        homework.setId(String.valueOf(count+1));
        homework.setTitle(homework_title);
        homework.setCreate_time(time);
        baseMapper.insert(homework);
    }
}
