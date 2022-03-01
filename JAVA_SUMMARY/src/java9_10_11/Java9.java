package java9_10_11;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author wanyu
 * @createTime 2022-02-28 23:04
 *
 *  模块化系统
 *  jShell命令
 *  多版本兼容jar包
 *  接口的私有方法
 *  钻石操作符的使用升级
 *  语法改进：try语句
 *  String存储结构变更
 *  便利的集合特性：of()
 *  增强的Stream API
 *  全新的HTTP客户端API
 *  Deprecated的相关API
 *  javadoc的HTML 5支持
 *  Javascript引擎升级：Nashorn
 *  java的动态编译器
 *
 */
public class Java9 {
    public static void main(String[] args) {
        String str = "123";
    }

    //增强的Stream API
    @Test
    public void test5(){
        //takeWhile()的使用
        //用于从 Stream 中获取一部分数据，接收一个 Predicate 来进行选择。在有序的
        //Stream 中，takeWhile 返回从开头开始的尽量多的元素。
        List<Integer> list = Arrays.asList(45, 43, 76, 87, 42, 77, 90, 73, 67, 88);
        list.stream().takeWhile(x -> x < 50).forEach(System.out::println);
        System.out.println();
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        list.stream().takeWhile(x -> x < 5).forEach(System.out::println);
        System.out.println("---------------------------------------");
        //dropWhile()的使用
        //dropWhile 的行为与 takeWhile 相反，返回剩余的元素。
        list.stream().dropWhile(x -> x < 50).forEach(System.out::println);
        System.out.println();
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        list.stream().dropWhile(x -> x < 5).forEach(System.out::println);
        System.out.println("---------------------------------------");
        //ofNullable()的使用
        //Java 8 中 Stream 不能完全为null，否则会报空指针异常。而 Java 9 中的 ofNullable 方
        //法允许我们创建一个单元素 Stream，可以包含一个非空元素，也可以创建一个空Stream。
        Stream<String> stringStream = Stream.of("AA", "BB", null);
        System.out.println(stringStream.count());// 3
        // 不报异常，允许通过
        List<String> list1 = new ArrayList<>();
        list1.add("AA");
        list1.add(null);
        System.out.println((long) list1.size());// 2
        // ofNullable()：允许值为null
        Stream<Object> stream1 = Stream.ofNullable(null);
        System.out.println(stream1.count());// 0
        Stream<String> stream = Stream.ofNullable("hello world");
        System.out.println(stream.count());// 1
        System.out.println("---------------------------------------");
        //iterate()重载的使用
        //这个 iterate 方法的新重载方法，可以让你提供一个 Predicate (判断条件)来指定什么时候结束迭代。
        // 原来的控制终止方式：
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);
        // 现在的终止方式：
        Stream.iterate(1, i -> i < 100, i -> i + 1).forEach(System.out::println);
    }

    @Test
    public void test4(){
        ClassLoader cl = this.getClass().getClassLoader();
        try (InputStream is = cl.getResourceAsStream("hello.txt");
             OutputStream os = new FileOutputStream("src\\hello1.txt")) {
            is.transferTo(os); // 把输入流中的所有数据直接自动地复制到输出流中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        List<String> list = List.of("a", "b", "c");
        Set<String> set = Set.of("a", "b", "c");
        Map<String, Integer> map1 = Map.of("Tom", 12, "Jerry", 21, "Lilei", 33,
                "HanMeimei", 18);
        Map<String, Integer> map2 = Map.ofEntries(Map.entry("Tom", 89),
                Map.entry("Jim", 78), Map.entry("Tim", 98));

    }

    @Test
    public void test2(){
        List<String> list = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a",
                "b", "c")));
        // 如下操作不适用于jdk 8 及之前版本,适用于jdk 9
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {
            @Serial
            private static final long serialVersionUID = -954396041131915645L;
            {
                put("a", 1);
                put("b", 2);
                put("c", 3);
            }
        });
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    public void test1(){
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try (reader; writer) {
        //reader是final的，不可再被赋值
        //reader = null;
        //具体读写操作省略
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
