package generic;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author wanyu
 * @createTime 2022-02-20 0:05
 *
 * Generic
 *
 *  泛型：标签
 *  举例：
 *       中药店，每个抽屉外面贴着标签
 *       超市购物架上很多瓶子，每个瓶子装的是什么，有标签
 *  泛型的设计背景
 * 集合容器类在设计阶段/声明阶段不能确定这个容器到底实际存的是什么类型的对象，
 * 所以在JDK1.5之前只能把元素类型设计为Object，JDK1.5之后使用泛型来解决。因为这个时候除了元素的类型不确定，
 * 其他的部分是确定的，例如关于这个元素如何保存，如何管理等是确定的，因此此时把元素的类型设计成一个
 * 参数，这个类型参数叫做泛型。Collection<E>，List<E>，ArrayList<E> 这个<E>就是类型参数，即泛型。
 *
 * 泛型的概念
 *
 *  所谓泛型，就是允许在定义类、接口时通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。
 * 这个类型参数将在使用时（例如，继承或实现这个接口，用这个类型声明变量、创建对象时）确定（即传入实际的类型参数，也称为类型实参）
 *  从JDK1.5以后，Java引入了“参数化类型（Parameterized type）”的概念，允许我们在创建集合时再指定集合元素的类型，
 * 正如：List<String>，这表明该List只能保存字符串类型的对象。
 *  JDK1.5改写了集合框架中的全部接口和类，为这些接口、类增加了泛型支持，从而可以在声明集合变量、创建集合对象时传入类型实参。
 *
 * 那么为什么要有泛型呢，直接Object不是也可以存储数据吗？
 * 1. 解决元素存储的安全性问题，好比商品、药品标签，不会弄错。
 * 2. 解决获取数据元素时，需要类型强制转换的问题，好比不用每回拿商品、药品都要辨别。
 *
 * 自定义泛型结构
 *       自定义泛型类
 *       自定义泛型接口
 *       自定义泛型方法
 *
 *      1.泛型的声明
 *          interface List<T> 和 class GenTest<K,V>
 *          其中，T,K,V不代表值，而是表示类型。这里使用任意字母都可以。
 *          常用T表示，是Type的缩写。
 *      2.泛型的实例化：
 *          一定要在类名后面指定类型参数的值（类型）。如：
 *              List<String> strList = new ArrayList<String>();
 *              Iterator<Customer> iterator = customers.iterator();
 *           T只能是类，不能用基本数据类型填充。但可以使用包装类填充
 *           把一个集合中的内容限制为一个特定的数据类型，这就是generics背后的核心思想
 *
 */
public class Generic_IDEA {
    //在集合中使用泛型
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>();//类型推断
        list.add(78);
        list.add(88);
        list.add(77);
        list.add(66);
        //遍历方式一：
        //for(Integer i : list){
        //不需要强转
        //System.out.println(i);
        //}
        //遍历方式二：
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //在集合中使用泛型
    @Test
    public void test2(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("Tom1",34);
        map.put("Tom2",44);
        map.put("Tom3",33);
        map.put("Tom4",32);
        //添加失败
        //map.put(33, "Tom");
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

}
