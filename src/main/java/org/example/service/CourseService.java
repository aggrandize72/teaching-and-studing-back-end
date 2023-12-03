package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.domain.ShowCourse;
import org.example.pojo.Administrator;
import org.example.pojo.Course;
import org.example.pojo.User;
import org.example.utils.Result;

import java.util.List;

public interface CourseService extends IService<Course> {

    Result queryAll();

    Result queryAllOpenCourse();

    Result queryAllAndTno(String no);

    Result saveOpen(String no, List<ShowCourse> list);

    Result saveCourse(List<Course> list);
}
