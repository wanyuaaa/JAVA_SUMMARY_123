package java8.stream;

import java8.stream.utilClass.Employee;
import java8.stream.utilClass.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author wanyu
 * @createTime 2022-02-27 15:19
 */
public class StreamAPI_API1 {
    @Test
    public void test1(){
        //创建 Stream方式一：通过集合
        //Java8 中的 Collection 接口被扩展，提供了两个获取流的方法：
        List<Employee> employees = EmployeeData.getEmployees();

        //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();
        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    @Test
    public void test2(){
        //创建 Stream方式二：通过数组
        //Java8 中的 Arrays 的静态方法 stream() 可以获取数组流：
        //static <T> Stream<T> stream(T[] array): 返回一个流
        //重载形式，能够处理对应基本类型的数组：
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,0};
        //public static IntStream stream(int[] array)
        //public static LongStream stream(long[] array)
        //public static DoubleStream stream(double[] array)
        IntStream stream = Arrays.stream(arr);
    }

    @Test
    public void test3(){
        //创建 Stream方式三：通过Stream的of()
        //可以调用Stream类静态方法 of(), 通过显示值创建一个流。它可以接收任意数量的参数。
        //public static<T> Stream<T> of(T... values) : 返回一个流
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    }

    @Test
    public void test4(){
        //创建 Stream方式四：创建无限流
        //可以使用静态方法 Stream.iterate() 和 Stream.generate(),创建无限流。
        //迭代:public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0,t ->t+2).limit(10).forEach(System.out::println);
        //生成:public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
