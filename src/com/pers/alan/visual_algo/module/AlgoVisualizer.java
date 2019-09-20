package com.pers.alan.visual_algo.module;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public class AlgoVisualizer {
    //TODO 自定义数据
    private Object data;
    private AlgoJrame frame;

    public AlgoVisualizer(int sceneWidth,int  sceneHeight,int  n ){
        //TODO 初始化数据
        //TODO 初始化视图
        EventQueue.invokeLater(() -> {
        });
    }
    //动画
    private void run(){
       //TODO 自定义动画逻辑
    }
    //TODO 自定义键盘或者鼠标监听
    //键盘输入监听
    private class AlgoKeyListener extends KeyAdapter { }
    //鼠标输入监听
    private class AlgoMouseListener extends MouseAdapter{ }


    //TODO 程序入口
    public static void main(String[] args) {

    }
}
