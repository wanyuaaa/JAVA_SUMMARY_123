package oop;

/**
 * @author wanyu
 * @createTime 2022-02-05 14:55
 * <p>
 * 构造器
 * 任何一个类都有构造器
 * 作用
 * 1.创建对象
 * 2.初始化属性
 * <p>
 * 创建类对象 = new +构造器；
 * 没有定义构造器，系统提供一个空参的构造器
 * <p>
 * 定义构造器的格式：权限修饰符 类名（形参列表）{}
 * 一旦定义了构造器后，系统不再提供空参构造器
 * 一个类可以创建多个重载的构造器
 * 默认构造器的修饰符与所属类的修饰符一致
 * 父类的构造器不可被子类继承
 * <p>
 * 属性赋值顺序：
 * 1·默认初始化   2·显示初始化    3·构造器中赋值    4·通过对象·方法或对象·属性方式赋值
 */
public class Constructor {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("wanyu");
        Person person3 = new Person("wanyu", 2);

        System.out.println(person3.name);
        System.out.println(person3.getLegs());

    }
}

class Person {

    String name;
    private int legs;

    // 构造器
    public Person() {
        System.out.println("构造器创建1！");
    }

    // 构造器
    public Person(String name) {
        this();
        this.name = name;
        System.out.println("构造器创建2！");
    }

    // 构造器
    public Person(String name, int legs) {
        this(name);
        this.legs = legs;
        System.out.println("构造器创建3！");
    }

    public void setLegs(int i) {
        legs = i;
    }

    public int getLegs() {
        return legs;
    }
}