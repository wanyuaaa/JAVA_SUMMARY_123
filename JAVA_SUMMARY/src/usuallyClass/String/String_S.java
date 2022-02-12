package usuallyClass.String;

import org.junit.jupiter.api.Test;

/**
 * @author wanyu
 * @createTime 2022-02-11 20:19
 *
 * 字符串相关的类：String
 *
 * String的特性:
 *       String类：代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现
 *       String是一个final类，代表不可变的字符序列
 *          1.当给字符串重新赋值时，需要重写指定的内存区域赋值，不能使用原有的value进行赋值
 *          2.当对现有的字符串进行拼接时会新建内存区域赋值，不影响原有对象
 *          3.当调用String的replace()修改字符串时，也必须重新指定内存区域，不能在原有上修改
 *       字符串是常量，用双引号引起来表示。它们的值在创建之后不能更改
 *       String实现了Serializable接口：表示字符串是支持序列化的
 *       String实现了Comparable接口：可以比较大小
 *       String内部定义了final char[] value用于存储字符串数据
 *       同名字面量的方式给一个字符串赋值，此时字符串声明在常量池中
 *       字符串常量池中是不会存储相同的字符串的
 *
 * String s = new String("abc");方式创建对象，在内存中创建两个对象：
 * 一个堆空间的new()对象，另一个是char[]对应的常量池数据
 *
 */
public class String_S {

    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        String_S ex = new String_S();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str+"and");//good
        System.out.println(ex.ch);//best
    }


    @Test
    public void stringTest1(){
        String s1 ="abc";
        String s2 ="abc";
        //s1 = "hello";

        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void stringTest2(){
        /*String对象的创建*/
        //1.都在字符串常量池中
        String s1 = "abc";
        String s2 = "abc";

        //2.都在对空间中开辟空间
        String s3 = new String("abc");
        String s4 = new String("abc");

        String s6 = s3;
        s3 = s3 + "abc";
        System.out.println(s3==s6);

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false

        String s5 = s3;
        System.out.println(s3 == s5);
        s3 = "bcd";
        System.out.println(s3 == s5);//false
    }

    @Test
    public void stringTest3(){
        /*
            结论：
                 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
                 只要其中有一个是变量，结果就在堆中
                 如果拼接的结果调用intern()方法，返回值就在常量池中
         */
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello"+"world";
        String s7 = "helloworld";
        String s4 = s1+"world";
        String s5 = s1+s2;
        String s6 = (s1+s2).intern();//返回值得到的常量值存储在方法区

        System.out.println(s3 == s4);//false
        System.out.println(s3 == s7);//true
        System.out.println(s3 == s5);//false
        System.out.println(s4 == s5);//false
        System.out.println(s3 == s6);//true
    }

    @Test
    public void stringTest4(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        System.out.println(sb);//''
        sb.append(str);
        System.out.println(sb.length());//4
        System.out.println(sb);//null
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//Cannot invoke "String.length()" because "str" is null
    }
}
