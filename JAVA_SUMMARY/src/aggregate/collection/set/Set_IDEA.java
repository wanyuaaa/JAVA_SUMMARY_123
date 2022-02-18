package aggregate.collection.set;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author wanyu
 * @create 2022-02-17 13:23
 *
 * |----Collection：单列集合，存储一个一个的对象
 *      |----Set：无序的，不可重复的-->数学集合
 *          |----HashSet:作为set的主要实现类，线程不安全的，可以存储null值
 *              |----LinkedHashSet:添加双向链表，使得遍历内部数据可以按照添加顺序遍历
 *          |----TreeSet:红黑树，可以按照添加对象的指定属性排序
 *
 * 无序的:并非随机性，并非按照数组索引而添加数据，而是根据数据的哈希值添加
 * 不可重复的：保证添加的元素通过equals()不能返回true，即相同元素只能添加一个
 *
 * 添加元素的过程：
 *      向HashSet中添加元素a，首先调用a的hashCode()，计算a的哈希值，此哈希值通过某种算法计算出在hashSet底层数组中
 *      存放位置，即索引位置，判断数组此位之上是否有元素：
 *          如果此位置没有元素：直接添加到数组上，添加成功<1>
 *          如果此位置有其他元素b(或以链表形式存在的多个元素)：首先比较a与b的哈希值
 *              如果哈希值不相同，则元素a添加成功<2>
 *              如果哈希值相同，进而需要调用元素a的equals()：
 *                  equals()返回true：添加不成功
 *                  equals()返回false：添加成功<3>
 *
 * 对于添加成功的<2>、<3>已经存在于索引位置上的数据以链表的方式存储
 *      7.0将新添加元素放入数组中，指向原来的元素
 *      8.0原来的元素在数组中，指向新添加的元素
 *
 * hashSet底层是数组+链表的结构
 *
 * 要求：向Set中添加数据，其所在类一定要重写hasCode()和equals()
 *      重写的hasCode()和equals()尽可能的具有一致性(相等的对象尽可能的拥有相同的散列码)
 *
 */
public class Set_IDEA {
    @Test
    public void test1(){
        Set<Object> set1 = new HashSet<>();
        set1.add(11);
        set1.add(22);
        set1.add("aa");
        set1.add("bb");
        set1.add(332);
        System.out.println(set1);

        //LinkedHashSet在添加的过程中，每个数据还维护了两个变量，记录前一个和后一个数据
        //优点：提高了遍历效率
        Set<Object> set2 = new LinkedHashSet<>();
        set2.add(11);
        set2.add(22);
        set2.add("aa");
        set2.add("bb");
        set2.add(332);
        System.out.println(set2);

    }
}
