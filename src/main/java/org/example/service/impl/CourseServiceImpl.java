package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.ShowCourse;
import org.example.domain.ShowOpen;
import org.example.mapper.CourseMapper;
import org.example.mapper.OpenMapper;
import org.example.pojo.Course;
import org.example.pojo.Grade;
import org.example.pojo.Open;
import org.example.service.CourseService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    OpenMapper openMapper;

    @Override
    public Result queryAll() {
        return Result.ok(list());
    }

    @Override
    public Result saveCourse(List<Course> list) {
        List<String> ids = courseMapper.getIds();
        for (String id : ids) {
            boolean flag = false;
            for (Course course : list) {
                if (id.equals(course.getCNo())){
                    flag = true;
                }
            }
            if (!flag){
                courseMapper.deleteById(id);
            }
        }

        saveOrUpdateBatch(list);
        return Result.ok(null);
    }

    @Override
    public Result queryAllOpenCourse() {
        return Result.ok(courseMapper.queryAllOpenCourse());
    }

    @Override
    public Result queryAllAndTno(String no) {
        List<String> cnoList = openMapper.queryByTno(no);
        List<Course> courseList = list();
        List<ShowCourse> showList = new ArrayList<>();
        for (Course course : courseList) {
            ShowCourse showCourse = new ShowCourse(course, false);
            if (cnoList.contains(course.getCNo())){
                showCourse.setOpened(true);
            }
            showList.add(showCourse);
        }
        return Result.ok(showList);
    }

    @Override
    public Result saveOpen(String no, List<ShowCourse> list) {
        List<String> strings = openMapper.queryByTno(no);
        for (ShowCourse showCourse : list) {
            if (showCourse.getOpened() && !strings.contains(showCourse.getCNo())){
                openMapper.add(showCourse.getCNo(), no, showCourse.getMaxStudent());
            } else if (!showCourse.getOpened() && strings.contains(showCourse.getCNo())){
                openMapper.deleteOpen(showCourse.getCNo(), no);
            }
        }
        return Result.ok(null);
    }


}
