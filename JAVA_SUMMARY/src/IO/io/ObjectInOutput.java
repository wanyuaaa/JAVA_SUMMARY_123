package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author wanyu
 * @create 2022-02-22 15:10
 *
 * 对象流
 *       ObjectInputStream和ObjectOutputSteam
 *           用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，
 *            也能把对象从数据源中还原回来。
 *       序列化：用ObjectOutputStream类保存基本类型数据或对象的机制
 *       反序列化：用ObjectInputStream类读取基本类型数据或对象的机制
 *       ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * 对象的序列化
 *      对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，
 *      或通过网络将这种二进制流传输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原来的Java对象
 *      序列化的好处在于可将任何实现了Serializable接口的对象转化为字节数据，使其在保存和传输时可被还原
 *      序列化是 RMI（Remote Method Invoke – 远程方法调用）过程的参数和返回值都必须实现的机制，而 RMI是JavaEE的基础。
 *      因此序列化机制是JavaEE平台的基础
 *      如果需要让某个对象支持序列化机制，则必须让对象所属的类及其属性是可序列化的，为了让某个类是可序列化的，
 *      该类必须实现如下两个接口之一。否则，会抛出NotSerializableException异常
 *          Serializable
 *          Externalizable
 *      凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量：
 *          private static final long serialVersionUID;
 *          serialVersionUID用来表明类的不同版本间的兼容性。简言之，其目的是以序列化对象进行版本控制，有关各版本反序列化时是否兼容。
 *          如果类没有显示定义这个静态常量，它的值是Java运行时环境根据类的内部细节自动生成的。若类的实例变量做了修改，
 *          serialVersionUID 可能发生变化。故建议，显式声明。
 *       简单来说，Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，
 *      JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较，如果相同就认为是一致的，
 *      可以进行反序列化，否则就会出现序列化版本不一致的异常。(InvalidCastException)
 *
 */
public class ObjectInOutput {
    @Test
    public void test1() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("Object.txt"));
            objectOutputStream.writeObject(new String("我爱你，中国！"));
            objectOutputStream.flush();

            objectOutputStream.writeObject(new person("万宇",29));
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test2() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream= new ObjectInputStream(new FileInputStream("Object.txt"));
            Object o = objectInputStream.readObject();
            String str = (String)o;
            System.out.println(str);

            Object o2 = objectInputStream.readObject();
            person p = (person)o2;
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
//标识接口
//内部所有属性也必须序列化的
class person implements Serializable{
    @Serial
    private static final long serialVersionUID = -4351200984664069229L;

    String name;
    int age;

    public person() {
    }

    public person(String name, int age) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        person person = (person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}