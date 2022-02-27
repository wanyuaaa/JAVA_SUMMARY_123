package java8.stream;

import java8.stream.utilClass.Employee;
import java8.stream.utilClass.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wanyu
 * @createTime 2022-02-27 16:57
 *
 * Stream 的终止操作
 *
 *  终端操作会从流的流水线生成结果。其结果可以是任何不是流的值，例如：List、Integer，甚至是 void 。
 *  流进行了终止操作后，不能再次使用。
 *
 */
public class StreamAPI_API3 {
    @Test
    public void test1(){
        //1.匹配与查找
        List<Employee> employees = EmployeeData.getEmployees();
        //allMatch(Predicate p) 检查是否匹配所有元素
        boolean b1 = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b1);
        System.out.println("-----------------------------------------------");
        //anyMatch(Predicate p) 检查是否至少匹配一个元素
        boolean b2 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b2);
        System.out.println("-----------------------------------------------");
        //noneMatch(Predicate p) 检查是否没有匹配所有元素
        boolean b3 = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(b3);
        System.out.println("-----------------------------------------------");
        //findFirst() 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        System.out.println("-----------------------------------------------");
        //findAny() 返回当前流中的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
        System.out.println("-----------------------------------------------");
        //count() 返回流中元素总数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        System.out.println("-----------------------------------------------");
        //max(Comparator c) 返回流中最大值
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        System.out.println(doubleStream.max(Double::compare));
        System.out.println("-----------------------------------------------");
        //min(Comparator c) 返回流中最小值
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        System.out.println("-----------------------------------------------");
        //forEach(Consumer c)内部迭代(使用Collection接口需要用户去做迭代,称为外部迭代。相反，Stream API使用内部迭代
        employees.stream().forEach(System.out::println);
    }

    @Test
    public void test2(){
        //2.归约
        //备注：map和reduce的连接通常称为map-reduce模式，因Google用它来进行网络搜索而出名。
        //reduce(T identity, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回T
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        System.out.println("-----------------------------------------------");
        //reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        System.out.println(reduce1);
    }

    @Test
    public void test3(){
        //3.收集
        //collect(Collector c)将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        //Collector 接口中方法的实现决定了如何对流执行收集的操作(如收集到List、Set、Map)。
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("-----------------------------------------------");
        Set<Employee> collect2 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        System.out.println(collect2);
    }
}
