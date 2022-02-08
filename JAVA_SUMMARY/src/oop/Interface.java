package oop;

/**
 * @author wanyu
 * @createTime 2022-02-07 20:16
 * <p>
 * 接口
 * interface
 *
 * 接口和类是两个并列的结构
 * 可以定义全局常量和抽象方法
 *
 * 不可定义构造器，不可实例化
 * 实现类implements实现接口，重写接口内所有的抽象方法
 *
 * 可以实现多个接口，弥补了继承的单一局限性
 * Class AA extends BB implements CC,DD,EE
 *
 * 接口也可以继承其它接口
 * 接口的具体使用，体现多态性
 * 接口可以看作一种规范
 *
 * 抽象类和接口有哪些异同
 *
 * 接口的主要用途就是被实现类实现。（面向接口编程）
 *
 * 接口中的所有成员变量都默认是由public static final修饰的。
 * 接口中的所有抽象方法都默认是由public abstract修饰的。
 * 静态方法：只能通过接口.方法调用
 * 默认方法：可以通过实现类对象，调用默认方法
 *
 *  若一个接口中定义了一个默认方法，而另外一个接口中也定义了一个同名同
 * 参数的方法（不管此方法是否是默认方法），在实现类同时实现了这两个接
 * 口时，会出现：接口冲突。
 *  解决办法：实现类必须覆盖接口中同名同参数的方法，来解决冲突。
 *
 *  若一个接口中定义了一个默认方法，而父类中也定义了一个同名同参数的非
 * 抽象方法，则不会出现冲突问题。因为此时遵守：类优先原则。接口中具有
 * 相同名称和参数的默认方法会被忽略。
 *
 * 父类和接口同级，类优先原则
 *
 */
public class Interface {
    public static void main(String[] args) {
        int maxSpeed = Flyable.MAX_SPEED;
        int minSpeed = Flyable.MIN_SPEED;
        //Flyable++;

        Interface anInterface = new Interface();
        Plane plane = new Plane();
        anInterface.run(plane);
        Bullet bullet = new Bullet();
        anInterface.run(bullet);
        anInterface.attack(bullet);

        plane.method1();
        Flyable.method();
    }

    public void run(Flyable flyable){
        flyable.run();
        flyable.fly();
    }

    public void attack(Attackable attackable){
        attackable.attack();
    }
}

interface Flyable {
    //全局常量
    public final static int MAX_SPEED = 7900;//第一宇宙速度
    int MIN_SPEED = 1;//省略了public final static

    //抽象方法
    public abstract void fly();
    void run();

    //静态方法--只能通过接口调用
    public static void method(){
        System.out.println("method");
    }

    //默认方法
    public default void method1(){
        System.out.println("method1");
    }
}

interface Attackable{
    void attack();
}

class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("Plane-fly");
    }

    @Override
    public void run() {
        System.out.println("Plane-run");
    }

    public void help(){
        Flyable.super.method1();
    }
}

class Bullet implements Flyable,Attackable{

    @Override
    public void fly() {
        System.out.println("Bullet-fly");
    }

    @Override
    public void run() {
        System.out.println("Bullet-run");
    }

    @Override
    public void attack() {
        System.out.println("Bullet-attack");
    }
}

