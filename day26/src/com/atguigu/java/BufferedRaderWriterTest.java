package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-03 23:29
 */
public class BufferedRaderWriterTest {

    @Test
    public void testBufferedRaderWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("text.txt")));
            bw = new BufferedWriter(new FileWriter(new File("text_2.txt")));

            //方式一
//            char[] chars = new char[1024];
//            int len;
//            while ((len = br.read(chars)) != -1) {
//                bw.write(chars, 0, len);
//            }

            //方式二：按行读写
            String reader;
            while ((reader = br.readLine()) != null) {
                bw.write(reader);
                bw.write("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
