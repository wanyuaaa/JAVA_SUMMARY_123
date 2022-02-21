package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author wanyu
 * @createTime 2022-02-21 21:55
 *
 * 转换流
 *
 * 转换流提供了在字节流和字符流之间的转换
 * Java API提供了两个转换流：
 *       InputStreamReader：将InputStream转换为Reader
 *       OutputStreamWriter：将Writer转换为OutputStream
 *  字节流中的数据都是字符时，转成字符流操作更高效。
 *  很多时候我们使用转换流来处理文件乱码问题。实现编码和解码的功能。
 *
 * InputStreamReader
 *  实现将字节的输入流按指定字符集转换为字符的输入流。
 *  需要和InputStream“套接”。
 *  构造器
 *       public InputStreamReader(InputStream in)
 *       public InputStreamReader(InputStream in,String charsetName)
 *      如： Reader isr = new InputStreamReader(System.in,”gbk”);
 *
 * OutputStreamWriter
 *  实现将字符的输出流按指定字符集转换为字节的输出流。
 *  需要和OutputStream“套接”。
 *  构造器
 *       public OutputStreamWriter(OutputStream out)
 *       public OutputStreamWriter(OutputStream out,String charsetName)
 *
 */
public class InputStreamReader_IDEA {
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("hi.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

        char[] chars = new char[20];
        int len = 0;
        while ((len = inputStreamReader.read(chars))!= -1){
            String str = new String(chars,0,len);
            System.out.println(str);
        }
        fileInputStream.close();
    }

    @Test
    public void test2() throws IOException {
        File file1 = new File("hi.txt");
        File file2 = new File("hi_gbk.txt");

        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");

        char[] chars = new char[20];
        int len;
        while((len = inputStreamReader.read(chars))!= -1){
            outputStreamWriter.write(chars,0,len);
        }
        outputStreamWriter.flush();

        fileOutputStream.close();
        fileInputStream.close();
    }
}
