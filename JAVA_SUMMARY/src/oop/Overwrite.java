package oop;

/**
 * @author wanyu
 * @createTime 2022-02-05 20:52
 *
 * 方法的重写
 *
 * 定义：在子类中可以根据需要对从父类中继承来的方法进行改造，也称
 * 为方法的重置、覆盖。在程序执行时，子类的方法将覆盖父类的方法。
 *
 * 要求：
 * 1. 子类重写的方法必须和父类被重写的方法具有相同的方法名称、参数列表
 * 2. 子类重写的方法的返回值类型不能大于父类被重写的方法的返回值类型
 * 3. 子类重写的方法使用的访问权限不能小于父类被重写的方法的访问权限
 *      >子类不能重写父类中声明为private权限的方法
 * 4. 子类方法抛出的异常不能大于父类被重写方法的异常
 *
 * 注意：
 * 子类与父类中同名同参数的方法必须同时声明为非static的(即为重写)，或者同时声明为
 * static的（不是重写）。因为static方法是属于类的，子类无法覆盖父类的方法。
 *
 * 从编译和运行的角度看：
 * 重载，是指允许存在多个同名方法，而这些方法的参数不同。编译器根据方法不
 * 同的参数表，对同名方法的名称做修饰。对于编译器而言，这些同名方法就成了
 * 不同的方法。它们的调用地址在编译期就绑定了。Java的重载是可以包括父类
 * 和子类的，即子类可以重载父类的同名不同参数的方法。
 * 所以：对于重载而言，在方法调用之前，编译器就已经确定了所要调用的方法，
 * 这称为“早绑定”或“静态绑定”；
 * 而对于多态，只有等到方法调用的那一刻，解释运行器才会确定所要调用的具体
 * 方法，这称为“晚绑定”或“动态绑定”。
 * 引用一句Bruce Eckel的话：“不要犯傻，如果它不是晚绑定，它就不是多态。”
 *
 */
public class Overwrite {
}
