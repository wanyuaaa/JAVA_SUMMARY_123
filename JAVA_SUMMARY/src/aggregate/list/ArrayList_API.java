package aggregate.list;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wanyu
 * @create 2022-02-17 12:20
 *
 * ArrayList-api
 *
 * void add(int index, Object ele):在index位置插入ele元素
 * boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
 * Object get(int index):获取指定index位置的元素
 * int indexOf(Object obj):返回obj在集合中首次出现的位置
 * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 * Object remove(int index):移除指定index位置的元素，并返回此元素
 * Object set(int index, Object ele):设置指定index位置的元素为ele
 * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
 *
 * 常用方法：
 *      增：add(Object obj)
 *      删：remove(int size)/remove(Object obj)
 *      改：set(int index, Object obj)
 *      查：get(int index)
 *      插：add(int index, Object ele)
 *      长度：size()
 *      遍历：Iterator迭代器/增强for循环/普通循环
 *
 */
public class ArrayList_API {
    @Test
    public void test1(){
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(123);
        arrayList1.add(456);
        arrayList1.add("aa");
        arrayList1.add("bb");
        arrayList1.add(new Date());
        arrayList1.add(789);
        System.out.println(arrayList1);

        //1.void add(int index, Object ele):在index位置插入ele元素
        arrayList1.add(1,"cc");
        System.out.println(arrayList1);

        //2.boolean addAll(int index, Collection c):从index位置开始将c中的所有元素添加进来
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        arrayList1.addAll(integers);
        System.out.println(arrayList1);

        //3.Object get(int index):获取指定index位置的元素
        Object o = arrayList1.get(0);
        System.out.println(o);

        //4.int indexOf(Object obj):返回obj在集合中首次出现的位置/-1
        int i = arrayList1.indexOf(1);
        System.out.println(i);

        //5.int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置/-1
        int il = arrayList1.lastIndexOf(4);
        System.out.println(il);

        //6.Object remove(int index):移除指定index位置的元素，并返回此元素
        //arrayList1.remove(Object obj);
        Object remove = arrayList1.remove(6);
        System.out.println(remove);
        System.out.println(arrayList1);

        //7.Object set(int index, Object ele):设置指定index位置的元素为ele
        arrayList1.set(8, "abc");
        System.out.println(arrayList1);

        //8.List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        List list = arrayList1.subList(5, 6);//左闭右开
        System.out.println(list);

        //9.遍历
        //9.1.迭代器遍历
        Iterator iterator = arrayList1.iterator();
        while (iterator.hasNext())
            System.out.println("iterator:"+iterator.next());
        //9.2.增强for循环
        for (Object obj:arrayList1)
            System.out.println("foreach:"+obj);
        //9.3.普通for循环
        for (int j = 0; j < arrayList1.size(); j++)
            System.out.println("for:"+arrayList1.get(j));

    }

    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(List list) {
        //list.remove(2);//索引
        list.remove(new Integer(2));//对象
    }

}
