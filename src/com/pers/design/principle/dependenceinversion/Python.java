package com.pers.design.principle.dependenceinversion;

/**
 * @author Lucifer
 * @version 1.0.0
 * @ClassName Python.java
 * @Description TODO
 * @createTime 2023年08月03日 16:22:00
 */
public class Python implements ICourse{
    @Override
    public void study() {
        System.out.println("学习Python");
    }
}
