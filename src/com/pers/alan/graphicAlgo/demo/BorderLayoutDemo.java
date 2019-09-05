package com.pers.alan.graphicAlgo.demo;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("this is a borderLayout test");
        jFrame.setLayout(new BorderLayout());

        JButton button1 = new JButton("上");
        JButton button2 = new JButton("下");
        JButton button3 = new JButton("左");
        JButton button4 = new JButton("右");
        JButton button5 = new JButton("中");

        jFrame.add(button1,BorderLayout.NORTH);
        jFrame.add(button2,BorderLayout.SOUTH);
        jFrame.add(button3,BorderLayout.WEST);
        jFrame.add(button4,BorderLayout.EAST);
        jFrame.add(button5,BorderLayout.CENTER);

        jFrame.setBounds(200, 200, 300, 300);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
