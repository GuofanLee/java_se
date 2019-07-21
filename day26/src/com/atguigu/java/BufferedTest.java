package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * @author GuofanLee
 * @date 2019-05-02 22:48
 */
public class BufferedTest {

    /**
     * 使用缓冲流复制图片文件
     * 缓冲流缓冲区默认大小：8kB
     * 用到处理流时，只需关闭外层的处理流，内层的节点流会在处理流中自动关闭
     */
    @Test
    public void bufferedStreamTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1、创建文件
            File srcFile = new File("1.jpg");
            File tarFile = new File("3.jpg");
            //2、创建节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(tarFile);
            //3、创建处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //4、复制文件
            byte[] bytes = new byte[10];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
                //默认情况下，缓冲区满，才将数据输出到目标文件
                //调用缓冲输出流的flush()强制将数据输出到目标文件
//                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //用到处理流时，只需关闭外层的处理流，内层的节点流会在处理流中自动关闭
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用缓冲流复制文件
     */
    public void copeFileWithBuffered(String srcFilePath, String tarFilePath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1、创建文件
            File srcFile = new File(srcFilePath);
            File tarFile = new File(tarFilePath);
            //2、创建节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(tarFile);
            //3、创建处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //4、复制文件
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //用到处理流时，只需关闭外层的处理流，内层的节点流会在处理流中自动关闭
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopeFileWithBuffered() {
        String srcFilePath = new String("C:\\Users\\GuofanLee\\Desktop\\1.avi");
        String tarFilePath = new String("C:\\Users\\GuofanLee\\Desktop\\2.avi");
        long starTime = System.currentTimeMillis();
        copeFileWithBuffered(srcFilePath, tarFilePath);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - starTime));
    }

}
