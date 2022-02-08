package oop;

/**
 * @author wanyu
 * @createTime 2022-02-07 18:01
 *
 * abstract
 *
 * 1.abstract抽象的
 * 2.可以修饰类/方法
 * 3.抽象类
 *      此类不能被实例化
 *      抽象类中一定有构造器，便于子类实例化调用
 *      开发中，抽象类一定有子类，让子类对象实例化，完成相关操作
 * 4.抽象方法
 *      抽象方法只有方法的声明，没有方法体
 *      包含抽象方法的类一定是抽象类
 *      若子类重写了父类中所有抽象方法后，此子类可以实例化
 *      若子类没有，也是一个抽象类，需用abstract修饰
 *
 */
public class Abstract {
    public static void main(String[] args) {
        abstract_f abstract_s = new abstract_s("123",12);
        abstract_s.run();

        abstract_f abstract_f = new abstract_f() {
            @Override
            public void eat() {
                System.out.println("eat_f");
            }
        };
        abstract_f.eat();
    }
}

//抽象类
abstract class abstract_f{
    String name;
    int age;

    public abstract_f() {
    }

    public abstract_f(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void run(){
        System.out.println("run");
    }

    //抽象方法
    public abstract void eat();
}

class abstract_s extends abstract_f{

    public abstract_s(String name,int age){
        super();
    }

    public void eat() {
        System.out.println("eat");
    }
}
