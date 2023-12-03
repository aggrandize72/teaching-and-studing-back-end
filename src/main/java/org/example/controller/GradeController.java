package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.PostGrade;
import org.example.service.GradeService;
import org.example.service.StudentService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("grade")
@Slf4j
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("")
    public Result queryShowGrade(){
        Result result = gradeService.queryShowGrade();
        System.out.println("grade: result = " + result);
        return result;
    }

    @GetMapping("{tno}")
    public Result queryShowGradeByTno(@PathVariable String tno){
        Result result = gradeService.queryGradeByTno(tno);
        System.out.println("grade: result = " + result);
        return result;
    }

    @PostMapping("")
    public Result postGradeByTno(@RequestBody PostGrade postGrade){
        System.out.println("postGrade = " + postGrade);
        Result result = gradeService.postTnoGrade(postGrade.getNo(), postGrade.getList());
        System.out.println("grade: result = " + result);
        return result;
    }
}
