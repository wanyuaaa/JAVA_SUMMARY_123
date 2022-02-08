package oop;

/**
 * @author wanyu
 * @createTime 2022-02-05 14:04
 *
 * 封装和隐藏
 * 高内聚 ：类的内部数据操作细节自己完成，不允许外部干涉；
 * 低耦合 ：仅对外暴露少量的方法用于使用。
 *
 * 隐藏对象内部的复杂性，只对外公开简单的接口。便于外界调用，从而提
 * 高系统的可扩展性、可维护性。通俗的说，把该隐藏的隐藏起来，该暴露
 * 的暴露出来。这就是封装性的设计思想。
 *
 * Java中通过将数据声明为私有的(private)，再提供公共的（public）
 * 方法:getXxx()和setXxx()实现对该属性的操作，以实现下述目的：
 * 1.隐藏一个类中不需要对外提供的实现细节；
 * 2.使用者只能通过事先定制好的方法来访问数据，可以方便地加入控制逻辑，限制对属性的不合理操作；
 * 3.便于修改，增强代码的可维护性；
 *
 * 四种访问权限修饰符
 * Java权限修饰符public、protected、(缺省)、private置于类的成员定义前，用来限定对象对该类成员的访问权限。
 * 修饰符: 1.类内部 2.同一个包 3.不同包的子类 4.同一个工程
 * 修饰类及类内部的：属性/方法/构造器/内部类
 *
 * 总结：JAVA提供四种修饰符来修饰类及类的内部属性，体现类及类的内部结构被调用时可见性的大小
 *
 */
public class Encapsulation {
    public static void main(String[] args) {

        Animal animal = new Animal();

        animal.leg1 = 4;
        //animal.leg2 = 4;

        animal.setLeg2(4);

    }
}

class Animal {

    public int leg1;
    protected int leg3;
    int leg4;
    private int leg2;

    public int getLeg2() {
        return leg2;
    }

    public void setLeg2(int leg2) {
        this.leg2 = leg2;
    }

    //公开
    public void eat(){
        System.out.println("Eating");
    }

    //缺省
    void move(){
        System.out.println("Moving.");
    }

    //私有
    protected  void sex(){
        System.out.println("sex.");
    }

    //私有
    private  void fly(){
        System.out.println("fly.");
    }

}
