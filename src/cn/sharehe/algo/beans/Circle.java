package cn.sharehe.algo.beans;

import cn.sharehe.algo.fram.AlgoJFrame;

/**
 * 圆形实体类
 * @Author: wugui
 * @Date 2018-6-2 17:11
 */
public class Circle {
    private int x,y; //坐标
    private int r;      // 半径
    private int vx,vy;  // 速度
    private boolean isFIll; //是否为实心
    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public  void move(){
        vx = x + vx + r > AlgoJFrame.canvasWidth || x + vx  < r ? -vx : vx ;
        vy = y + vy + r > AlgoJFrame.canvasHeight || y + vy  < r ? -vy : vy ;
        x += vx;
        y += vy;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public boolean isFIll() {
        return isFIll;
    }

    public void setFIll(boolean FIll) {
        isFIll = FIll;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", vx=" + vx +
                ", vy=" + vy +
                '}';
    }
}
