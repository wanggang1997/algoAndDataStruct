package com.pers.alan.graphicAlgo.module;

import java.awt.*;

public class AlgoVisualizer {
    private Circle [] circles;
    private AlgoJrame frame;
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
        EventQueue.invokeLater(() -> {
            frame = new AlgoJrame("welcome", sceneWidth, sceneHeight);
            new Thread(()->{
                run();
            }).start();
        });
    }
    private void run(){
        while (true) {
            frame.render(circles);
            AlgovisHelper.pause(50);
            for (Circle circle : circles) {
                circle.move(0,0, frame.getCanvasWidth(), frame.getCanvasHeight(),circles);
            }
        }
    }

}
