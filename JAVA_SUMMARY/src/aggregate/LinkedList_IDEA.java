package aggregate;

/**
 * @author wanyu
 * @create 2022-02-17 11:12
 *
 * LinkedList
 *      --双向链表528.6
 *
 * 源码分析：
 *      LinkedList list = new LinkedList();
 *
 *
 *
 *     内部声明了Node类型的first和last的属性默认值为null
 *     list.add(123),将123封装到node中，创建了node对象
 *
 *     其中node定义为：
 *     private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *     体现了LinkedList双向链表
 *
 */
public class LinkedList_IDEA {
}
