package com.atguigu.java.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-04-27 15:24
 */
public class ReflectionTest {

    /**
     * 反射之前，对于Person类的操作
     */
    @Test
    public void test1() {
        Person p1 = new Person("Tom", 12);
        System.out.println(p1);
    }

    /**
     * 使用反射对Person类操作
     */
    @Test
    public void test2() throws Exception {
        //1、通过反射，创建Person对象
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p);
        //2、通过反射，调用对象的属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 18);
        System.out.println(p);
        //3、通过反射，调用对象的方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        //4、通过反射，调用对象的私有构造方法
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person p1 = (Person) declaredConstructor.newInstance("Jerry");
        System.out.println(p1);
        //5、通过反射，调用对象的私有成员变量
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Jack");
        System.out.println(p1);
        //5、通过反射，调用对象的私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "China");    //方法返回值
        System.out.println(nation);
    }

    /**
     * 获取Class实例的四种方式
     */
    @Test
    public void test3() throws Exception {
        //方式一：类名.class  class为类的属性
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：对象名.getClass()    getClass()为Object类的方法
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方式三：通过Class.forName("类的全路径")  forName(String classPath)为Class类的静态方法
        Class clazz3 = Class.forName("com.atguigu.java.reflection.Person");
        System.out.println(clazz3);

        System.out.println("**********************");
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);
        System.out.println("**********************");

        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.reflection.Person");
        System.out.println(clazz4);

        System.out.println("**********************");
        System.out.println(clazz1 == clazz4);
        System.out.println("**********************");

    }

}
