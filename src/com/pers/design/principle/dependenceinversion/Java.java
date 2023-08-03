package com.pers.design.principle.dependenceinversion;


/**
 * @author Lucifer
 * @version 1.0.0
 * @ClassName Java.java
 * @Description TODO
 * @createTime 2023年08月03日 16:21:00
 */
public class Java implements ICourse {
    @Override
    public void study() {
        System.out.println("学习java");
    }
}
