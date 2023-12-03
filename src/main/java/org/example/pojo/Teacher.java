package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Teacher {
    @TableId
    private String tNo;
    private String tName;
    private Integer tAge;
    private String password;
}
