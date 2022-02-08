package Exception;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Scanner;

/**
 * @author wanyu
 * @createTime 2022-02-08 14:32
 *
 * Error：Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源
 * 耗尽等严重情况。比如：StackOverflowError和OOM。一般不编写针对性
 * 的代码进行处理。
 *
 * Exception: 其它因编程错误或偶然的外在因素导致的一般性问题，可以使
 * 用针对性的代码进行处理。例如：
 * 空指针访问
 * 试图读取不存在的文件
 * 网络连接中断
 * 数组角标越界
 *
 *  对于这些错误，一般有两种解决方法：一是遇到错误就终止程序
 * 的运行。另一种方法是由程序员在编写程序时，就考虑到错误的
 * 检测、错误消息的提示，以及错误的处理。
 *  捕获错误最理想的是在编译期间，但有的错误只有在运行时才会发生。
 * 比如：除数为0，数组下标越界等
 *  分类：编译时异常和运行时异常
 *
 * java.lang.Throwable
 *      |----java.lang.Error：一般不编写针对性的代码进行处理
 *      |----java.lang.Exception：可已进行异常处理
 *              |----编译时异常（checked）
 *                      |----IOException
 *                              |----FileNotFoundException
 *                      |----ClassNotFoundException
 *              |----运行时异常（unchecked）
 *                      |----NullPointerException
 *                      |----ArrayIndexOutOfBoundsException
 *                      |----ClassCastException
 *                      |----NumberFormatException
 *                      |----InputMismatchException
 *                      |----ArithmeticException
 *
 */
public class Exception_S {
    public static void main(String[] args) {
        //1. 栈溢出
        //main(args);

        //2.堆溢出OOM
        //Integer[] integers = new Integer[1024 * 1024 * 1024];
    }

    //1.NullPointerException
    @Test
    public void test1(){
        String str ="abc";
        str = null;
        System.out.println(str.charAt(0));
    }

    //2.ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
        int[] ints = new int[10];
        System.out.println(ints[10]);
    }

    //3.ClassCastException
    @Test
    public void test3(){
        Object obj =  new Date();
        String str = (String)obj;
        System.out.println(str);
    }

    //4.NumberFormatException
    @Test
    public void test4(){
        String str = "abc";
        System.out.println(Integer.valueOf(str));
    }

    //5.InputMismatchException
    @Test
    public void test5(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);
    }

    //6.ArithmeticException
    @Test
    public void test6(){
        int a = 10;
        int b = 0;
        System.out.println(a/b);
    }
}
