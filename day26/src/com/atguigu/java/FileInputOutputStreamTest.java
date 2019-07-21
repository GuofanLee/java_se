package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-02 21:38
 */
public class FileInputOutputStreamTest {

    /**
     * 使用字节流处理文本文件时，有可能出现中文乱码
     */
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);
            byte[] bytes = new byte[5];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                String str = new String(bytes, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用字节输入、输出流实现图片的复制
     */
    @Test
    public void testFileInputStreamAndFileOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File readFile = new File("1.jpg");
            File writeFile = new File("2.jpg");
            fis = new FileInputStream(readFile);
            fos = new FileOutputStream(writeFile);

            byte[] bytes = new byte[100];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
