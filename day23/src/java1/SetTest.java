package java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * \----Collection接口
 *      \----Set接口：无序、不可重复
 *          \----HashSet：线程不安全，可以存储null
 *              \----LinkedHashSet：Hash算法存储，同时增加双向链表，记录插入顺序
 *          \----TreeSet：红黑树存储，元素必须是同一个类的对象，且该类必须实现Comparable接口，且判断元素相等不是用equals()方法，而是compareTo()方法
 *
 * @author GuofanLee
 * @date 2019-05-06 12:41
 */
public class SetTest {

    @Test
    public void testHashSet() {
        Set set = new HashSet();
        set.add(83);
        set.add(10);
        set.add(35);
        set.add(null);
        set.add(-4);
        set.add(null);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    @Test
    public void testTreeSet() {
        TreeSet set = new TreeSet();
        set.add(83);
        set.add(10);
        set.add(35);
        set.add(-4);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
