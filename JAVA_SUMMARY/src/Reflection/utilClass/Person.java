package Reflection.utilClass;

import java.io.Serial;
import java.util.Comparator;

/**
 * @author wanyu
 * @create 2022-02-24 9:58
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparator<String>,MyInterface {
    @Serial
    private static final long serialVersionUID = 2558088741370033176L;

    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation("con")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @MyAnnotation("method")
    public static void run() throws RuntimeException{
        System.out.println("run");
    }

    private String talk(String str) {
        System.out.println("talk:" + str);
        return "talk:" + str;
    }

    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

    public void info() {
        System.out.println("person");
    }
}
