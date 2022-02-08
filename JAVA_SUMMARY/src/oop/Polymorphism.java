package oop;

/**
 * @author wanyu
 * @createTime 2022-02-06 13:56
 * <p>
 * 多态性
 * <p>
 * 多态性，是面向对象中最重要的概念，在Java中的体现：
 * 对象的多态性：父类的引用指向子类的对象,可以直接应用在抽象类和接口上
 * <p>
 * Java引用变量有两个类型：编译时类型和运行时类型。编译时类型由声明该变量时使用的类型决定，运行时类型由实际赋给该变量的对象决定。
 * 简称：编译时，看左边；运行时，看右边。
 * 若编译时类型和运行时类型不一致，就出现了对象的多态性(Polymorphism)
 * “看左边”：看的是父类的引用（父类中不具备子类特有的方法）
 * “看右边”：看的是子类的对象（实际运行的是子类重写父类的方法）
 *
 * !只适用于方法，不适应属性
 *
 * 前提：1.类的继承；2.方法的重写
 *
 * 多态是运行时行为
 *
 * 多态作用：
 *  提高了代码的通用性，常称作接口重用
 * 前提：
 *  需要存在继承或者实现关系
 *  有方法的重写
 * 成员方法：
 *  编译时：要查看引用变量所声明的类中是否有所调用的方法。
 *  运行时：调用实际new的对象所属的类中的重写方法。
 * 成员变量：
 *  不具备多态性，只看引用变量所声明的类。
 *
 */
public class Polymorphism {
    public static void main(String[] args) {
        Person_Polymorphism person = new Person_Polymorphism();

        //多态性，父类引用指向子类的对象
        Person_Polymorphism person1 = new Man_Polymorphism();
        Person_Polymorphism person2 = new Woman__Polymorphism();

        //多态的使用，当调用子父类同名同参的方法时，实际执行的子类重写的父类的方法----虚拟方法调用
        person1.walk();
        person2.walk();
        //不能调父类中没有的方法
        //Cannot resolve method 'goShopping' in 'Person_Polymorphism'
        //person2.goShopping();

        //多态的意义
        Polymorphism p = new Polymorphism();
        p.person_walk(person1);
        p.person_walk(person2);

        System.out.println(person1.getClass());
        System.out.println(person2.getClass());
        System.out.println(person1.getClass() == person2.getClass());

    }

    public void person_walk(Person_Polymorphism person){
        System.out.println(person.ID);
        person.walk();
    }
}

class Person_Polymorphism {
    String name;
    int age;
    String ID = "1000";

    public Person_Polymorphism() {
    }

    public Person_Polymorphism(String name) {
        this();
        this.name = name;
    }

    public Person_Polymorphism(String name, int age) {
        this(name);
        this.age = age;
    }

    public Person_Polymorphism(String name, int age, String ID) {
        this(name, age);
        this.ID = ID;
    }

    public void walk() {
        System.out.println("走路");
    }
}

class Man_Polymorphism extends Person_Polymorphism {
    String ID = "1001";
    boolean isSmoking;

    @Override
    public void walk() {
        System.out.println("男人走路");
    }
}

class Woman__Polymorphism extends Person_Polymorphism {
    boolean isBeauty;
    String ID = "1002";

    @Override
    public void walk() {
        System.out.println("女人走路");
    }

    public void goShopping() {
        System.out.println("女人购物");
    }
}