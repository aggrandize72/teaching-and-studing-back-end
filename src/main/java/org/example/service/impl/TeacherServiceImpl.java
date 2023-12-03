package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.TeacherMapper;
import org.example.pojo.Teacher;
import org.example.pojo.User;
import org.example.service.TeacherService;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Result login(User user){
        Teacher loginTeacher = teacherMapper.selectById(user.getUsername());

        if (loginTeacher == null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        if (!user.getPassword().isEmpty() && loginTeacher.getPassword().equals(user.getPassword())){
            return Result.ok(loginTeacher);
        }
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result queryAll() {
        return Result.ok(list());
    }

    @Override
    public Result saveTeacher(List<Teacher> list) {
        List<String> ids = teacherMapper.getIds();
        for (String id : ids) {
            boolean flag = false;
            for (Teacher teacher : list) {
                if (id.equals(teacher.getTNo())){
                    flag = true;
                }
            }

            if (!flag){
                teacherMapper.deleteById(id);
            }
        }

        saveOrUpdateBatch(list);
        return Result.ok(null);
    }

    @Override
    public Result myUpdateTeacher(Teacher teacher) {
        return Result.ok(saveOrUpdate(teacher));
    }


    @Override
    public Result queryAllOpenedTeacher() {
        return Result.ok(teacherMapper.queryAllOpenedTeacher());
    }


}
