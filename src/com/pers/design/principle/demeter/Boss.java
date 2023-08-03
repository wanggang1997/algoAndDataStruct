package com.pers.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucifer
 * @version 1.0.0
 * @ClassName Boss.java
 * @Description TODO
 * @createTime 2023年08月03日 17:12:00
 */
public class Boss {

    public void commandCheckNumber(TeamLeader teamLeader){
        List<Course>courseList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            courseList.add(new Course());
        }
        teamLeader.checkNumberOfCourse(courseList);
    }

}
