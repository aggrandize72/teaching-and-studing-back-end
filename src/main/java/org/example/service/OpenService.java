package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.domain.ShowOpen;
import org.example.pojo.Open;
import org.example.utils.Result;

import java.util.List;

public interface OpenService extends IService<Open> {

    Result queryAll();

    Result queryAllAndSno(String no);

    Result saveGrade(String no, List<ShowOpen> list);
}
