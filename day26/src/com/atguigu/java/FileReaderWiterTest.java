package com.atguigu.java;

import org.junit.Test;

import java.awt.*;
import java.io.*;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-01 18:48
 */
public class FileReaderWiterTest {

    public static void main(String[] args) {
        //main方法中，File路径为相较于当前Project的路径
        File file = new File("hello.text");
        System.out.println(file.getAbsolutePath());
        //main方法中，File路径为相较于当前Project的路径
        File file1 = new File("day26\\hello.text");
        System.out.println(file1.getAbsolutePath());
    }

    @Test
    public void testFileReader1() {
        FileReader fileReader = null;
        try {
            //JUnit中，File路径为相较于当前Module的路径
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            //返回读入的一个字符，如果到达文件末尾，返回-1
            int data = fileReader.read();
            while (data != -1) {
                System.out.print((char)data);
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用read()的重载方法读取文件
     */
    @Test
    public void testFileReader2() {
        FileReader fr = null;
        try {
            //1、File类的实例化
            File file = new File("hello.txt");
            //2、FileReader流的实例化
            fr = new FileReader(file);
            //3、读入操作
            char[] cbuf = new char[5];
            int len;
            //read(char[]):返回每次读入到字符数组中的字符个数。如果到达文件末尾，返回-1
            while ((len = fr.read(cbuf)) != -1) {
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }
                String s = new String(cbuf, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭资源
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 字符流写出
     * 1、输出操作，对应的文件可以不存在
     *      如果不存在，输出前会创建此文件
     *      如果存在，new FileWriter(File,boolean)构造方法的第二个boolean类型的参数可以指定是否在文件后追加，true则追加，false则覆盖
     *                new FileWriter(File)构造器创建的流对象默认使用覆盖方式
     */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1、提供File类对象
            File file = new File("hello1.txt");
            //2、提供FileWriter对象
            fw = new FileWriter(file, true);
            //3、写出操作
            fw.write("I have a dream!\n");
            fw.write("You have a dream,too!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用字符输入、输出流实现文本文件的复制
     */
    @Test
    public void testFileReadFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File readFile = new File("hello.txt");
            File writeFile = new File("hello_2.txt");
            fr = new FileReader(readFile);
            fw = new FileWriter(writeFile);

            char[] chars = new char[5];
            int len;
            while ((len = fr.read(chars)) != -1) {
                fw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
