package oop;

/**
 * @author wanyu
 * @createTime 2022-02-07 16:30
 * <p>
 * final 最终
 * <p>
 * 在Java中声明类、变量和方法时，可使用关键字final来修饰,表示“最终的”。
 *
 * final标记的类不能被继承。提高安全性，提高程序的可读性。例如：String类、System类、StringBuffer类
 * final标记的方法不能被子类重写。例如：Object类中的getClass()。
 * final标记的变量(成员变量或局部变量)即称为常量。名称大写，且只能被赋值一次。
 *      final标记的成员变量必须在声明时或在每个构造器中或代码块中显式赋值，然后才能使用。
 *      final double MY_PI = 3.14;
 *
 *
 *
 *
 */
public class Final {
}

final class final_S {
    final int width = 0;
    final int height;
    final int right;
    private static final int a = 0;

    {
        height = 0;
    }

    public final_S(){
        right = 0;
    }

    public void show(final int a){
    }



}