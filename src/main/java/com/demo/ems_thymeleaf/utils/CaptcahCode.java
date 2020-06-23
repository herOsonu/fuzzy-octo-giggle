package com.demo.ems_thymeleaf.utils;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码工具类
 */
public class CaptcahCode {

    /**
     * 验证码的生成方法
     * @param response
     * @return
     */
    public static String drawImage(HttpServletResponse response) {

        //1、使用stringbuilder类，对字符串进行处理。不用String，因为其赋值后不能改变。
        StringBuilder builder = new StringBuilder();
        //2、产生随机数，长度为4
        for (int i = 0; i < 4; i++) {
            builder.append(randomChar());
        }

        String  code = builder.toString();
        //3、定义图片的宽度和高度，使用BufferedImage对象。
        int width = 120;
        int height = 25;

        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //4、获取Graphics2D 绘制对象，开始绘制验证码
        Graphics2D g = bi.createGraphics();
        //5、定义文字的字体和大小
        Font font = new Font("微软雅黑",Font.PLAIN,20);
        //6、定义字体的颜色
        Color color = new Color(0,0,0);
        //设置字体
        g.setFont(font);
        //设置颜色
        g.setColor(color);
        //设置背景
        g.setBackground(new Color(226,226,240   ));
        //开始绘制对象
        g.clearRect(0,0,width,height);
        //绘制形状，获取矩形对象
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code,context);
        //计算文件的坐标和间距
        double x = (width - bounds.getWidth())/2;
        double y = (height- bounds.getHeight())/2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code,(int)x,(int)baseY);
        //结束绘制
        g.dispose();

        try {
            ImageIO.write(bi,"jpg",response.getOutputStream());
            //刷新响应流
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;

    }

    /**
     * 此方法用于用户产生随机字母和数字
     * @return
     */
    private static char randomChar(){
        // 1、定义验证需要的字母和数字
        String str = "ZXCVBNMASDFGHJKLQWERTYUIOP0123456789";
        //2、定义随机对象
        Random random = new Random();
        //3、返回随机字符
        return  str.charAt(random.nextInt(str.length()));

    }


}
