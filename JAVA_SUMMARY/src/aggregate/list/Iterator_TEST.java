package aggregate.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author wanyu
 * @create 2022-02-16 16:11
 *
 * 集合元素的遍历操作，用于Iterator接口
 *
 * 实现Iterator接口时即创建指针指向用于Iterator队列第一个元素的上方，当调用hasNext()时，指针指向第一项
 *
 * Iterator接口remove()方法
 *       Iterator可以删除集合的元素，但是是遍历过程中通过迭代器对象的remove方法，不是集合对象的remove方法。
 *       如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，再调用remove都会报IllegalStateException。
 *
 */
public class Iterator_TEST {
    @Test
    public void test1(){
        Collection arrayList1 = new ArrayList<>();
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("c");
        arrayList1.add("d");
        arrayList1.add("e");

        //迭代器接口-指针-本身不存储任何数据
        Iterator iterator = arrayList1.iterator();
        //遍历
        while (iterator.hasNext())
            System.out.println(iterator.next());

    }

    @Test
    public void test2(){
        Collection arrayList1 = new ArrayList<>();
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("c");
        arrayList1.add("d");
        arrayList1.add("e");

        Iterator iterator = arrayList1.iterator();
        //错误示范一，NoSuch异常，跳数据输出
        while (iterator.next()!= null)
            System.out.println(iterator.next());

    }

    @Test
    public void test3(){
        Collection arrayList1 = new ArrayList<>();
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("c");
        arrayList1.add("d");
        arrayList1.add("e");

        //错误示范二，无线循环
        while (arrayList1.iterator().hasNext())
            System.out.println(arrayList1.iterator().next());

    }
    @Test
    public void test4(){
        Collection arrayList1 = new ArrayList<>();
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("c");
        arrayList1.add("d");
        arrayList1.add("e");

        //remove()
        Iterator iterator1 = arrayList1.iterator();
        while(iterator1.hasNext()){
            Object next = iterator1.next();
            if(next .equals("a") )
                iterator1.remove();
        }
        //遍历
        Iterator iterator2 = arrayList1.iterator();
        while (iterator2.hasNext())
            System.out.println(iterator2.next());
    }
}
