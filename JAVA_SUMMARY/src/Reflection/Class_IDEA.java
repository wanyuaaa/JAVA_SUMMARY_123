package Reflection;

import Reflection.utilClass.Person;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.util.Properties;

/**
 * @author wanyu
 * @create 2022-02-24 9:46
 *
 * java.lang.Class
 *
 * 关于java.lang.Class类的理解
 * 1.类的加载过程
 *      程序经过javac.exe命令后，生成一个或多个字节码文件(.class结尾)，接着我们使用java.exe命令对某个字节码文件进行解释运行，
 *      相当于把某个字节码文件加载到内存中，此过程就叫类的加载。
 *      加载到内存中的类，我们成为运行时类，此时运行时类就作为一个Class的一个实例。
 *          --万事万物皆对象(对象.xx,File,URL,反射,前端,数据库)
 * 2.Class的实例就对应着一个运行时类。
 * 3.加载到内存中的运行时类，会缓存一段时间，在此时间内，我们可以通过不同的方式来获得此运行时类
 *
 * 哪些类型可以有Class对象？
 * （1）class：外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
 * （2）interface：接口
 * （3）[]：数组
 * （4）enum：枚举
 * （5）annotation：注解@interface
 * （6）primitive type：基本数据类型
 * （7）void
 *
 *
 *
 */
public class Class_IDEA {
    @Test
    public void test1() throws ClassNotFoundException {
        //获取Class类的实例方法
        //1.方式一：调用运行时类的属性.class
        Class<Person> aClass1 = Person.class;

        //2.方式二：通过运行时类的对象.class
        Person person = new Person();
        Class<Person> aClass2 = (Class<Person>) person.getClass();

        //<3>.方式三：通过Class的静态方法：forName(String classPath)
        Class<Person> aClass3 = (Class<Person>) Class.forName("Reflection.utilClass.Person");

        //4.方式四：使用类的加载器Class.loader
        ClassLoader classLoader = Class_IDEA.class.getClassLoader();
        Class<Person> aClass4 = (Class<Person>) classLoader.loadClass("Reflection.utilClass.Person");

        System.out.println(aClass1 == aClass2);
        System.out.println(aClass1 == aClass3);
        System.out.println(aClass1 == aClass4);
    }

    @Test
    public void test2(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

    @Test
    public void test3(){
        ClassLoader classLoader = Class_IDEA.class.getClassLoader();

        //调用getParent()：获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //调用扩展类加载器的getParent()：无法获得引导类加载器
        //引导类加载器主要负责加载java核心类库，无法加载自定义类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //核心类库无法获取
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }

    @Test
    public void test4() throws IOException {
        //Properties用来读取核心类库
        Properties properties = new Properties();
        //方式一：此时文件默认在当前module下
//        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
//        properties.load(fileInputStream);、

        //方式二：使用Classloader
        //配置文件默认识别为当前module的src下
        ClassLoader classLoader = Class_IDEA.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");
        properties.load(resourceAsStream);


        String user = properties.getProperty("user");
        String passWord = properties.getProperty("passWord");

        System.out.println(user+":"+passWord);
    }
}
