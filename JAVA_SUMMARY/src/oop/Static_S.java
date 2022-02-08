package oop;

/**
 * @author wanyu
 * @createTime 2022-02-06 22:10
 *
 * static
 *
 * 1.static静态的
 * 2.static可以修饰：属性，方法，代码块，内部类
 * 3.使用static修饰属性
 *      静态属性/非静态属性（实例变量）
 *      多个对象同享一个静态变量，一改俱改
 *      静态变量随着类的加载而加载
 *      静态变量早于对象的创建
 *      静态变量只加载一次，在内存中只存在一份-->方法区的静态域中
 *      使用举例：Math.PI;System.out
 * 4.使用static修饰方法
 *      随着类的创建而创建，可以被类.方法调用
 *      静态方法中可以调用静态方法/属性
 *      非静态方法可以调用静态方法/属性和非静态方法/属性
 * 5.static注意点：
 *      在静态方法中不能使用super()和this()
 *      方法区和缓存
 * 6.static的使用场景
 *      属性：不随对象变化而变化的，共享的，常量
 *      方法：静态属性的get()/set()...操作方法
 *
 */
public class Static_S {}

class Static_s{

    int age = 10;
    static int leg = 10;

    public void run(){
        int age = this.age;
        int leg = Static_s.leg;
        this.run1();
        Static_s.run2();
    }

    public void run1(){
        System.out.println("1");
    }

    public static void run2(){
        System.out.println("2");
    }
}
