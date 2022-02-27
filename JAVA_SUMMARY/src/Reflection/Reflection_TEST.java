package Reflection;

import Reflection.utilClass.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wanyu
 * @create 2022-02-24 17:27
 *
 */
public class Reflection_TEST {
    @Test
    public void test1() throws Exception {
        //调用运行时类指定的属性
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();

        //需要属性设置为public
        Field id = clazz.getField("id");

        id.set(person,1001);
        int n = (int)id.get(person);
        System.out.println(n);
    }

    //操作运行时类调用属性
    @Test
    public void test2() throws Exception {
        //调用运行时类指定的属性
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();

        //1.获取属性
        Field name = clazz.getDeclaredField("name");

        //2.放开私有属性
        name.setAccessible(true);

        //3.操作属性
        name.set(person,"wanYu");
        String str = (String)name.get(person);
        System.out.println(str);
    }

    //操作运行时类调用方法
    @Test
    public void test3() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();

        //1.获取方法
        Method talk = clazz.getDeclaredMethod("talk", String.class);

        //2.保证方法可以被访问
        talk.setAccessible(true);

        //3.调用方法并传入参数
        String str = (String) talk.invoke(person, "abc");
        System.out.println(str);

        System.out.println("----------------------------------------");

        //调用静态方法
        Method run = clazz.getDeclaredMethod("run");
        run.setAccessible(true);

        Object invoke = run.invoke(null);
        System.out.println(invoke);//null
    }

    //操作运行时类调用构造器
    @Test
    public void test4() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();

        //1.获取指定构造器并传入参数
        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(String.class);

        //2.保证构造器可以访问
        declaredConstructor.setAccessible(true);

        Person wanYu = declaredConstructor.newInstance("wanYu");
        System.out.println(wanYu.toString());
    }
}
