package Reflection;

import Reflection.utilClass.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wanyu
 * @createTime 2022-02-23 23:07
 *
 * Java Reflection
 *
 *  Reflection（反射）是被视为动态语言的关键，反射机制允许程序在执行期借助于Reflection API取得任何类的内部信息，
 * 并能直接操作任意对象的内部属性及方法。
 *  加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（一个类只有一个Class对象），这个对象就包含了完整的类的结构信息。
 * 我们可以通过这个对象看到类的结构。这个对象就像一面镜子，透过这个镜子看到类的结构，所以，我们形象的称之为：反射。
 *  Java反射机制提供的功能
 *      在运行时判断任意一个对象所属的类
 *      在运行时构造任意一个类的对象
 *      在运行时判断任意一个类所具有的成员变量和方法
 *      在运行时获取泛型信息
 *      在运行时调用任意一个对象的成员变量和方法
 *      在运行时处理注解
 *      生成动态代理
 *
 * 1.什么时候使用反射，为什么用反射：动态性
 * 2.反射和封装是否矛盾：不矛盾，提示
 *

 *
 */
public class Reflection_IDEA {
    @Test
    public void test1(){
        //创建Person类对象
//        Person wanYu = new Person("wanYu", 28);
//
//        wanYu.age = 29;
//        System.out.println(wanYu.toString());
//        wanYu.run();
    }

    @Test
    public void test2() throws Exception {
        //反射创建Person类对象
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class, int.class);
        Person wanYu = constructor.newInstance("wanYu", 28);
        System.out.println(wanYu.toString());

        //通过反射调用对象的属性和方法
        Field age = personClass.getDeclaredField("age");
        age.set(wanYu,29);
        System.out.println(wanYu.toString());

        //通过反射调用对象的方法
        Method declaredMethod = personClass.getDeclaredMethod("run");
        declaredMethod.invoke(wanYu);

        //通过反射可以调用私有属性方法构造器
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person maYun = declaredConstructor.newInstance("maYun");
        System.out.println(maYun.toString());
        //私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(maYun,"maHuaTen");
        System.out.println(maYun.toString());
        //私有方法
        Method talk = personClass.getDeclaredMethod("talk",String.class);
        talk.setAccessible(true);
        String about = (String) talk.invoke(maYun, "中国");
        System.out.println(about);

    }
}

