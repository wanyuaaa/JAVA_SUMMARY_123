package IO.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author wanyu
 * @create 2022-02-22 16:19
 *
 * RandomAccessFile
 *
 * RandomAccessFile 声明在java.io包下，但直接继承于java.lang.Object类。并且它实现了DataInput、DataOutput这两个接口，
 * 也就意味着这个类既可以读也可以写。
 * RandomAccessFile 类支持 “随机访问”的方式，程序可以直接跳到文件的任意地方来读、写文件
 *      支持只访问文件的部分内容
 *      可以向已存在的文件后追加内容
 * RandomAccessFile 对象包含一个记录指针，用以标示当前读写处的位置。
 *  RandomAccessFile 类对象可以自由移动记录指针：
 *      long getFilePointer()：获取文件记录指针的当前位置
 *      void seek(long pos)：将文件记录指针定位到 pos 位置
 * 构造器
 *      public RandomAccessFile(File file, String mode)
 *      public RandomAccessFile(String name, String mode)
 * 创建 RandomAccessFile 类实例需要指定一个 mode 参数，该参数指定 RandomAccessFile 的访问模式：
 *      r: 以只读方式打开
 *      rw：打开以便读取和写入
 *      rwd:打开以便读取和写入；同步文件内容的更新
 *      rws:打开以便读取和写入；同步文件内容和元数据的更新
 *  如果模式为只读r。则不会创建文件，而是会去读取一个已经存在的文件，如果读取的文件不存在则会出现异常。
 * 如果模式为rw读写。如果文件不存在则会去创建文件，如果存在则不会创建。
 *
 * 我们可以用RandomAccessFile这个类，来实现一个多线程断点下载的功能，用过下载工具的朋友们都知道，
 * 下载前都会建立两个临时文件，一个是与被下载文件大小相同的空文件，另一个是记录文件指针的位置文件，每次
 * 暂停的时候，都会保存上一次的指针，然后断点下载的时候，会继续从上一次的地方下载，从而实现断点下载或上传的功能
 *
 */
public class RandomAccessFile_IDEA {
    @Test
    public void test1() {
        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile1 = new RandomAccessFile("photomode_28122020_001912.png","r");
            randomAccessFile2 = new RandomAccessFile("photoRandom.png","rw");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = randomAccessFile1.read(bytes))!=-1){
                randomAccessFile2.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (randomAccessFile1 != null) {
                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
