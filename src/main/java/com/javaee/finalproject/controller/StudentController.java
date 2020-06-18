package com.javaee.finalproject.controller;


import com.javaee.finalproject.entity.Homework;
import com.javaee.finalproject.service.HomeworkService;
import com.javaee.finalproject.service.StudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentHomeworkService studentHomeworkService;

    @Autowired
    private HomeworkService homeworkService;

    @RequestMapping("/index")
    public String student_index(HttpServletRequest req){
        String account = null;
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("account")){
                account = cookie.getValue();
            }
        }
        if("get".equalsIgnoreCase(req.getMethod())){
            List<Homework> list = homeworkService.get_student_homework(account);
            req.setAttribute("list",list);
            return "index";
        }else{
            String submit_info = req.getParameter("submit");
            String[] info = submit_info.split(" ");
            String id = info[1];
            String title = req.getParameter("homework_title+"+id);
            String homework_content = req.getParameter("content+"+id);
            studentHomeworkService.insert_student_homework(account, id, homework_content,title);
            List<Homework> list = homeworkService.get_student_homework(account);
            req.setAttribute("list",list);
            return "index";
        }
    }

}

