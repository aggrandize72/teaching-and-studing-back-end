package org.example.controller;

import org.example.pojo.Administrator;
import org.example.pojo.User;
import org.example.service.AdministratorService;
import org.example.service.StudentService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("administrator")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @PostMapping("login")
    public Result login(@RequestBody User user){
        Result result = administratorService.login(user);
        System.out.println("administrator: result = " + result);
        return result;
    }

    @PutMapping("login")
    public Result updateInfo(@RequestBody Administrator administrator){
        Result result = administratorService.myUpdateAdministrator(administrator);
        System.out.println("administrator: result = " + result);
        return result;
    }
}
