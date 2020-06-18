package com.javaee.finalproject.controller;

import com.javaee.finalproject.entity.Homework;
import com.javaee.finalproject.entity.Student;
import com.javaee.finalproject.service.HomeworkService;
import com.javaee.finalproject.service.StudentHomeworkService;
import com.javaee.finalproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private HomeworkService homeworkService;

    @RequestMapping("/login")
    public String login(Student student, HttpServletRequest req, HttpServletResponse resp) {
        if ("get".equalsIgnoreCase(req.getMethod())) {
            return "login";
        } else {
            String account = student.getSid() + "";
            String password = student.getPassword();
            System.out.println("login servlet:  " + account + "    " + password);
            if (account.contains("0000")&&password==studentService.getPassword(account)) {
                Cookie cookie = new Cookie("account", account);
                resp.addCookie(cookie);
                return "teacher_index";
            } else {
                String result = studentService.getPassword(account);
                if (password.equals(result)) {
                    Cookie cookie = new Cookie("account", account);
                    resp.addCookie(cookie);
                    List<Homework> list = homeworkService.get_student_homework(account);
                    req.setAttribute("list", list);
                    return "index";
                } else {
                    return "login";
                }
            }
        }
    }
}
