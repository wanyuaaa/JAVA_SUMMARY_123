package aggregate.collection;

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
public class Collection_API {
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
        arrayList2.add("d");
        arrayList2.add("e");
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

        //10.retainAll(Object obj)：交集，两个集合中的
        Collection arrayList3 = new ArrayList<>();
        arrayList3.add("d");
        arrayList3.add("e");
        //System.out.println(arrayList1.retainAll(arrayList3));//true
        //System.out.println(arrayList1);

        //11.equals()：需要当前集合和形参集合元素都相同
        System.out.println(arrayList1.equals(arrayList3));

        //12.hashCode()：返回哈希值
        System.out.println(arrayList1.hashCode());

        //13.toArray()：集合-->数组
        Object[] objects = arrayList2.toArray();
        //拓展：asList(Array arr)：数组-->集合
        List<String> arrayList4 = Arrays.asList(new String[]{"aa", "bb", "cc"});
        System.out.println(arrayList4);
        //!添加时认为是一个元素，即数组,需用Integer或直接写创建多个对象
        List<int[]> arrayList5 = Arrays.asList(new int[]{123,456,789});
        System.out.println(arrayList5);
        List<Integer> arrayList6 = Arrays.asList(123,456,789);
        System.out.println(arrayList6);

        //14.iterator()：返回iterator接口实例，用于遍历集合元素，放在IteratorTest.java测试
        Iterator<Integer> iterator = arrayList6.iterator();

    }
}
