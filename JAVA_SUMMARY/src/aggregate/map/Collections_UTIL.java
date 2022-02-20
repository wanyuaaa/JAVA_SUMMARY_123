package aggregate.map;

import java.util.Arrays;
import java.util.List;

/**
 * @author wanyu
 * @createTime 2022-02-19 21:49
 *
 * Collections
 *
 * Collections 是一个操作 Set、List 和 Map 等集合的工具类
 * Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作，
 * 还提供了对集合对象设置不可变、对集合对象实现同步控制等方法
 * 排序操作：（均为static方法）
 *      reverse(List)：反转 List 中元素的顺序
 *      shuffle(List)：对 List 集合元素进行随机排序
 *      sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 *      sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 *      swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 * 查找、替换
 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 * Object min(Collection)
 * Object min(Collection，Comparator)
 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * void copy(List dest,List src)：将src中的内容复制到dest中，必须指定长度
 * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
 *
 * 同步控制
 * Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，
 * 从而可以解决多线程并发访问集合时的线程安全问题
 * Enumeration 接口是 Iterator 迭代器的 “古老版本”
 *
 *
 */
public class Collections_UTIL {
    public static void main(String[] args) {
        List list = Arrays.asList(new Object[12]);
    }
}
