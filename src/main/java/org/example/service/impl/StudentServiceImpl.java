package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.StudentMapper;
import org.example.pojo.Course;
import org.example.pojo.Student;
import org.example.pojo.User;
import org.example.service.StudentService;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Result login(User user){
        System.out.println("user = " + user);
        Student loginStudent = studentMapper.selectById(user.getUsername());
        if (loginStudent == null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        if (!user.getPassword().isEmpty() && loginStudent.getPassword().equals(user.getPassword())){
            return Result.ok(loginStudent);
        }
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result queryAll() {
        return Result.ok(list());
    }

    @Override
    public Result saveStudent(List<Student> list) {
        List<String> ids = studentMapper.getIds();
        for (String id : ids) {
            boolean flag = false;
            for (Student student : list) {
                if (id.equals(student.getSNo())){
                    flag = true;
                }
            }
            if (!flag){
                studentMapper.deleteById(id);
            }
        }

        saveOrUpdateBatch(list);
        return Result.ok(null);
    }

    @Override
    public Result myUpdateStudent(Student student) {
        return Result.ok(saveOrUpdate(student));
    }

    @Override
    public Result queryAllSelectStudent() {
        return Result.ok(studentMapper.queryAllSelectCourseStudent());
    }
}
