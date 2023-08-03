package com.pers.design.principle.dependenceinversion;

/**
 * @author Lucifer
 * @version 1.0.0
 * @ClassName LuciferConstruct.java
 * @Description TODO
 * @createTime 2023年08月03日 16:26:00
 */
public class LuciferConstruct {
    private ICourse iCourse;

    public LuciferConstruct(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void study(){
        iCourse.study();
    }

}
