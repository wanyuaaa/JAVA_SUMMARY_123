package java8.lambda;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author wanyu
 * @createTime 2022-02-27 4:33
 *
 * 方法引用(Method References)
 *
 *  当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *  方法引用可以看做是Lambda表达式深层次的表达。换句话说，方法引用就是Lambda表达式，也就是函数式接口的一个实例，
 *   通过方法的名字来指向一个方法，可以认为是Lambda表达式的一个语法糖。
 *  要求：实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致！
 *  格式：使用操作符 “::” 将类(或对象) 与 方法名分隔开来。
 *  如下三种主要使用情况：
 *       对象::实例方法名
 *       类::静态方法名
 *       类::实例方法名
 *
 */
public class MethodReferences_IDEA {
    @Test
    public void test1(){
        //对象::实例方法名
        //Consumer中的void accept(T t)
        //PrintStream中的void println(T t)
        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;
        consumer1.accept("北京");
    }

    @Test
    public void test2(){
        //类::静态方法名
        Emp emp = new Emp("wanYu");
        //Supplier<String> supplier = () -> emp.getName();
        Supplier<String> supplier = emp::getName;
        //Comparator<Integer> comparator = (t1,t2) -> Integer.compare(t1,t2);
        Comparator<Integer> comparator = Integer::compare;
        //Function<Double, Long> function = d -> Math.round(d);
        Function<Double, Long> function = Math::round;
    }

    @Test
    public void test3(){
        //类::实例方法名
        //Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
        Comparator<String> comparator = String::compareTo;
        //BiPredicate<String,String> biPredicate = (s1,s2) -> s1.equals(s2);
        BiPredicate<String,String> biPredicate = String::equals;
    }
}

class Emp{
    String name;
    int age;

    public Emp() {}

    public Emp(String name) {
        this.name = name;
    }

    public Emp(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}