package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {

    List<Student> queryAllSelectCourseStudent();

    List<String> getIds();
}
