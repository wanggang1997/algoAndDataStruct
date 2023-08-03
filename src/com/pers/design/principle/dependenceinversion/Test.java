package com.pers.design.principle.dependenceinversion;

/**
 * @author Lucifer
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2023年08月03日 16:24:00
 */
public class Test {
    public static void main(String[] args) {
        Lucifer lucifer = new Lucifer();
        lucifer.study(new Java());

        LuciferConstruct luciferConstruct = new LuciferConstruct(new Python());
        luciferConstruct.study();
    }
}
