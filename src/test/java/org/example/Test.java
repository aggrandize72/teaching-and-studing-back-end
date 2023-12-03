package org.example;


import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.example.service.CourseService;
import org.example.service.OpenService;
import org.example.service.StudentService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    OpenService openService;

    @org.junit.jupiter.api.Test
    void ss(){
        List<Student> students = studentMapper.queryAllSelectCourseStudent();

        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }

    @org.junit.jupiter.api.Test
    void ss1(){
        Result result = openService.queryAllAndSno("0211001");
        System.out.println("result = " + result);
    }
}
