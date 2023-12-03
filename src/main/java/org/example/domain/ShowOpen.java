package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowOpen {
    private Integer openId;
    private String cName;
    private String tName;
    private Integer maxStudent;
    private Boolean selected;
}
