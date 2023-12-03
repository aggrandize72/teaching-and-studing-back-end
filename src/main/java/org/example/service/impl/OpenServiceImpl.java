package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.ShowOpen;
import org.example.mapper.GradeMapper;
import org.example.mapper.OpenMapper;
import org.example.pojo.Grade;
import org.example.pojo.Open;
import org.example.service.OpenService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OpenServiceImpl extends ServiceImpl<OpenMapper, Open> implements OpenService {
    @Autowired
    OpenMapper openMapper;
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public Result queryAll() {
        return Result.ok(list());
    }

    @Override
    public Result queryAllAndSno(String no) {
        Set<Integer> openIds = gradeMapper.queryBySno(no);
        List<ShowOpen> list = openMapper.queryAllOpen();
        for (ShowOpen showOpen : list) {
            showOpen.setSelected(false);
            if (openIds.contains(showOpen.getOpenId())){
                showOpen.setSelected(true);
            }
        }
        return Result.ok(list);
    }

    @Override
    public Result saveGrade(String no, List<ShowOpen> list) {
        Set<Integer> integers = gradeMapper.queryBySno(no);
        for (ShowOpen showOpen : list) {
            if (showOpen.getSelected() && !integers.contains(showOpen.getOpenId())){
                gradeMapper.add(new Grade(null, showOpen.getOpenId(), no, null));
            } else if (!showOpen.getSelected() && integers.contains(showOpen.getOpenId())) {
                gradeMapper.deleteGrade(showOpen.getOpenId(), no);
            }
        }
        return Result.ok(null);
    }
}
