package com.javaee.finalproject.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("studenthomework")
public class StudentHomework implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    private String student_id;

    private String homework_id;

    private String homework_title;

    private String homework_content;

    @TableField(fill = FieldFill.INSERT)
    private Date create_time;

    private Date update_time;


    public void setStudentId(String student_id) {
        this.student_id = student_id;
    }

    public String getStudentId() {
        return student_id;
    }

    public void setHomeworkId(String homeworkId) {
        this.homework_id = homework_id;
    }

    public String getHomeworkId() {
        return homework_id;
    }

    public void setHomeworkContent(String homeworkContent) {
        this.homework_content = homework_content;
    }

    public String getHomeworkContent() {
        return homework_content;
    }

    public void setTime(Date time) {
        this.create_time = time;
    }

    public Date getTime() {
        return create_time;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homework_title = homeworkTitle;
    }

    public String getHomeworkTitle() {
        return homework_title;
    }
}
