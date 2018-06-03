package cn.sharehe.algo.fram;

import cn.sharehe.algo.beans.Circle;
import cn.sharehe.algo.utils.GraphicsHelpUtil;

import javax.swing.*;
import java.awt.*;

/**
 * 算法展示窗口
 * @Author: wugui
 * @Date 2018-6-2 15:07
 */
public class AlgoJFrame extends JFrame {
    public static int canvasWidth;
    public static int canvasHeight;
    private Circle[] circles;
    /**
     * 自定义构造函数
     * @param title jFrame 标题
     * @param canvasWidth 面板长度
     * @param canvasHeight 面板高度
     */
    public AlgoJFrame(String title, int canvasWidth, int canvasHeight){
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        AlgoJPanl algoJPanl = new AlgoJPanl();
        this.setContentPane(algoJPanl);
        this.pack();
    }
    public void rePaint(Circle [] circles){
        this.circles = circles;
        repaint();
    }
    private class AlgoJPanl extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);
            g2d.setColor(Color.red);
            for(Circle i : circles){
                if(i.isFIll())
                    GraphicsHelpUtil.fillCircle(g2d, i.getX(), i.getY() ,i.getR());
                else
                    GraphicsHelpUtil.strokeCircle(g2d, i.getX(), i.getY() ,i.getR());
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
