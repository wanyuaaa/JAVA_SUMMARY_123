package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author wanyu
 * @createTime 2022-02-22 0:20
 *
 * 其他流的使用
 *
 * 1.标准的输入输出流
 *       System.in和System.out分别代表了系统标准的输入和输出设备
 *       默认输入设备是：键盘，输出设备是：显示器
 *       System.in的类型是InputStream
 *       System.out的类型是PrintStream，其是OutputStream的子类 FilterOutputStream 的子类
 *       重定向：通过System类的setIn，setOut方法对默认设备进行改变。
 *           public static void setIn(InputStream in)
 *           public static void setOut(PrintStream out)
 * 2.打印流
 *      实现将基本数据类型的数据格式转化为字符串输出
 *      打印流：PrintStream和PrintWriter
 *           提供了一系列重载的print()和println()方法，用于多种数据类型的输出
 *           PrintStream和PrintWriter的输出不会抛出IOException异常
 *           PrintStream和PrintWriter有自动flush功能
 *           PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类。
 *           System.out返回的是PrintStream的实例
 * 3.数据流
 *       为了方便地操作Java语言的基本数据类型和String的数据，可以使用数据流。
 *       数据流有两个类：(用于读取和写出基本数据类型、String类的数据）
 *           DataInputStream 和 DataOutputStream
 *           分别“套接”在 InputStream 和 OutputStream 子类的流上
 *       DataInputStream中的方法
 *          boolean readBoolean() byte readByte()
 *          char readChar() float readFloat()
 *          double readDouble() short readShort()
 *          long readLong() int readInt()
 *          String readUTF() void readFully(byte[] b)
 *       DataOutputStream中的方法
 *           将上述的方法的read改为相应的write即可。
 *
 */
public class OtherStream {
    public static void main(String[] args) {
        System.out.println("请输入信息(退出输入e或exit):");
        // 把"标准"输入流(键盘输入)这个字节流包装成字符流,再包装成缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            while ((s = br.readLine()) != null) { // 读取用户输入的一行数据 --> 阻塞程序
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                    System.out.println("安全退出!!");
                    break;
                }
        // 将读取到的整行字符串转成大写输出
                System.out.println("-->:" + s.toUpperCase());
                System.out.println("继续输入信息");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // 关闭过滤流时,会自动关闭它包装的底层节点流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Test
    public void test2(){
        DataOutputStream dos = null;
        try { // 创建连接到指定文件的数据输出流对象
            dos = new DataOutputStream(new FileOutputStream("destData.dat"));
            dos.writeUTF("我爱北京天安门"); // 写UTF字符串
            dos.writeBoolean(false); // 写入布尔值
            dos.writeLong(1234567890L); // 写入长整数
            System.out.println("写文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // 关闭流对象
            try {
                if (dos != null) {
                    // 关闭过滤流时,会自动关闭它包装的底层节点流
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("destData.dat"));
            String info = dis.readUTF();
            boolean flag = dis.readBoolean();
            long time = dis.readLong();
            System.out.println(info);
            System.out.println(flag);
            System.out.println(time);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
