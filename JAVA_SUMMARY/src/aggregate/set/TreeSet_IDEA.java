package aggregate.set;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author wanyu
 * @create 2022-02-17 16:56
 *
 * TreeSet
 *
 * 1.要求添加的对象为同类的对象
 * 2.两种排序方式：
 *      自然排序：比较两个对象是否相同的标准，compareTo()返回0，不再是equals(),实现compareTo()接口
 *      定制排序：比较两个对象是否相同的标准，compare()返回0，不再是equals(),实现compareTo()接口
 *
 *
 */
public class TreeSet_IDEA {
    @Test
    public void test1(){
        TreeSet<Object> treeSet1 = new TreeSet<>();
        treeSet1.add(1);
        treeSet1.add(12);
        treeSet1.add(2);
        treeSet1.add(3);
        treeSet1.add(4);
        //treeSet1.add("aa");
        //treeSet1.add("bb");
        //treeSet1.add(new Date());

        System.out.println(treeSet1);
        // class java.lang.Integer cannot be cast to class java.lang.String
    }

    @Test
    public void test2(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(1);
        treeSet.add(12);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);

        System.out.println(treeSet);
    }
}
