package java9_10_11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanyu
 * @createTime 2022-03-01 1:30
 */
public class Java10 {
    @Test
    public void test1(){
        //局部变量类型推断
        //在局部变量中使用时，如下情况不适用：
        // 情况1：没有初始化的局部变量声明
        // 情况2：方法的返回类型
        // 情况3：方法的参数类型
        // 情况4：构造器的参数类型
        // 情况5：属性
        // 情况6：catch块
        var num = 10;
        //1.局部变量的初始化
        var list = new ArrayList<>();
        //2.增强for循环中的索引
        for(var v : list)
            System.out.println(v);
        //3.传统for循环中
        for(var i = 0;i < 100;i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test2(){
        //示例1：
        var list1 = List.of("Java", "Python", "C");
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1); // true
        //示例2：
        var list2 = new ArrayList<String>();
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2); // false
        //示例1和2代码基本一致，为什么一个为true,一个为false?
        //从 源 码 分 析 ， 可 以 看 出 copyOf 方 法 会 先 判 断 来 源 集 合 是 不 是
        //AbstractImmutableList 类型的，如果是，就直接返回，如果不是，则调用 of 创建一个新的集合。
        //示例2因为用的 new 创建的集合，不属于不可变 AbstractImmutableList 类的子类，
        //所以 copyOf 方法又创建了一个新的实例，所以为false。
        //注意：使用of和copyOf创建的集合为不可变集合，不能进行添加、删除、替换、
        //排序等操作，不然会报 java.lang.UnsupportedOperationException 异常。
        //上面演示了 List 的 of 和 copyOf 方法，Set 和 Map 接口都有。
    }
}
