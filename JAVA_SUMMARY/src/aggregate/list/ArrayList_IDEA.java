package aggregate.list;

/**
 * @author wanyu
 * @create 2022-02-17 10:36
 *
 * ArrayList
 *
 * 源码分析：
 * 7.0
 *     1.ArrayList = new ArrayList();底层新建长度为 10 的Object[] elementData；
 *     2.add(e),扩容为1.5倍、拿添加值作为添加长度、MAX_ARRAY_SIZE--抛异常Error;Arrays.copyOf(elementData, newCapacity);
 * 结论：
 *     避免使用空参构造器，避免扩容
 *
 * 变化：
 * 8.0
 *     1.ArrayList = new ArrayList();底层新建长度为DEFAULTCAPACITY_EMPTY_ELEMENTDATA的{}，长读为0
 *     2.add(e),添加时初始化数组长度为10，并将数据添加到数组中
 *
 * 小结：7.0类似于单例的饿汉式，8.0类似于懒汉式，延迟了数组的创建，节省内存
 *
 */
class ArrayList_IDEA {
}
