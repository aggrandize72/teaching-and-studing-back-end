package org.example.controller;

import org.example.pojo.Student;
import org.example.pojo.User;
import org.example.service.StudentService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("login")
    public Result login(@RequestBody User user){
        Result result = studentService.login(user);
        System.out.println("student: result = " + result);
        return result;
    }

    @GetMapping("")
    public Result queryAllStudent(){
        Result result = studentService.queryAll();
        System.out.println("student: result = " + result);
        return result;
    }

    @PostMapping("")
    public Result saveStudent(@RequestBody List<Student> list){
        Result result = studentService.saveStudent(list);
        System.out.println("student: result = " + result);
        return result;
    }

    @PutMapping("")
    public Result updateStudent(@RequestBody Student student){
        Result result = studentService.myUpdateStudent(student);
        System.out.println("student: result = " + result);
        return result;
    }

    @GetMapping("selected")
    public Result queryAllSelectedStudent(){
        Result result = studentService.queryAllSelectStudent();
        System.out.println("student: result = " + result);
        return result;
    }
}
