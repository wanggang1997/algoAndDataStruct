package com.pers.alan.visual_algo.circle;

import javax.swing.*;
import java.awt.*;

public class AlgoJrame extends JFrame {
    private int canvasHeight;
    private int canvasWidth;

    public AlgoJrame(String title, int canvasWidth, int canvasHeight) {
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

    private Circle[] circles;
    public void render(Circle[] circles){
        this.circles=circles;
        //刷新
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
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

            //绘制画笔粗细
            //int stokeWidth = 10;
            // graphics2D.setStroke(new BasicStroke(stokeWidth));
            AlgovisHelper.setStrokeWidth(graphics2D,1);
            AlgovisHelper.setColor(graphics2D, Color.BLACK);
            for(Circle circle :circles){
                if (!circle.isFilled)
                    AlgovisHelper.strokeCircle(graphics2D, circle.x,circle.y,circle.getR());
                else
                    AlgovisHelper.fillCircle(graphics2D, circle.x,circle.y,circle.getR());
            }

            //实心绘制
            //graphics2D.setColor(Color.blue);
            //Ellipse2D circle2 = new Ellipse2D.Double(125, 125, 200, 200);
            //graphics2D.fill(circle2);
            //AlgovisHelper.setColor(graphics2D,Color.blue);
            //AlgovisHelper.fillCircle(graphics2D,canvasWidth/2,canvasHeight/2,200);

            //线绘
           //graphics2D.setColor(Color.red);
            // Ellipse2D circle = new Ellipse2D.Float(50.3F, 50.2F, 250, 250);
            //Ellipse2D circle1 = new Ellipse2D.Double(100, 100, 250, 250);
            //graphics2D.draw(circle1);
           //AlgovisHelper.setColor(graphics2D,Color.red);
           // AlgovisHelper.strokeCircle(graphics2D,canvasWidth/2,canvasHeight/2,200);
        }

        //使用画布来定义画布大小 传入对象：维
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
