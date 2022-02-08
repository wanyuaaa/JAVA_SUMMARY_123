package oop;

import java.util.Objects;

/**
 * @author wanyu
 * @createTime 2022-02-06 16:16
 *
 * Object
 *
 * Object类是所有Java类的根父类
 * 如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类
 *
 * 属性：无
 * 方法：....
 *
 * ==操作符与equals方法
 *
 * ==:
 * 基本类型比较值:只要两个变量的值相等，即为true。
 * 引用类型比较引用(是否指向同一个对象)：只有指向同一个对象时，==才返回true。
 * 用“==”进行比较时，符号两边的数据类型必须兼容(可自动转换的基本数据类型除外)，否则编译出错
 *
 * equals:
 * 所有类都继承了Object，也就获得了equals()方法。还可以重写。
 * 只能比较引用类型，其作用与“==”相同,比较是否指向同一个对象。
 * 格式:obj1.equals(obj2)
 * 特例：当用equals()方法进行比较时，对类File、String、Date及包装类（Wrapper Class）来说，
 * 是比较类型及内容而不考虑引用的是否是同一个对象；
 * 原因：在这些类中重写了Object类的equals()方法。
 * 当自定义使用equals()时，可以重写。用于比较两个对象的“内容”是否都相等
 *
 * 重写equals()方法的原则
 *  对称性：如果x.equals(y)返回是“true”，那么y.equals(x)也应该返回是“true”。
 *  自反性：x.equals(x)必须返回是“true”。
 *  传递性：如果x.equals(y)返回是“true”，而且y.equals(z)返回是“true”，那么z.equals(x)也应该返回是“true”。
 *  一致性：如果x.equals(y)返回是“true”，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是“true”。
 *  任何情况下，x.equals(null)，永远返回是“false”；x.equals(和x不同类型的对象)永远返回是“false”。
 *
 * ==和equals的区别:
 * 1. == 既可以比较基本类型也可以比较引用类型。对于基本类型就是比较值，对于引用类型就是比较内存地址
 * 2. equals的话，它是属于java.lang.Object类里面的方法，如果该方法没有被重写过默认也是==;我们可以看到
 *    String等类的equals方法是被重写过的，而且String类在日常开发中用的比较多，久而久之，形成了equals是比较值的错误观点。
 * 3. 具体要看自定义类里有没有重写Object的equals方法来判断。
 * 4. 通常情况下，重写equals方法，会比较类中的相应属性是否都相等。
 *
 * toString
 *
 * String/Date/File/包装类，重写了toString()
 *
 * toString()方法在Object类中定义，其返回值是String类型，返回类名和它的引用地址。
 * 在进行String与其它类型数据的连接操作时，自动调用toString()方法.
 * 可以根据需要在用户自定义类型中重写toString()方法如String 类重写了toString()方法，返回字符串的值。
 * 基本类型数据转换为String类型时，调用了对应包装类的toString()方法
 * int a=10; System.out.println(“a=”+a);
 *
 */
public class Object_S {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.getClass().getSuperclass());

        Order order1 = new Order();
        Order order2 = new Order();

        String str1 = "hello";
        String str2 = "hello";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(order1 == order2);
        System.out.println(order1.equals(order2));
        order2 = order1;
        str1 = str2;
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(order1 == order2);
        System.out.println(order1.equals(order2));

    }
}

class Order{
    private int anInt;
    private String bString;

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public String getbString() {
        return bString;
    }

    public void setbString(String bString) {
        this.bString = bString;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getAnInt() == order.getAnInt() && Objects.equals(getbString(), order.getbString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnInt(), getbString());
    }
}