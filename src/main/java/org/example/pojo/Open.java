package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@TableName("open_table")
@AllArgsConstructor
public class Open {
    @TableId
    private Integer openId;
    private String cNo;
    private String tNo;
    private Integer maxStudent;
}
