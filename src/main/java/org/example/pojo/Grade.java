package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Grade {
    @TableId
    private Integer gradeId;
    private Integer openId;
    private String sNo;
    private Integer score;
}
