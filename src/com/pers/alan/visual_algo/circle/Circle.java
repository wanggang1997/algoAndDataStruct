package com.pers.alan.visual_algo.circle;

import java.awt.*;

public class Circle {
    public int x, y;
    private int r;
    public int vx, vy;
    private int number;
    public boolean isFilled = false;

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

    public boolean contain(Point p){
        return (x-p.x) * (x -p.x) +( y - p.y)* (y - p.y) <= r*r;
    }

}