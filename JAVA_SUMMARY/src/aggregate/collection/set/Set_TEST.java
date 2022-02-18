package aggregate.collection.set;

import java.util.HashSet;

/**
 * @author wanyu
 * @create 2022-02-18 14:16
 */
public class Set_TEST {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);//数组本身村粗的对象的引用，而非对象本身
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);//修改了堆中的数值，但是在数组中比较用的hashcode，是新生成的hashcode，漫天过海，空删
        set.add(new Person(1001,"CC"));
        System.out.println(set);//新添加的对象先计算hashcode，和P1不同，添加成功
        set.add(new Person(1001,"AA"));
        System.out.println(set);//新添加时和P1的hashcode相同，继而equals进行对比，不同，添加成功
    }
}

class Person{
    int age;
    String  name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}