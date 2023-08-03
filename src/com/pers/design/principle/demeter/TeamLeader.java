package com.pers.design.principle.demeter;

import java.util.List;

/**
 * @author Lucifer
 * @version 1.0.0
 * @ClassName TeamLeader.java
 * @Description TODO
 * @createTime 2023年08月03日 17:13:00
 */
public class TeamLeader {
    public void checkNumberOfCourse(List<Course> courses){

        System.out.println(courses);
    }
}
