package aggregate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author wanyu
 * @create 2022-02-16 10:28
 *
 * Collection
 *
 *
 *
 */
public class Collection_IDEA {
    @Test
    public void CollectionTest1(){
        Collection<Object> arrayList1 = new ArrayList<>();
        //1.add()：添加数据，自动装箱
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("c");
        arrayList1.add(123);
        arrayList1.add(new Date());

        //2.size()：获取添加元素个数
        System.out.println(arrayList1.size());//5

        //3.addAll()：将一个集合全部元素添加到另一个集合当中
        Collection<Object> arrayList2 = new ArrayList<>();
        arrayList1.add("d");
        arrayList1.add("e");
        arrayList1.addAll(arrayList2);//<--

        System.out.println(arrayList1.size());
        System.out.println(arrayList1);

        //4.isEmpty()：判断集合中是否有元素
        System.out.println(arrayList1.isEmpty());

        //5.clear()：清空集合
        arrayList2.clear();

        //6.

    }
}
