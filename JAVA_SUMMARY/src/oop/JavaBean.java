package oop;

import java.io.Serializable;

/**
 * @author wanyu
 * @createTime 2022-02-05 16:07
 *
 * JavaBean是一种Java语言写成的可重用组件。
 *
 * 所谓javaBean，是指符合如下标准的Java类：
 * 类是公共的
 * 有一个无参的公共的构造器
 * 有属性，且有对应的get、set方法
 *
 * 用户可以使用JavaBean将功能、处理、值、数据库访问和其他任何可以
 * 用Java代码创造的对象进行打包，并且其他的开发者可以通过内部的JSP
 * 页面、Servlet、其他JavaBean、applet程序或者应用来使用这些对象。用
 * 户可以认为JavaBean提供了一种随时随地的复制和粘贴的功能，而不用关
 * 心任何改变。
 *
 * 在Java中，this关键字比较难理解，它的作用和其词义很接近。
 *  它在方法内部使用，即这个方法所属对象的引用；
 *  它在构造器内部使用，表示该构造器正在初始化的对象。
 *
 * this 可以调用类的属性、方法和构造器
 *
 * 什么时候使用this关键字呢？
 *  当在方法内需要用到调用该方法的对象时，就用this。
 *
 * 具体的：我们可以用this来区分属性和局部变量。
 * 比如：this.name = name;
 *
 * 可以在类的构造器中使用"this(形参列表)"的方式，调用本类中重载的其他的构造器！
 *  明确：构造器中不能通过"this(形参列表)"的方式调用自身构造器
 *  如果一个类中声明了n个构造器，则最多有 n - 1个构造器中使用了"this(形参列表)"
 *  "this(形参列表)"必须声明在类的构造器的首行！
 *  在类的一个构造器中，最多只能声明一个"this(形参列表)"
 *
 */
public class JavaBean implements Serializable {
    private String name; // 属性一般定义为private
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
