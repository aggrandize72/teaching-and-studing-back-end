package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.ShowGrade;
import org.example.mapper.GradeMapper;
import org.example.pojo.Grade;
import org.example.service.GradeService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public Result queryShowGrade() {
        List<ShowGrade> showGrades = gradeMapper.queryShowGrade();
        return Result.ok(showGrades);
    }

    @Override
    public Result queryGradeByTno(String tno) {
        List<ShowGrade> showGrades = gradeMapper.queryShowGradeByTno(tno);
        return Result.ok(showGrades);
    }

    @Override
    public Result postTnoGrade(String no, List<ShowGrade> list) {
        for (ShowGrade showGrade : list) {
            gradeMapper.updateScore(showGrade.getGradeId(), showGrade.getScore());
        }
        return Result.ok(null);
    }
}
