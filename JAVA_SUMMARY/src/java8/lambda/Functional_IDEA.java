package java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author wanyu
 * @createTime 2022-02-26 21:49
 * <p>
 * 函数式(Functional)接口
 * <p>
 *  只包含一个抽象方法的接口，称为函数式接口。
 *  你可以通过 Lambda 表达式来创建该接口的对象。（若 Lambda 表达式抛出一个受检异常(即：非运行时异常)，
 * 那么该异常需要在目标接口的抽象方法上进行声明）。
 *  我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口。
 * 同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。
 *  在java.util.function包下定义了Java 8 的丰富的函数式接口
 * <p>
 * 如何理解函数式接口
 * <p>
 *  Java从诞生日起就是一直倡导“一切皆对象”，在Java里面面向对象(OOP)编程是一切。但是随着python、scala等语言的兴起
 * 和新技术的挑战，Java不得不做出调整以便支持更加广泛的技术要求，也即java不但可以支持OOP还可以支持OOF（面向函数编程）
 *  在函数式编程语言当中，函数被当做一等公民对待。在将函数作为一等公民的编程语言中，Lambda表达式的类型是函数。
 * 但是在Java8中，有所不同。在Java8中，Lambda表达式是对象，而不是函数，它们必须依附于一类特别的对象类型——函数式接口。
 *  简单的说，在Java8中，Lambda表达式就是一个函数式接口的实例。这就是Lambda表达式和函数式接口的关系。
 * 也就是说，只要一个对象是函数式接口的实例，那么该对象就可以用Lambda表达式来表示。
 *  所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 * <p>
 * 四大核心函数式接口
 * <p>
 * 函数式接口            参数类型    返回类型   包含方法              用途
 * Consumer<T>              T       void     void accept(T t)     对类型为T的对象应用操作
 * 消费型接口
 * Supplier<T>              无       T       T get()              返回类型为T的对象，
 * 供给型接口
 * Function<T, R>           T        R       R apply(T t)         对类型为T的对象应用操作，并返回结果。结果是R类型的对象。
 * 函数型接口
 * Predicate<T>             T      boolean   boolean test(T t)    确定类型为T的对象是否满足某约束，并返回
 * 断定型接口
 * BiFunction<T, U, R>    T, U       R       R apply(T t, U u)    对类型为 T, U 参数应用操作，返回 R 类型的结果。
 * UnaryOperator<T>         T        T       T apply(T t)         对类型为T的对象进行一元运算，并返回T类型的
 * (Function子接口)
 * BinaryOperator<T>      T,T        T       T apply(T t1, T t2)  对类型为T的对象进行二元运算，并返回T类型的结果。
 * (BiFunction 子接口)
 * BiConsumer<T, U>       T,U       void    void accept(T t, U u) 对类型为T, U 参数应用操作。
 * BiPredicate<T,U>       T,U     boolean   boolean test(T t,U u)
 * ToIntFunction<T>                 int
 * ToLongFunction<T>        T       long                          分别计算int、long、double值的函数
 * ToDoubleFunction<T>             double
 * IntFunction<R>         int
 * LongFunction<R>        long       R                            参数分别为int、long、double 类型的函数
 * DoubleFunction<R>     double
 *
 */
public class Functional_IDEA {
    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("con1"+aDouble);
            }
        });
        //Consumer
        happyTime(400,money-> System.out.println("con1"+money));

        //Predicate
        List<String> strings = Arrays.asList("a","ab","ac","dd");
        List<String> a = filterString(strings, s -> s.contains("a"));
        System.out.println(a);
    }

    public List<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList<String> strings = new ArrayList<>();

        for (String str : list ){
            if(predicate.test(str)){
                strings.add(str);
            };
        }
        return strings;
    }

    public void happyTime(double money,Consumer<Double> con){
        con.accept(money);
    }
}
