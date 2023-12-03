package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.domain.ShowOpen;
import org.example.pojo.Open;

import java.util.List;

public interface OpenMapper extends BaseMapper<Open> {
    List<ShowOpen> queryAllOpen();
    List<String> queryByTno(String no);

    void deleteOpen(@Param("cno") String cNo,@Param("tno") String tno);

    void add(@Param("cno") String cNo,@Param("tno") String no,@Param("maxStudent") Integer maxStudent);
}
