package org.example.domain;

import lombok.Getter;
import lombok.ToString;
import org.example.pojo.Grade;

import java.util.List;

@Getter
@ToString
public class PostGrade {
    private String no;
    private List<ShowGrade> list;
}