package oop;

import java.util.Date;

/**
 * @author wanyu
 * @createTime 2022-02-05 19:50
 * <p>
 * 继承性
 * <p>
 * 为什么要有继承？
 * 1.减少代码量-冗余，提高复用性
 * 多个类中存在相同属性和行为时，将这些内容抽取到单独一个类中，那么多个类无需再定义这些属性和行为，只要继承那个类即可。
 * 2.便于拓展
 * 3.多态性使用
 * <p>
 * 格式：class A extends B{}
 * A：子类/派生类/subclass
 * B：父类/基类/superclass
 * <p>
 * 体现：一旦子类A继承父类B之后，子类A就拥有了父类B的结构：属性/方法
 * 父类中声明为private的属性/方法，子类继承父类以后，仍认为父类中私有的结构，只有因为封装性的影响，是的子类不能直接调用父类的结构而已
 * <p>
 * Java只支持单继承和多层继承，不允许多重继承
 *  一个子类只能有一个父类
 *  一个父类可以派生出多个子类
 *  class SubDemo extends Demo{ } //ok
 *  class SubDemo extends Demo1,Demo2...//error
 */
public class Inheritance {
    public static void main(String[] args) {
        Student student = new Student(6);

        student.name = "wanyu";

        student.getInfo();
        student.school = "59";
        //student.sex = "nan";

        System.out.println(student.toString());
    }
}

class PersonInheritance {
    public String name;
    public int age;
    public Date birthDate;
    private String sex;

    public PersonInheritance() {
    }
    private void run(){
        System.out.println("123");
    }

    public PersonInheritance(int age) {
        this.age = age;
    }

    public void getInfo() {
        System.out.println("wanyu");
    }
}

class Student extends PersonInheritance {
    public String school;

    public Student(int age) {
        super(age);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", birthDate=" + birthDate + ", school='" + school + '\'' + '}';
    }
}
