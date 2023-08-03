package com.pers.design.principle.demeter;

/**
 * @author Lucifer
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2023年08月03日 17:15:00
 */
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader=new TeamLeader();
        boss.commandCheckNumber(teamLeader);
    }
}
