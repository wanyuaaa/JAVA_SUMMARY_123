package aggregate.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author wanyu
 * @create 2022-02-18 14:51
 *
 * map
 *
 * |----Map(1.2):存储双列数据，存储key-value对的数据 --类似于高中函数y=f(x);
 *      |----HashMap(1.2):作为map的主要实现类，线程不安全，可以存储null、key、value--健壮性
 *          |----LinkedHashMap(1.4):保证遍历map元素时，按照添加顺序遍历，在原有hashmap上添加一对指针，表明前后元素
 *                                  对于频繁的遍历操作，效率高于hashmap
 *      |----TreeMap(1.2)：保证按照添加的key-value对进行排序，实现排序遍历，只考虑key的自然排序或定制排序，底层红黑树
 *      |----Hashtable(1.0)：古老的实现类，线程安全，不可以存储null、key、value
 *          |----Properties：常用来处理配置文件，key-value都是String类型
 *
 * Map的理解：
 *  Entry:Set，无序的，不可重复的
 *      key：KeySet，无序的，不可重复的-->所在的类需要重写equals()和hashCode()
 *      values：Collection，无序的，可重复的，默认创建一个空的new Object()，并且全部指向这一个obj-->所在的类需要重写equals()
 *          一个键值对构成了一个entry对象
 *
 */
public class Map_IDEA {
    @Test
    public void test1(){
        HashMap<Object, Object> hashMap1 = new HashMap<>();
        Hashtable<Object, Object> hashtable1 = new Hashtable<>();
        hashMap1.put(null,null);
        //hashtable1.put(null,null);

    }
}
