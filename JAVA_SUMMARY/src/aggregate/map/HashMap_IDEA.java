package aggregate.map;

/**
 * @author wanyu
 * @create 2022-02-18 15:24
 *
 * HashMap
 *
 * 底层源码分析：
 *      7.0及之前：数组+链表
 *      8.0：数组+链表+红黑树
 *
 * 7.0：
 * HashMap hasMap = new HashMap();
 * 底层创建了一个长度16的一维数组-->entry[] table；
 *
 * hasMap.put(key,value);
 * 首先调用key的hashCode()计算哈希值(与15)，此哈希值经过某种计算，得到entry数组中存放的位置
 *      如果此位置为空，那么entry(key-value)添加成功<1>
 *      如果此位置不为空，意味着此位置存在一个或多个数据(链表)，比较key和已存在的多个数据的哈希值：
 *          如果key的哈希值都不一样，entry(key-value)添加成功<2>
 *          如果key的哈希值和某一个数据的哈希值相同，继续比较，调用key的equals()进行比较
 *              如果equals()返回false，entry(key-value)添加成功<3>
 *              如果equals()返回true，将value替换相同key的value，put()具有修改替换功能
 *
 * <2><3>:此时entry(key-value)和原来的数据以链表的模式存储
 *
 * 默认的扩容方式：为原来的2倍，并将原来的数据复制过来
 *
 * 8.0：
 * HashMap hasMap = new HashMap();
 * 1.底层并没有创建一个长度16的数组(1<<4)
 * 2.底层数组为Node[],而非Entry[]
 * 3.首次调用put()方法时，底层创建长度16的数组
 * 4.数组+链表-->数组+链表+红黑树
 * 5.当数组的某一个索引位置上的元素以链表形式存在，个数大于8个且当前数组的长度大于64时，
 * 此时索引位置上的所有元素改为红黑树存储
 *
 * 重要常量：
 *      DEFAULT_INITIAL_CAPACITY：HashMap的默认容量，16
 *      MAXIMUM_CAPACITY：HashMap的最大支持容量，2^30
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树
 *      UNTREEIFY_THRESHOLD：Bucket中红黑树存储的Node小于该默认值，转化为链表
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量。（当桶中Node的
 *      数量大到需要变红黑树时，若hash表容量小于MIN_TREEIFY_CAPACITY时，此时应执行
 *      resize扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4倍。）
 *      table：存储元素的数组，总是2的n次幂
 *      entrySet：存储具体元素的集
 *      size：HashMap中存储的键值对的数量
 *      modCount：HashMap扩容和结构改变的次数。
 *      threshold：扩容的临界值，=容量*填充因子
 *      loadFactor：填充因子
 *
 *
 */
public class HashMap_IDEA {
}
