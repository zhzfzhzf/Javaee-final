package com.javaee.finalproject.controller;


import com.javaee.finalproject.entity.Homework;
import com.javaee.finalproject.entity.Student;
import com.javaee.finalproject.entity.StudentHomework;
import com.javaee.finalproject.service.HomeworkService;
import com.javaee.finalproject.service.StudentHomeworkService;
import com.javaee.finalproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentHomeworkService studentHomeworkService;

    @RequestMapping("/teacher_index")
    public String teacher_index(){
        return "teacher_index";
    }

    @RequestMapping("/teacher_add_homework")
    public String teacher_add_homework(HttpServletRequest req, HttpServletResponse resp){
        if("get".equalsIgnoreCase(req.getMethod())){
            return "teacher_add_homework";
        }else {
            List<Homework> homeworkList = homeworkService.get_all_homework();
            String homework_title = req.getParameter("title");
            int id = homeworkList.size()+1;
            String homework_id = id+"";
            homeworkService.add_homework(homework_title, homework_id);
            return "teacher_index";
        }
    }

    @RequestMapping("/teacher_add_student")
    public String teacher_add_student(HttpServletRequest req, HttpServletResponse resp){
        if("get".equalsIgnoreCase(req.getMethod())){
            return "teacher_add_student";
        }else{
            List<Student> studentList = studentService.get_all_student();
            String stu_name = req.getParameter("name");
            int id = studentList.size()+1;
            String student_id = id+"";
            studentService.add_student(student_id, stu_name);
            return "teacher_index";
        }
    }

    @RequestMapping("/teacher_check_homework")
    public String teacher_check_homework(HttpServletRequest req, HttpServletResponse resp){
        List<StudentHomework> all_homework = studentHomeworkService.select_all();
        req.setAttribute("homework_list", all_homework);
        return "teacher_check_homework";
    }

}

