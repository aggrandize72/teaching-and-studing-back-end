package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Student {
    @TableId("s_no")
    private String sNo;
    private String sName;
    private String sSex;
    private String password;
}
