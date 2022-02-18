package aggregate.collection.list;

/**
 * @author wanyu
 * @create 2022-02-17 9:49
 *
 * List
 *
 * |----List：有序的、可重复的、自动增容-->动态数组
 *        |----ArrayList(1.2)：主要实现类，第一优先级；线程不安全，效率高；底层通过Object[] elementData存储
 *        |----LinkedList(1.2)：对于频繁的增删操作，此类效率比ArrayList高；底层使用双向链表存储
 *        |----Vector(1.0)：古老实现类，早于list接口,线程安全的(synchronized)，效率低；底层通过Object[] elementData存储
 *
 * 三者异同：
 *      同：三者都实现了List接口，存储特点都相同，都是有序的，可重复的
 *      异：ArrayList：主要实现类，第一优先级；线程不安全，效率高；底层通过Object[] elementData存储
 *         LinkedList：对于频繁的增删操作，此类效率比ArrayList高；底层使用双向链表存储
 *         Vector：古老实现类，早于list接口,线程安全的(synchronized)，效率低；底层通过Object[] elementData存储
 *
 *  鉴于Java中数组用来存储数据的局限性，我们通常使用List替代数组
 *  List集合类中元素有序、且可重复，集合中的每个元素都有其对应的顺序索引。
 *  List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素。
 *  JDK API中List接口的实现类常用的有：ArrayList、LinkedList和Vector。
 *
 */
public class List_IDEA {

}
