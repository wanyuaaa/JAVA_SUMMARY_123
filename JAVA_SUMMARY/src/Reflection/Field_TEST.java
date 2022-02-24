package Reflection;

import Reflection.utilClass.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author wanyu
 * @create 2022-02-24 13:45
 */
public class Field_TEST {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;

        //获取当前所有属性
        //getFields()：获取当前运行时类及其父类中声明过为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields)
            System.out.println(f);

        System.out.println("*************************");

        //getDeclaredFields():获取当前运行时类的所有属性，不包含父类属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields)
            System.out.println(f);
    }

    @Test
    public void test2() {
        Class<Person> clazz = Person.class;

        //获取属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            //数据类型
            Class<?> type = f.getType();
            System.out.println(type);
            //变量名
            String name = f.getName();
            System.out.println(name);
        }

        System.out.println("***********");

        //获取方法getMethods()：获取运行时类及其父类中声明为public方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("***********");

        //getDeclaredMethods():获取当前运行时类中所有的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);

            //获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations)
                System.out.println(a);

            //权限修饰符
            int modifiers = m.getModifiers();
            System.out.println(Modifier.toString(modifiers));

            //返回值类型
            Class<?> returnType = m.getReturnType();
            System.out.println(returnType);

            //获取方法名
            String name = m.getName();
            System.out.println(name);

            //形参列表
            System.out.println("(");
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1){
                        System.out.println(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.println(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
            System.out.println(")");

            //抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.println("exceptionTypes:");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i == exceptionTypes.length-1){
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.println(exceptionTypes[i].getName()+",");
                }
            }
            System.out.println("************************");

        }
    }

    @Test
    public void test3() {
        Class<Person> clazz = Person.class;
        //获取当前运行时类public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor c : constructors)
            System.out.println(c);

        //获取当前运行时类所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors)
            System.out.println(c);
    }

    @Test
    public void test4() {
        //获取运行时类的父类
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        //泛型父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        //获取泛型参数
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);
    }

    @Test
    public void test5() {
        Class<Person> clazz = Person.class;

        //获取当前运行时类实现的接口
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces)
            System.out.println(i);

        //获取当前运行时类父类实现的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class i : interfaces1)
            System.out.println(i);
    }

    @Test
    public void test6() {
        Class<Person> clazz = Person.class;

        //获取运行时类所在的包
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    @Test
    public void test7() {
        Class<Person> clazz = Person.class;

        //获取运行时类的注解
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a : annotations)
            System.out.println(a);
     }


}
