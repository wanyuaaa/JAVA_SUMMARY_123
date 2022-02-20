package generic;

import java.util.ArrayList;

/**
 * @author wanyu
 * @createTime 2022-02-20 1:25
 *
 * 自定义泛型结构：泛型类、泛型接口
 *
 * 1. 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：<E1,E2,E3>
 * 2. 泛型类的构造器如下：public GenericClass(){}。而下面是错误的：public GenericClass<E>(){}
 * 3. 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。
 * 4. 泛型不同的引用不能相互赋值。
 *      >尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有一个ArrayList被加载到JVM中。
 * 5. 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object。经验：泛型要使用一路都用。要不用，一路都不要用。
 * 6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
 * 7. jdk1.7，泛型的简化操作：ArrayList<Fruit> flist = new ArrayList<>();
 * 8. 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
 * 9. 在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态属性的类型、非静态方法的参数类型、
 * 非静态方法的返回值类型。但在静态方法中不能使用类的泛型。
 * 10. 异常类不能是泛型的
 * 11. 不能使用new E[]。但是可以：E[] elements = (E[])new Object[capacity];
 * 参考：ArrayList源码中声明：Object[] elementData，而非泛型参数类型数组。
 * 12.父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型：
 *       子类不保留父类的泛型：按需实现
 *           没有类型 擦除
 *           具体类型
 *       子类保留父类的泛型：泛型子类
 *           全部保留
 *           部分保留
 * 结论：子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自己的泛型
 *
 */
public class GenericTest {
    public static void main(String[] args) {
        // 1、使用时：类似于Object，不等同于Object
        ArrayList list = new ArrayList();
        // list.add(new Date());//有风险
        list.add("hello");
        test(list);// 泛型擦除，编译不会类型检查
        // ArrayList<Object> list2 = new ArrayList<Object>();
        // test(list2);//一旦指定Object，编译会类型检查，必须按照Object处理
    }
    public static void test(ArrayList<String> list) {
        String str = "";
        for (String s : list) {
            str += s + ",";
        }
        System.out.println("元素:" + str);
    }
}

class Father<T1, T2> {
}
// 子类不保留父类的泛型
// 1)没有类型 擦除
class Son1 extends Father {// 等价于class Son extends Father<Object,Object>{
}
// 2)具体类型
class Son2 extends Father<Integer, String> {
}
// 子类保留父类的泛型
// 1)全部保留
class Son3<T1, T2> extends Father<T1, T2> {
}
// 2)部分保留
class Son4<T2> extends Father<Integer, T2> {
}

class Father2<T1, T2> {
}
// 子类不保留父类的泛型
// 1)没有类型 擦除
class Son11<A, B> extends Father2{//等价于class Son extends Father<Object,Object>{
}
// 2)具体类型
class Son22<A, B> extends Father2<Integer, String> {
}
// 子类保留父类的泛型
// 1)全部保留
class Son33<T1, T2, A, B> extends Father2<T1, T2> {
}
// 2)部分保留
class Son44<T2, A, B> extends Father2<Integer, T2> {
}

class Person<T> {
    // 使用T类型定义变量
    private T info;
    // 使用T类型定义一般方法
    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    // 使用T类型定义构造器
    public Person() {
    }
    public Person(T info) {
        this.info = info;
    }
    // static的方法中不能声明泛型
    //public static void show(T t) {
    //}
    // 不能在try-catch中使用泛型定义
    //public void test() {
    //try {
    //
    //} catch (MyException<T> ex) {
    //}
    // }
}