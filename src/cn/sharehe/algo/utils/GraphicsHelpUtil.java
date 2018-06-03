package cn.sharehe.algo.utils;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * 画笔帮助类
 * @Author: wugui
 * @Date 2018-6-2 16:48
 */
public class GraphicsHelpUtil {
    private GraphicsHelpUtil(){}

    /**
     * 设置线条宽度与拐角属性
     * @param g2d
     * @param width 线条宽度
     */
    public static void setStroke(Graphics2D g2d, int width){
        g2d.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    /**
     * 绘制空心圆
     * @param g2d
     * @param x 圆心x
     * @param y 圆心y
     * @param r 圆心半径
     */
    public static void strokeCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D ellipse2D =new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(ellipse2D);
    }

    /**
     * 绘制实心圆
     * @param g2d
     * @param x 圆心x
     * @param y 圆心y
     * @param r 半径
     */
    public static void fillCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D ellipse2D = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.fill(ellipse2D);
    }
}
