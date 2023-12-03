package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.domain.ShowGrade;
import org.example.pojo.Grade;

import java.util.List;
import java.util.Set;

public interface GradeMapper extends BaseMapper<Grade> {
    Set<Integer> queryBySno(@Param("sno") String sno);

    void deleteBySno(@Param("sno") String sno);

    void deleteGrade(@Param("open_id") Integer key,@Param("s_no") String no);

    void add(Grade grade);

    List<ShowGrade> queryShowGrade();

    List<ShowGrade> queryShowGradeByTno(@Param("tno") String tno);

    void updateScore(@Param("gradeId") String gradeId,@Param("score") String score);
}
