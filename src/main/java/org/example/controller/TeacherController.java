package org.example.controller;

import org.example.pojo.Teacher;
import org.example.pojo.User;
import org.example.service.TeacherService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("login")
    public Result login(@RequestBody User user){
        Result result = teacherService.login(user);
        System.out.println("teacher: result = " + result);
        return result;
    }

    @GetMapping("")
    public Result queryAllTeacher(){
        Result result = teacherService.queryAll();
        System.out.println("teacher: result = " + result);
        return result;
    }

    @PostMapping("")
    public Result saveTeacher(@RequestBody List<Teacher> list){
        Result result = teacherService.saveTeacher(list);
        System.out.println("teacher: result = " + result);
        return result;
    }

    @PutMapping("")
    public Result updateTeacher(@RequestBody Teacher teacher){
        Result result = teacherService.myUpdateTeacher(teacher);
        System.out.println("teacher: result = " + result);
        return result;
    }

    @GetMapping("opened")
    public Result queryAllSelectedStudent(){

        Result result = teacherService.queryAllOpenedTeacher();
        System.out.println("teacher: result = " + result);
        return result;
    }
}
