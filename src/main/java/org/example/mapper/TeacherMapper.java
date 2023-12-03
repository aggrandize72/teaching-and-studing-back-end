package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.Teacher;

import java.util.List;

public interface TeacherMapper extends BaseMapper<Teacher> {
    List<Teacher> queryAllOpenedTeacher();

    List<String> getIds();
}
