package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author wanyu
 * @createTime 2022-02-21 20:13
 */
public class FileInputOutStream {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CopyFile("photomode_28122020_001912.png","photoCopy2.png");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void CopyFile(String url1, String url2){
        FileInputStream fileInput = null;
        FileOutputStream fileOutput = null;
        try {
            File file1 = new File(url1);//相对于当前模块的路径
            File file2 = new File(url2);//相对于当前模块的路径

            //提供具体的流
            fileInput = new FileInputStream(file1);
            fileOutput = new FileOutputStream(file2);
            //数据的读入
            //read()返回读入的一个字符，如果末尾，返回-1
            byte[] bytes = new byte[1024];
            int len;
            while((len = fileInput.read(bytes)) != -1){
                fileOutput.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fileOutput != null) {
                try {
                    fileOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("ok");
        }
    }

    @Test
    public void picTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("photomode_28122020_001912.png");
        FileOutputStream fileOutputStream = new FileOutputStream("photoCopy4.png");

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1){
            for (int i = 0; i<len ;i++){
                bytes[i] = (byte)(bytes[i]^5);
            }
            fileOutputStream.write(bytes,0,len);
        }

        fileOutputStream.close();
        fileInputStream.close();

    }
}
