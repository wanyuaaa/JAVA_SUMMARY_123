package oop;

/**
 * @author wanyu
 * @createTime 2022-02-08 12:34
 *
 * 内部类
 *
 * 在Java中，允许一个类的定义位于另一个类的内部，前者称为内部类，后者称为外部类。
 * Inner class一般用在定义它的类或语句块之内，在外部引用它时必须给出完整的名称。
 * Inner class的名字不能与包含它的外部类类名相同；
 *
 * 分类： 成员内部类（static成员内部类和非static成员内部类）
 *       局部内部类（不谈修饰符）、匿名内部类
 *
 * 成员内部类：
 *      作为外部类的成员：
 *          可以调用外部类结构：外部类.this.属性/方法
 *          可以被static修饰
 *          可以被四种不同权限修饰
 *      作为一个类：
 *          可以定义属性，方法，构造器等；
 *          可以用final修饰，表示此类不能被继承；
 *          可以被abstract修饰，不能被实例化
 *
 *  内部类仍然是一个独立的类，在编译之后内部类会被编译成独立的.class文件，但
 * 是前面冠以外部类的类名和$符号，以及数字编号。
 *  只能在声明它的方法或代码块中使用，而且是先声明后使用。除此之外的任何地方
 * 都不能使用该类。
 *  局部内部类可以使用外部类的成员，包括私有的。
 *  局部内部类可以使用外部方法的局部变量，但是必须是final的。由局部内部类和局
 * 部变量的声明周期不同所致。
 *  局部内部类和局部变量地位类似，不能使用public,protected,缺省,private
 *  局部内部类不能使用static修饰，因此也不能包含静态成员
 *
 */
public class InnerClass {
    public static void main(String[] args) {
        //创建成员静态内部类
        person_inner.ee ee = new person_inner.ee();

        //创建成员非静态内部类
        person_inner person_inner = new person_inner();
        oop.person_inner.dd dd = person_inner.new dd();

    }
}

class person_inner{
    //成员内部类
    class dd{};

    //静态成员内部类
    static class ee{}

    //局部内部类
    public void method(){
        class aa{}
    }

    //局部内部类
    {
        class bb{}
    }

    //局部内部类
    public person_inner(){
        class cc{}
    }
}