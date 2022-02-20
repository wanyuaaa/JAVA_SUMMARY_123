package generic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author wanyu
 * @createTime 2022-02-20 19:57
 *
 * GenericAndSub
 * 泛型在继承上的体现
 *
 * 类A时类B的父类，G<A>和G<B>二者不具备父子类关系，平级关系
 * 类A时类B的父类，A<G>和B<G>二者时父子类关系
 *
 * 通配符<?>
 *
 * 比如：List<?> ，Map<?,?>
 * 1.List<?>是List<String>、List<Object>等各种泛型List的父类。
 * 2.读取List<?>的对象list中的元素时，永远是安全的，因为不管list的真实类型是什么，它包含的都是Object。
 * 3.写入list中的元素时，不行。因为我们不知道c的元素类型，我们不能向其中添加对象。
 *       唯一的例外是null，它是所有类型的成员。
 *
 *  <?>
 *      允许所有泛型的引用调用
 *  通配符指定上限
 *      上限extends：使用时指定的类型必须是继承某个类，或者实现某个接口，即<=
 *  通配符指定下限
 *      下限super：使用时指定的类型不能小于操作的类，即>=
 *  举例：
 *       <? extends Number> (无穷小 , Number]只允许泛型为Number及Number子类的引用调用
 *       <? super Number> [Number , 无穷大)只允许泛型为Number及Number父类的引用调用
 *       <? extends Comparable>只允许泛型为实现Comparable接口的实现类的引用调用
 *
 *
 */
public class GenericAndSub {
    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时他们不具备子父类关系，编译不通过
        //list1 = list2;

        //反证法
        //假设list1 = list2 内存中指向堆中的同一内存地址
        //list1.add(123)；编译通过，混入导入错误

        show1(list1);
        show2(list2);
    }

    public void show1(List<Object> list){

    }

    public void show2(List<String> list){

    }

    @Test
    public void test2(){
        List<String> list1 = null;
    }

    @Test
    public void test3(){
        List<Object> list1 = Arrays.asList(new String[]{"1", "2", "3"});;
        List<String> list2 = Arrays.asList(new String[]{"1", "2", "3"});;
        //公共父类
        List<?> list = null;
        //添加(写入)：对于List<?>就不能想起添加数据
        //除了添加null，即不能添加对象
        //list.add("DD");
        //list.add(null);

        //获取:允许读取数据，读取的数据
        Object o = list.get(0);

        list = list1;
        list = list2;

        print(list);
        print(list1);
        print(list2);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

}
