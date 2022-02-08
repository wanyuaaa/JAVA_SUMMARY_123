package oop;

/**
 * @author wanyu
 * @createTime 2022-02-07 15:49
 *
 * 代码块
 *
 * 代码块(或初始化块)的作用：对Java类或对象进行初始化
 * 代码块(或初始化块)的分类：
 * 一个类中代码块若有修饰符，则只能被static修饰，称为静态代码块(static block)，没有使用static修饰的，为非静态代码块。
 *
 *  静态代码块：用static 修饰的代码块
 * 1. 可以有输出语句。
 * 2. 可以对类的属性、类的声明进行初始化操作。
 * 3. 不可以对非静态的属性初始化。即：不可以调用非静态的属性和方法。
 * 4. 若有多个静态的代码块，那么按照从上到下的顺序依次执行。
 * 5. 静态代码块的执行要先于非静态代码块。
 * 6. 静态代码块随着类的加载而加载，且只执行一次。
 *
 *  非静态代码块：没有static修饰的代码块
 * 1. 可以有输出语句。
 * 2. 可以对类的属性、类的声明进行初始化操作。
 * 3. 除了调用非静态的结构外，还可以调用静态的变量或方法。
 * 4. 若有多个非静态的代码块，那么按照从上到下的顺序依次执行。
 * 5. 每次创建对象的时候，都会执行一次。且先于构造器执行。
 *
 */
public class Block {
    public static void main(String[] args) {
        String desc = Block_S.desc;
        Block_S.talk();

        Block_S block_s = new Block_S();
    }
}

class Block_S{
    String name;
    int age;
    static String desc = "我是一个人";

    public Block_S() {
    }

    public Block_S(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //代码块
    {
        System.out.println("block");
    }

    //静态代码块
    static {
        System.out.println("static block");
        desc = "static block desc";
    }

    public void run(){
        System.out.println("跑步");
    }
    public static void talk(){
        System.out.println("我是个快乐的人");
    }
}