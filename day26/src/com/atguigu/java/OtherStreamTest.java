package com.atguigu.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-04 14:54
 */
public class OtherStreamTest {

    /**
     * 标准输入输出流
     *      System.in：  标准输入流，默认从键盘读入
     *      System.out:  标准输出流，默认从控制台输出
     *
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出，
     * 然后继续进行输入操作，直至输入“e”或者“exit”时，程序退出
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("请输入字符串：");
                String str = br.readLine();
                if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = str.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
