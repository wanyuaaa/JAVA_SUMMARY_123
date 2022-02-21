package IO.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wanyu
 * @create 2022-02-21 14:11
 *
 * IO
 *
 * Java IO原理
 *
 *  I/O是Input/Output的缩写， I/O技术是非常实用的技术，用于处理设备之间的数据传输。如读/写文件，网络通讯等。
 *  Java程序中，对于数据的输入/输出操作以“流(stream)” 的方式进行。
 *  java.io包下提供了各种“流”类和接口，用以获取不同种类的数据，并通过标准的方法输入或输出数据。
 *
 * 流的分类：
 * 按操作数据单位不同分为：字节流(8 bit)，字符流(16 bit)
 * 按数据流的流向不同分为：输入流，输出流
 * 按流的角色的不同分为：节点流，处理流
 *
 * (抽象基类)      节点流             缓冲流（处理流的一种）
 * InputStream    FileInputStream   BufferedInputStream
 * OutputStream   FileOutputStream  BufferedOutputStream
 * Reader         FileReader        BufferedReader
 * Writer         FileWriter        BufferedWriter
 *
 */
public class Io_IDEA {
    public static void main(String[] args) {
        File file = new File("//JAVA_SUMMARY//hi.txt");//相对于当前工程的路径
    }

    FileReader fileReader = null;

    @Test
    public void test1() throws IOException {
        File file = new File("hi.txt");//相对于当前模块的路径

        //提供具体的流
        FileReader fileReader = new FileReader(file);
        //数据的读入
        //read()返回读入的一个字符，如果末尾，返回-1
        int read = fileReader.read();
        while(read != -1){
            System.out.print((char)read);
            read = fileReader.read();
        }

        //流的手动关闭
        fileReader.close();
    }

    @Test
    public void test2(){
        try {
            File file = new File("hi.txt");//相对于当前模块的路径

            //提供具体的流
            fileReader = new FileReader(file);
            //数据的读入
            //read()返回读入的一个字符，如果末尾，返回-1
            int date;
            while((date = fileReader.read())!= -1){
                System.out.print((char)date);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //流的手动关闭
            try {
                if(fileReader!=null)
                    fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test3(){
        try {
            File file = new File("hi.txt");//相对于当前模块的路径

            //提供具体的流
            fileReader = new FileReader(file);
            //数据的读入
            //read()返回读入的一个字符，如果末尾，返回-1
            char[] chars = new char[(int) file.length()];
            while (fileReader.read(chars)!= -1) {
                for (char a:chars) {
                    System.out.print(a);
                }
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //流的手动关闭
            try {
                if(fileReader!=null)
                    fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
