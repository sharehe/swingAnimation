package cn.sharehe.algo.controller;

import cn.sharehe.algo.beans.Circle;
import cn.sharehe.algo.fram.AlgoJFrame;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
/**
 * 圆形数据控制
 * @Author: wugui
 * @Date 2018-6-2 20:02
 */
public class CircleController {
    private AlgoJFrame algoJFrame;
    private int count;
    private int width;
    private int height;
    private Circle[] circles;
    private boolean isRun = true;

    /**
     * @param count 圆形个数
     * @param width 窗口宽度
     * @param height 窗口高度
     */
    public CircleController(int count, int width, int height) {
        this.count = count;
        this.width = width;
        this.height = height;
    }

    /**
     * 启动
     */
    public void start(){
        EventQueue.invokeLater(()->{
            initData();
            algoJFrame = new AlgoJFrame("豆豆" ,width,height);
            algoJFrame.addKeyListener(new AlgoKey());
            algoJFrame.addMouseListener(new AlgoMouse());
            new Thread(()->{
                run();
            }).start();
            algoJFrame.setVisible(true);
        });
    }

    /**
     * 初始化数据  包括 开始坐标 速度 半径
     */
    private void initData(){
        circles = new Circle[this.count];
        Random random = new Random();
        Circle tem = null;
        int r = 0 ,x,y,vx,vy;
        for (int i = 0; i < this.count; i++) {
            r = random.nextInt(5)+5;
            r += 5;
            x = random.nextInt(width-2*r)+r;
            y = random.nextInt(height-2*r)+r;
            vx = random.nextInt(3)+1;
            vy = random.nextInt(3)+1;
            tem = new Circle(x,y,r,vx,vy);
            circles[i] = tem;
        }
    }

    /**
     * 控制小球运动
     */
    private void run(){
        try {
            while (true) {
                if(isRun){
                    for (Circle i : circles){
                        i.move();
                    }
                }
                this.algoJFrame.rePaint(circles);
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 键盘监听事件
     */
    class AlgoKey extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            if(e.getKeyChar() == ' '){
                isRun = ! isRun;
            }
        }
    }

    /**
     * 鼠标监听事件
     */
    class AlgoMouse extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println();
            super.mousePressed(e);
            for (Circle i : circles){
                if (position(i, (int)e.getPoint().getX(), (e.getY() - algoJFrame.getBounds().height + height))) {
                    i.setFIll(!i.isFIll());
                }
            }
        }

        /**
         * 计算点击点是否在圈内
         * @param circle
         * @param x 点击坐标
         * @param y 点击坐标
         * @return 是 为true
         */
        private boolean position(Circle circle, int x, int y){
            return (circle.getX()-x) * (circle.getX()-x) + (circle.getY()-y) * (circle.getY()-y) < circle.getR() * circle.getR();
        }
    }
}


