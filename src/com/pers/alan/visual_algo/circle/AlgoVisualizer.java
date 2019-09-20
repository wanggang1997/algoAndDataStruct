package com.pers.alan.visual_algo.circle;

import java.awt.*;
import java.awt.event.*;

public class AlgoVisualizer {
    private Circle [] circles;
    private AlgoJrame frame;
    private boolean isAnimated = true;

    public AlgoVisualizer(int sceneWidth,int  sceneHeight,int  n ){
        circles = new Circle[n];
        int r = 50;
        for (int i=0;i<n;i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * r)) + r;
            int y = (int) (Math.random() * (sceneHeight - 2 * r)) + r;
            int vx = (int) (Math.random() * (11)) - 5;
            int vy = (int) (Math.random() * (11)) - 5;
            circles[i]=new Circle(x, y, r, vx, vy,i);
        }
        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoJrame("welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(()->{
                run();
            }).start();
        });
    }
    //动画
    private void run(){
        while (true) {
            //绘制
            frame.render(circles);
            AlgovisHelper.pause(20);
            //更新数据
            if (isAnimated)
            for (Circle circle : circles) {

                circle.move(0,0, frame.getCanvasWidth(), frame.getCanvasHeight(),circles);
            }
        }
    }
    //键盘输入监听
    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyChar()==' ')
                isAnimated = !isAnimated;
        }
    }

    //鼠标输入监听
    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            e.translatePoint(-(frame.getBounds().width - frame.getCanvasWidth())/2,
                    -(frame.getBounds().height-frame.getCanvasHeight()));
            for (Circle circle : circles)
                if (circle.contain(e.getPoint()))
                    circle.isFilled = !circle.isFilled;
        }
    }
}
