package com.pers.alan.visual_algo.minesweep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {
    //TODO 自定义数据
    private static final int blockSize = 32;
    private static final int delay = 5;

    private MineSweepData data;
    private AlgoJrame frame;

    public AlgoVisualizer(int M, int N, int mineN) {
        //TODO 初始化数据
        data = new MineSweepData(N, M, mineN);
        int sceneWidth = M * blockSize;
        int sceneHeight = N * blockSize;

        //TODO 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoJrame("我的扫雷", sceneWidth, sceneHeight);
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });

    }

    //动画
    private void run() {
        //TODO 自定义动画逻辑
        setData(false, -1, -1);
    }

    private void setData(boolean isLeftClick, int x, int y) {
        if (data.inArea(x, y)) {
            if (isLeftClick) {
                if (data.isMine(x, y)) {
                    data.open[x][y] = true;
                }else {
                    data.open(x,y);
                }
            } else
                data.flag[x][y] = !data.flag[x][y];
        }
        frame.render(data);
        AlgovisHelper.pause(delay);
    }

    /*/**
     * @title
     * @description
     *TODO 有待改进
     * @author wg
     * @param: x
     * @param: y
     * @updateTime 2019/9/7 10:42
     * @return: boolean
     * @throws
     */
    private void autoDispper(int x, int y) {
        if (x < 0 || y < 0 || x >= data.N() || y >= data.M()) {
            return;
        } else if (data.open[x][y]) {
            return;
        } else if (data.isMine(x, y)) {
            return;
        }else if (data.getNumbers(x, y) == 0){
            data.open[x][y] = true;
                for (int i = x-1; i < x+1; i++) {
                    for (int j = x-1; j < x+1; j++) {
                        autoDispper(i,j);
                    }
                }
        }
        else if (data.getNumbers(x, y) > 0 && data.getNumbers(x, y) <= 8) {
            data.open[x][y] = true;
        }
    }
    /*/**
     * @title
     * @description 判断周围九个格子中是否有雷
     *TODO 有待改进
     * @author wg
     * @param: x
     * @param: y
     * @updateTime 2019/9/7 11:40
     * @return: boolean
     * @throws
     */
    private boolean countMine(int x,int y){
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <=y+1 ; j++) {
                if (data.inArea(i,j)){
                    if (data.isMine(i,j))
                        return true;
                }
            }
        }
        return false;
    }


    //TODO 自定义键盘或者鼠标监听
    //键盘输入监听
    private class AlgoKeyListener extends KeyAdapter {
    }

    //鼠标输入监听
    /*/**
     * @title
     * @description
     * @author wg
     * @updateTime 2019/9/7 0:57
     * @throws
     */
    private class AlgoMouseListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            e.translatePoint
                    (
                            -(frame.getBounds().width - frame.getCanvasWidth()) / 2,
                            -(frame.getBounds().height - frame.getCanvasHeight()) / 2
                    );
            Point p = e.getPoint();
            //M 列数 N 行数
            int w = frame.getCanvasWidth() / data.M();
            int h = frame.getCanvasHeight() / data.N();

            //x 列数 y 行数
            int x = p.y / h;
            int y = p.x / w;

            if (SwingUtilities.isLeftMouseButton(e))
                setData(true, x, y);
            else
                setData(false, x, y);
        }
    }

    //TODO 程序入口
    public static void main(String[] args) {
        int N = 20;
        int M = 20;
        int mineN = 50;
        AlgoVisualizer visualizer = new AlgoVisualizer(N, M, mineN);
    }
}
