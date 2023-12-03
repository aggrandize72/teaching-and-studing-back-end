package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pojo.Course;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowCourse {
    private String cNo;
    private String cName;
    private Integer cCredit;
    private Integer maxStudent = 0;
    private Boolean opened;

    public ShowCourse(Course course, Boolean opened){
        this.cNo = course.getCNo();
        this.cName = course.getCName();
        this.cCredit = course.getCCredit();
        this.opened = opened;
    }
}
