package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-05 22:22
 */
public class CollectionTest {

    /**
     * Collection接口中的方法
     */
    @Test
    public void test1() {
        Collection col1 = new ArrayList();
        //方法一：add()方法
        col1.add("AA");
        col1.add(123);
        col1.add(false);
        col1.add(new Date());

        //方法二：size()方法
        System.out.println(col1.size());

        Collection col2 = new HashSet();
        col2.add("CC");
        col2.add(false);
        //方法三：addAll()方法
        col1.addAll(col2);
        System.out.println(col1.size());

        //方法四：isEmpty()方法
        System.out.println(col1.isEmpty());

        //方法五：clear()方法
        col1.clear();
        System.out.println(col1.size());

        //方法六：contains()方法
        System.out.println(col1.contains(123));
    }

}
