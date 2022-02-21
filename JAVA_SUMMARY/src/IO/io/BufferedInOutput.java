package IO.io;

import java.io.*;

/**
 * @author wanyu
 * @createTime 2022-02-21 20:53
 */
public class BufferedInOutput {
    public static void main(String[] args) {
        BufferedFileCopy("photoCopy.png","photoCopy3.png");
    }

    public static void BufferedFileCopy(String str1,String str2){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            File file1 = new File(str1);
            File file2 = new File(str2);

            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] chars = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(chars))!=-1){
                bufferedOutputStream.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
