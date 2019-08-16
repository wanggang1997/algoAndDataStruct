package com.pers.algo.graphic.module;

public class Circle {
    public int x, y;
    private int r;
    public int vx, vy;
    private int number;

    public int getR() {
        return this.r;
    }

    public Circle(int x, int y, int r, int vx, int vy, int number) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return number == circle.number;
    }

    public void move(int minx, int miny, int maxx, int maxy, Circle[] circles) {
        x += vx;
        y += vy;
        checkCollision(minx, miny, maxx, maxy);
        checkCircleCollision(circles);
    }

    private void checkCollision(int minx, int miny, int maxx, int maxy) {
        if (x - r < minx) {
            x = r;
            vx = -vx;
        }
        if (x + r >= maxx) {
            x = maxx - r;
            vx = -vx;
        }
        if (y - r < miny) {
            y = r;
            vy = -vy;
        }
        if (y + r >= maxy) {
            y = maxy - r;
            vy = -vy;
        }
    }

    //
    public void checkCircleCollision(Circle[] circles) {
        int r = this.getR();
        for (int i = 0; i < circles.length; i++) {
            if (this.equals(circles[i])) {
                continue;
            }
            int x1 = circles[i].x;
            int y1 = circles[i].y;
            int vx1 = circles[i].vx;
            int vy1 = circles[i].vy;

            double distance = (Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
            double checkN = Math.pow(2 * r, 2);

            if (distance <checkN) {
                System.out.println("碰撞" + i + ":" + number);
                vx = -vx;
                vy = -vy;
            }
        }
    }

}