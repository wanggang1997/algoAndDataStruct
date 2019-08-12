package com.pers.algo.graphic.Demo;

import javax.swing.*;
import java.awt.*;

public class JpanelDemo {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("this is a Jpanel demo!");
        jFrame.setBounds(50, 50, 500, 500);
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.cyan);

        JLabel jLabel = new JLabel("this is a jLabel!");
        //jLabel.setBackground(Color.red);

        jPanel.add(jLabel);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

