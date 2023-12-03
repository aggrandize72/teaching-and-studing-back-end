package org.example.controller;

import org.example.domain.PostStudent;
import org.example.service.OpenService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("open")
public class OpenController {
    @Autowired
    private OpenService openService;

    @GetMapping("list/{no}")
    public Result query(@PathVariable String no){
        Result result = openService.queryAllAndSno(no);
        System.out.println("open: result = " + result);
        return result;
    }

    @PostMapping("list")
    public Result post(@RequestBody PostStudent postStudent){
        Result result = openService.saveGrade(postStudent.getNo(), postStudent.getList());
        System.out.println("open: result = " + result);
        return result;
    }
}
