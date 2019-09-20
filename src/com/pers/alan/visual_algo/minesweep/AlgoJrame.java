package com.pers.alan.visual_algo.minesweep;

import javax.swing.*;
import java.awt.*;

public class AlgoJrame extends JFrame {
    //标识游戏正在进行
    private boolean isRunning = true;

    private int canvasHeight;
    private int canvasWidth;

    public AlgoJrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;
        AlgoCanvas canvas = new AlgoCanvas();
        //添加组件
        setContentPane(canvas);
        //调整窗口的大小，使其适应组件的大小和布局。
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public AlgoJrame(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    private MineSweepData data;

    public void render(MineSweepData data) {
        //TODO 自定义data
        this.data = data;        //刷新
        if (!isRunning) {
            JOptionPane.showMessageDialog(null, "再接再厉", "游戏已结束", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        repaint();
    }

    private class AlgoCanvas extends JPanel {
        public AlgoCanvas() {
            //双缓存
            super(true);
        }

        //
        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            //g.drawOval(50, 50, 250, 250);
            Graphics2D graphics2D = (Graphics2D) g;
            //抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //TODO 绘制逻辑
            int w = canvasWidth / data.M();
            int h = canvasHeight / data.N();

            for (int i = 0; i < data.N(); i++) {
                for (int j = 0; j < data.M(); j++) {
                    if (data.open[i][j]) {
                        if (data.isMine(i, j)) {
                            isRunning = false;
                            AlgovisHelper.putImg(graphics2D, j * w, i * h, MineSweepData.mineImageURL);
                        } else
                            AlgovisHelper.putImg(graphics2D, j * w, i * h, MineSweepData.numberImageURL(data.getNumbers(i, j)));
                    } else {
                        if (data.flag[i][j])
                            AlgovisHelper.putImg(graphics2D, j * w, i * h, MineSweepData.flagImageURL);
                        else
                            AlgovisHelper.putImg(graphics2D, j * w, i * h, MineSweepData.blockImageURL);
                    }

                }
            }

        }

        //使用画布来定义画布大小 传入对象：维
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
