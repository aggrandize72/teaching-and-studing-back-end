package org.example.controller;

import org.example.domain.PostCourse;
import org.example.pojo.Course;
import org.example.service.CourseService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public Result queryAllCourse(){
        Result result = courseService.queryAll();
        System.out.println("teacher: result = " + result);
        return result;
    }

    @PostMapping("")
    public Result saveCourse(@RequestBody List<Course> list){
        Result result = courseService.saveCourse(list);
        System.out.println("teacher: result = " + result);
        return result;
    }

    @GetMapping("open")
    public Result queryAllOpenCourse(){
        Result result = courseService.queryAllOpenCourse();
        System.out.println("teacher: result = " + result);
        return result;
    }

    @GetMapping("list/{no}")
    public Result query(@PathVariable String no){
        Result result = courseService.queryAllAndTno(no);
        System.out.println("teacher: result = " + result);
        return result;
    }

    @PostMapping("list")
    public Result postList(@RequestBody PostCourse postCourse){
        System.out.println("coursePost = " + postCourse);
        Result result = courseService.saveOpen(postCourse.getNo(), postCourse.getList());
        System.out.println("teacher: result = " + result);
        return result;
    }
}
