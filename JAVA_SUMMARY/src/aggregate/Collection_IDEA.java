package aggregate;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wanyu
 * @create 2022-02-16 10:28
 *
 * Collection
 *
 * 15.API
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
        arrayList1.add(new String("tom"));

        //2.size()：获取添加元素个数
        System.out.println(arrayList1.size());//5

        //3.addAll()：将一个集合全部元素添加到另一个集合当中
        Collection<Object> arrayList2 = new ArrayList<>();
        arrayList1.add("d");
        arrayList1.add("e");
        arrayList1.addAll(arrayList2);//<--

        System.out.println(arrayList1.size());
        System.out.println(arrayList1);

        //4.isEmpty()：判断集合中是否为空
        System.out.println(arrayList1.isEmpty());//false

        //5.clear()：清空集合
        arrayList2.clear();

        //6.contains(Object obj)：判断当前集合中是否包含obj,
        System.out.println(arrayList1.contains(123));//true
        System.out.println(arrayList1.contains("a"));//true
        System.out.println(arrayList1.contains(new String("tom")));//true，String重写了equals()
        System.out.println(arrayList1.contains(new Date()));//false,对象对比需要重写equals()

        //7.判断形参coll中的所有元素是否都在当前集合当中
        Collection asList1 = Arrays.asList("a", "b", "c",123);
        System.out.println(arrayList1.containsAll(asList1));//ture

        //8.remove()：移除集合中元素
        arrayList1.remove("a");//true
        System.out.println(arrayList1);

        //9.removeAll()：移除多个集合中元素,差集
        Collection asList2 = Arrays.asList("a", "b", "c",123);
        arrayList1.removeAll(asList2);
        System.out.println(arrayList1);

        //10.
    }
}
