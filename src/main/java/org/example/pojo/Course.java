package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Course{
    @TableId
    private String cNo;
    private String cName;
    private Integer cCredit;
}
