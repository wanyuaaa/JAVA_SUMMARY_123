package Reflection;

import Reflection.utilClass.Person;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author wanyu
 * @create 2022-02-24 12:24
 *
 * 通过反射创建对应的运行时类的对象
 *
 */
public class NewInstance_TEST {
    @Test
    public void test1() throws Exception {
        Class<Person> Clazz = Person.class;
        //newInstance()：调用此方法，创建对应的运行时类的对象
        //默认调用空参构造器，构造器不能是私有的
        /**
         * 在javaBean中提供一个public空参构造器，原因：
         * 1.便于通过反射，创建运行时类的对象
         * 2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        Person person = Clazz.newInstance();
        System.out.println(person.toString());
    }

    //随机创建不确定对象
    @Test
    public void test2() throws Exception {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "Reflection.utilClass.Person";
                    break;
            }
            Object instance = getInstance(classPath);
            System.out.println(instance);
        }
    }

    //创建一个指定类对象
    //形参classPath，指定类的全地址
    @Test
    public Object getInstance(String classPath) throws Exception {
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
}
