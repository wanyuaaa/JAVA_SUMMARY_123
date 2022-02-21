package IO.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author wanyu
 * @createTime 2022-02-21 20:14
 */
public class FileReadWrite {
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
        //String str;
        //while ((str = br.readLine()) != null) { // 一次读取字符文本文件的一行字符
        //bw.write(str); // 一次写入一行字符串
        //bw.newLine(); // 写入行分隔符
        //}

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

    @Test
    public void test4(){
        FileWriter fileWriter = null;
        try {
            File file = new File("hi.txt");//相对于当前模块的路径
            //输出的文件可以不存在，会自动创建
            //如果存在，false会覆盖原有文件,true不会
            fileWriter = new FileWriter(file,true);
            fileWriter.write("\na   bc");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter!=null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test5(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File file1 = new File("hi.txt");
            File file2 = new File("hiCopy.txt");

            fileReader = new FileReader(file1);
            fileWriter = new FileWriter(file2);
            char[] chars = new char[5];
            int len;
            while ((len = fileReader.read(chars))!= -1){
                fileWriter.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
