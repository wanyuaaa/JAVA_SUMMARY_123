package oop;

/**
 * @author wanyu
 * @createTime 2022-02-04 14:15
 * <p>
 * 万事万物皆对象
 * 强类型语言
 * <p>
 * 三条主线
 * 1.java类及类的成员：属性/方法/构造器；代码块/内部类
 * 2.三大特征：封装性/继承性/多态性/抽象性
 * 3.其他关键字：this/super/static/final/abstract/interface/package/import
 * <p>
 * 局部变量和成员变量
 * 定义的位置不一样【重点】：
 * 局部变量：在方法的内部
 * 成员变量：在方法的外部，直接写在类当中
 * 作用范围不一样【重点】：
 * 局部变量：只有方法当中才可以使用，出了方法就不能再用了
 * 成员变量：整个类都可以通用
 * 默认值不一样【重点】：
 * 局部变量：没有默认值，如果要想使用，必须手动进行赋值
 * 成员变量：如果没有赋值，会有默认值，规则和数组一样
 * 4.内存的位置不一样（了解）：
 * 局部变量：位于栈内存
 * 成员变量：位于堆内存
 * 5.生命周期不一样（了解）：
 * 局部变量：随着方法进栈而诞生，随着方法出栈而消失
 * 成员变量：随着对象的创建而诞生，随着对象被垃而消失
 */
public class Oop {
    public static void main(String[] args) {
        Man man = new Man();
        man.a = 10;
        String str = "abc";

        Oop oop = new Oop();
        oop.data(man,str);

        System.out.println(man.a);
        System.out.println(str);
        //String 比较特殊，存储在方法区的常量池中，底层为char[] 不可修改，进行赋值操作会新建char[]，赋予新地址值，不会影响原String
        
    }

    public void data(Man man,String str) {
        man.a = 1;
        str = "abcd";
    }
}

class Man {
    int a;
}