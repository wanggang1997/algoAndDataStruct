package com.pers.alan.visual_algo.demo;

import javax.swing.*;
import java.awt.*;

public class CardLayoutDemo {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("this is a card layout test");

        //创建卡片式布局的面板
        JPanel cards = new JPanel();
        cards.setLayout(new CardLayout());

        //创建面板1 并添加组件 设置属性
        JPanel jPanel1 = new JPanel();
        JButton button1 = new JButton("登陆");
        JButton button2 = new JButton("注册");
        JButton button3 = new JButton("忘记密码");
        jPanel1.add(button1);
        jPanel1.add(button2);
        jPanel1.add(button3);

        //创建面板2 并添加组件 设置属性
        JPanel jPanel2 = new JPanel();
        JTextField textField1 = new JTextField("请输入用户名", 20);
        JTextField textField2 = new JTextField("请输入密码", 20);
        JTextField textField3 = new JTextField("忘记密码？", 20);
        jPanel2.add(textField1);
        jPanel2.add(textField2);
        jPanel2.add(textField3);

        //将子面板添加到父面板 设置标志
        cards.add(jPanel1, "card1");
        cards.add(jPanel2, "card2");

        //调用CardLayout中的show方法 并指明父类 与将要show的子面板标志
        CardLayout card = (CardLayout)cards.getLayout();
        card.show(cards,"card1");
        //card.show(cards,"card2");

        //将面板组件添加到frame中
        jFrame.add(cards);
        jFrame.setBounds(200, 200, 300, 300);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
