package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-05 23:35
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection col = new ArrayList();
        col.add(123);
        col.add("ABC");
        col.add(true);
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testRemove() {
        Collection col = new ArrayList();
        col.add(123);
        col.add("ABC");
        col.add(true);
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("ABC".equals(obj)) {
                iterator.remove();
            }
        }

        Iterator iterator2 = col.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }

}
