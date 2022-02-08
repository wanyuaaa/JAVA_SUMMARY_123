package oop;

import java.awt.*;

/**
 * @author wanyu
 * @createTime 2022-02-06 19:05
 *
 * 包装类
 *
 *  针对八种基本数据类型定义相应的引用类型—包装类（封装类）
 *  有了类的特点，就可以调用类中的方法，Java才是真正的面向对象
 *
 * 基本数据类型    包装类
 * byte           Byte
 * short          Short
 * int            Integer
 * long           Long
 * float          Float
 * double         Double        ⬆父类Number
 * boolean        Boolean
 * char           Character
 *
 * 基本数据类型-包装类-String转换
 *
 *
 *
 */
public class Wrapper {
    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper();
        wrapper.Wrapper1();
        wrapper.Wrapper2();
        wrapper.method1();
    }

    public void method1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//

        //Integer内部定义了IntegerCache结构，其中定义了Integer[],
        //保存了-128~127的整数，如果我们使用自动装箱的方式，给Integer赋值的范围在其内，
        //可以直接使用数组中的值，不会重新new
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//
    }


    //基本/包装类--->String
    public void Wrapper3(){
        int i1 = 10;
        String str1 = i1 + "";
        Integer i2 = Integer.getInteger(str1);
        int integer = Integer.valueOf("str1");

        float f1 = 12.3f;
        String str2 = String.valueOf(f1);
        Float f2 = Float.valueOf(str2);


    }

    //包装类--->基本
    public void Wrapper2(){
        Integer num1 = new Integer(10);
        int i = num1.intValue();
        System.out.println(i);

        Float num2 = new Float(10f);
        float f = num2.floatValue();
        System.out.println(f);
    }

    //基本--->包装类
    public void Wrapper1(){
        Integer num1 = new Integer(10);
        System.out.println(num1.toString());

        Float num2 = new Float(10f);
        System.out.println(num2.toString());




    }
}
