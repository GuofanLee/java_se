package com.atguigu.java;

import org.junit.Test;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-11 01:38
 */
public class FinallyReturnTest {

    @Test
    public void finallReturnTest() {
        System.out.println(finallyReturn());
    }

    private int finallyReturn () {
        int i = 0;
        try {
            i = 10;
            int b = 6/0;
        } catch (Exception e) {
            return i = 20;
        }finally {
            i = 30;
            return  i;
        }
    }

}
