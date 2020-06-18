package com.javaee.finalproject.service.impl;

import com.javaee.finalproject.entity.Student;
import com.javaee.finalproject.mapper.StudentMapper;
import com.javaee.finalproject.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public String getPassword(String account) {
        Student student = baseMapper.selectById(account);
        String password = student.getPassword();
        return password;
    }

    @Override
    public List<Student> get_all_student() {
        List<Student> studentList = baseMapper.selectList(null);
        return studentList;
    }

    @Override
    public void add_student(String student_id, String name) {
        Integer count = baseMapper.selectCount(null);
        Date time=new Date();
        Student student = new Student();
        student.setSid(String.valueOf(count+1));
        student.setPassword("1");
        student.setName(name);
        baseMapper.insert(student);
    }
}
