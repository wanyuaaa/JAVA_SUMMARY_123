package Reflection;

import Reflection.utilClass.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

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

    //操作运行时类
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
}
