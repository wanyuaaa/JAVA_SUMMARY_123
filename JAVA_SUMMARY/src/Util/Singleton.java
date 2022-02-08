package Util;

/**
 * @author wanyu
 * @createTime 2022-02-07 14:57
 * <p>
 * 单例设计模式
 * <p>
 * 设计模式是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。
 * 设计模免去我们自己再思考和摸索。就像是经典的棋谱，不同的棋局，我们用不同的棋谱。”套路”
 * <p>
 * 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对
 * 某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。
 * 如果我们要让类在一个虚拟机中只能产生一个对象，我们首先必须将类的构
 * 造器的访问权限设置为private，这样，就不能用new操作符在类的外部产生
 * 类的对象了，但在类内部仍可以产生该类的对象。因为在类的外部开始还无
 * 法得到类的对象，只能调用该类的某个静态方法以返回类内部创建的对象，
 * 静态方法只能访问类中的静态成员变量，所以，指向类内部产生的该类对象
 * 的变量也必须定义成静态的。
 *
 * 1.单例保证整个类只有一个对象实例
 * 2.实现：懒汉式/饿汉式
 * 3.区分：饿汉式加载时间过长，天然线程安全/懒汉式延迟对象创建，线程危险
 *
 * 典型：Runtime
 *
 * 应用场景：
 *  网站的计数器，一般也是单例模式实现，否则难以同步。
 *  应用程序的日志应用，一般都使用单例模式实现，这一般是由于共享的日志
 * 文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
 *  数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库
 * 资源。
 *  项目中，读取配置文件的类，一般也只有一个对象。没有必要每次使用配置
 * 文件数据，都生成一个对象去读取。
 *  Application 也是单例的典型应用
 *  Windows的Task Manager (任务管理器)就是很典型的单例模式
 *  Windows的Recycle Bin (回收站)也是典型的单例应用。在整个系统运行过程
 * 中，回收站一直维护着仅有的一个实例。
 */
public class Singleton {
    public static void main(String[] args) {
        Bank instance = Bank.getInstance();
        Bank instance1 = Bank.getInstance();
        System.out.println(instance == instance1);

        Order instance2 = Order.getInstance();
        Order instance3 = Order.getInstance();
        System.out.println(instance2 == instance3);

    }
}

//饿汉式
class Bank {

    //1.私有化构造器,避免外部调用
    private Bank() {
    }

    //2.内部创建类的对象
    //4.此对象也必须为静态的
    private static Bank Instance1 = new Bank();

    //3.提供公共方法，返回类对象
    public static Bank getInstance() {
        return Instance1;
    }

}

//懒汉式
//线程锁synchronized
class Order {

    //1.私有化构造器
    private Order() {
    }

    //2.声明当前此类对象，没有初始化
    //4.此对象也必须为static
    private static Order Instance2 = null;

    //3.声明public static的返回当前类对象方法
    public synchronized static Order getInstance() {
        if (Instance2 == null)
            Instance2 = new Order();
        return Instance2;
    }

}
