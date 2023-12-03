package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.Teacher;
import org.example.pojo.User;
import org.example.utils.Result;

import java.util.List;

public interface TeacherService extends IService<Teacher> {

    Result login(User user);

    Result queryAll();

    Result queryAllOpenedTeacher();

    Result saveTeacher(List<Teacher> list);

    Result myUpdateTeacher(Teacher teacher);
}
