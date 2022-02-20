package generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wanyu
 * @createTime 2022-02-20 1:34
 *
 * 自定义泛型结构：泛型方法
 *
 *  方法，也可以被泛型化，不管此时定义在其中的类是不是泛型类。在泛型方法中可以定义泛型参数，此时，参数的类型就是传入数据的类型。
 *  泛型方法的格式：
 *      [访问权限] <泛型> 返回类型 方法名([泛型标识 参数名称]) 抛出的异常
 *  泛型方法声明泛型时也可以指定上限
 *
 *
 */
public class GenericMethod {
    public <E> E get(int id, E e) {
        E result = null;
        return result;
    }

    public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o);
        }
    }
    public static void main(String[] args) {
        Object[] ao = new Object[100];
        Collection<Object> co = new ArrayList<Object>();
        fromArrayToCollection(ao, co);
        String[] sa = new String[20];
        Collection<String> cs = new ArrayList<>();
        fromArrayToCollection(sa, cs);
        Collection<Double> cd = new ArrayList<>();
        // 下面代码中T是Double类，但sa是String类型，编译错误。
        // fromArrayToCollection(sa, cd);
        // 下面代码中T是Object类型，sa是String类型，可以赋值成功。
        fromArrayToCollection(sa, co);
    }
}

class Creature{}
class Person1 extends Creature{}
class Man extends Person1{}
class PersonTest {
    public static <T extends Person1> void test(T t){
        System.out.println(t);
    }
    public static void main(String[] args) {
        test(new Person1());
        test(new Man());
        //The method test(T) in the type PersonTest is not
        //applicable for the arguments (Creature)
        //test(new Creature());
    }
}
