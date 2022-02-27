package java8.stream;

import java8.stream.utilClass.Employee;
import java8.stream.utilClass.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wanyu
 * @createTime 2022-02-27 15:51
 *
 * Stream 的中间操作
 *
 * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！
 * 而在终止操作时一次性全部处理，称为“惰性求值”。
 *
 */
public class StreamAPI_API2 {
    @Test
    public void test1(){
        //1.筛选与切片
        List<Employee> employees = EmployeeData.getEmployees();
        //filter(Predicate p)接收 Lambda,从流中排除某些元素
        Stream<Employee> stream = employees.stream();
        stream.filter(e -> e.getSalary()>7000).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        //limit(long maxSize)截断流，使其元素不超过给定数量
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        //skip(long n)跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
        employees.stream().skip(3).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        //distinct()筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        employees.add(new Employee(1010,"刘强东",39,8000));
        employees.add(new Employee(1010,"刘强东",39,8000));
        employees.add(new Employee(1010,"刘强东",39,8000));
        employees.add(new Employee(1010,"刘强东",39,8000));
        employees.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test2(){
        //2.映射
        //map(Function f)接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        strings.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().filter(e -> e.getName().length()>3).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        //mapToDouble(ToDoubleFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
        //mapToInt(ToIntFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
        //mapToLong(ToLongFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。
        //flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
    }

    @Test
    public void test3(){
        //3.排序
        //sorted() 产生一个新流，其中按自然顺序排序
        List<Integer> integers = Arrays.asList(13, 45, 22, 64, 47, 41, 22, 17);
        integers.stream().sorted().forEach(System.out::println);
        System.out.println("-------------------------------------------");
        //sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        integers.stream().sorted((i1,i2) -> -i1.compareTo(i2)).forEach(System.out::println);
    }
}
