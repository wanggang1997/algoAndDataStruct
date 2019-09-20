package com.pers.alan.visual_algo.demo;

import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("this is a grid layout test");

        JPanel jPanel = new JPanel(new GridLayout(4,4,5,5));

        JButton button1 = new JButton("7");
        JButton button2 = new JButton("8");
        JButton button3 = new JButton("9");
        JButton button4 = new JButton("/");
        JButton button5 = new JButton("4");
        JButton button6 = new JButton("5");
        JButton button7 = new JButton("6");
        JButton button8 = new JButton("*");
        JButton button9 = new JButton("1");
        JButton button10 = new JButton("2");
        JButton button11 = new JButton("3");
        JButton button12 = new JButton("-");
        JButton button13 = new JButton("0");
        JButton button14 = new JButton(".");
        JButton button15 = new JButton("=");
        JButton button16 = new JButton("+");

        jPanel.add(button1);
        jPanel.add(button2);
        jPanel.add(button3);
        jPanel.add(button4);
        jPanel.add(button5);
        jPanel.add(button6);
        jPanel.add(button7);
        jPanel.add(button8);
        jPanel.add(button9);
        jPanel.add(button10);
        jPanel.add(button11);
        jPanel.add(button12);
        jPanel.add(button13);
        jPanel.add(button14);
        jPanel.add(button15);
        jPanel.add(button16);

        jFrame.add(jPanel);
        jFrame.setBounds(200, 200, 300, 200);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
