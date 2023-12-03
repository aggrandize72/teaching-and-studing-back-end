package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.Course;

import java.util.List;

public interface CourseMapper extends BaseMapper<Course> {
    List<Course> queryAllOpenCourse();

    List<String> getIds();
}
