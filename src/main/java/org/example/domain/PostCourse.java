package org.example.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
public class PostCourse {
    private String no;
    private List<ShowCourse> list;
}
