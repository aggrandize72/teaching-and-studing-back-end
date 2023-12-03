package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.Student;
import org.example.pojo.User;
import org.example.utils.Result;

import java.util.List;

public interface StudentService extends IService<Student> {

    Result login(User user);

    Result queryAll();

    Result queryAllSelectStudent();

    Result saveStudent(List<Student> list);

    Result myUpdateStudent(Student student);
}
