package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 转换流：属于字符流
 *      InputStreamReader   将字节输入流转为字符输入流
 *      OutputSteamWriter   将字符输出流转为字节输出流
 *
 * @author GuofanLee
 * @date 2019-05-04 00:02
 */
public class InputStreamReaderTest {

    @Test
    public void testInputStreamReader() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream("text.txt");
            isr = new InputStreamReader(fis, "UTF-8");
            char[] chars = new char[10];
            int len;
            while ((len = isr.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void textCopy() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            isr = new InputStreamReader(new FileInputStream("text.txt"), "UTF-8");
            osw = new OutputStreamWriter(new FileOutputStream("text_3.txt"), "gbk");

            char[] chars = new char[1024];
            int len;
            while((len = isr.read(chars)) != -1) {
                osw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
