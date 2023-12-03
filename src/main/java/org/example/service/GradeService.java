package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.domain.ShowGrade;
import org.example.pojo.Administrator;
import org.example.pojo.Grade;
import org.example.pojo.User;
import org.example.utils.Result;

import java.util.List;

public interface GradeService extends IService<Grade> {
    Result queryShowGrade();

    Result queryGradeByTno(String tno);

    Result postTnoGrade(String no, List<ShowGrade> list);

//    Result queryStudentAll(String no);
}
