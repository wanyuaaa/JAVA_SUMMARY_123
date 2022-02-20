package aggregate.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author wanyu
 * @createTime 2022-02-19 16:25
 *
 * LinkedHashMap
 *
 * 重写了new Node()
 *      Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
 *         return new Node<>(hash, key, value, next);
 *     }
 *
 * LinkedHashMap 是 HashMap 的子类
 * 在HashMap存储结构的基础上，使用了一对双向链表来记录添加元素的顺序
 * 与LinkedHashSet类似，LinkedHashMap 可以维护 Map 的迭代
 *      顺序：迭代顺序与 Key-Value 对的插入顺序一致
 *
 * static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;//记录添加顺序
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 */
public class LinkedHashMap_IDEA {
    @Test
    public void test1(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();


    }
}
