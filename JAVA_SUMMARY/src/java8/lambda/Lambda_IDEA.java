package java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author wanyu
 * @createTime 2022-02-26 13:54
 *
 * Lambda
 *
 * 1.举例:(o1,o2)->Integer.compare(o1,o2);
 * 2.格式:
 *      ->:lambda操作符或箭头操作符
 *      ->左边:lambda形参列表,就是借口中的抽象方法的形参列表
 *      ->右边:lambda体,就是重写的抽象方法的方法体
 * 3.使用:6种
 * 4.本质:接口的实例,函数式接口
 *
 * 总结:左边参数列表可以省略,类型都可以省
 *     右边使用大括号包裹,如果只有一条执行语句可以省略括号和return
 *
 * 类型推断:上述 Lambda 表达式中的参数类型都是由编译器推断得出的。Lambda表达式中无需指定类型，程序依然可以编译，
 * 这是因为 javac 根据程序的上下文，在后台推断出了参数的类型。Lambda 表达式的类型依赖于上下文环境，是由编译器推断出来的。
 *
 */
public class Lambda_IDEA {
    @Test
    public void test3(){
        //6种使用
        //1.无参无返回值
        Runnable runnable = () -> System.out.println("1.lambda");
        runnable.run();

        //2.一个参数,没有返回值
        //Consumer<String> consumer = System.out::println;
        Consumer<String> consumer1 = (String s) -> System.out.println(s);
        consumer1.accept("2.lambda");

        //3.数据类型可以省略，可以由编译器推断,称为类型推断
        Consumer<String> consumer2 =  (s) -> System.out.println(s);
        consumer2.accept("3.lambda");

        //4.只有一个参数，小括号可以省略
        Consumer<String> consumer3 = s -> System.out.println(s);
        consumer3.accept("4.lambda");

        //5.Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> comparator1 = (o1,o2)-> {
            System.out.println("5.lambda");
            return Integer.compare(o1, o2);
        };

        //6.当Lambda体只有一条语句时，return与大括号若有，都可以省略
        Comparator<Integer> comparator = (o1,o2)->Integer.compare(o1,o2);

    }

    @Test
    public void test1(){
        new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        }.run();
        System.out.println("-----------------------------------");
        //lambda表达式
        Runnable runnable = () -> System.out.println("lambdaRun");
        runnable.run();
    }

    @Test
    public void test2(){
        int compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        }.compare(12, 21);
        System.out.println(compare);
        System.out.println("-----------------------------------");
        //lambda表达式
        Comparator<Integer> comparator = (o1,o2)->Integer.compare(o1,o2);
        int compare1 = comparator.compare(12, 21);
        System.out.println(compare1);
        System.out.println("-----------------------------------");
        //方法引用写法
        Comparator<Integer> comparator2 = Integer::compare;
        int compare2 = comparator2.compare(12, 21);
        System.out.println(compare2);
    }
}
