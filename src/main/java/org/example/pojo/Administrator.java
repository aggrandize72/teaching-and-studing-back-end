package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Administrator{
    @TableId
    private String no;
    private String password;
}
