package IO;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author wanyu
 * @createTime 2022-02-20 21:03
 *
 * File
 *
 * 1.File类的一个对象，代表一个文件或一个文件夹
 * 2.java.io
 * 3.file类中涉及到关于文件或文件目录的创建/删除/重命名/修改时间/文件大小等方法，未涉及到写入或读取文件内容的操作，
 * 需要读取或写入文件内容，必须用IO流来完成
 * 4.后续file类的对象常作为参数传递到流的构造器中，指明读取或写入的终点
 *
 *       java.io.File类：文件和文件目录路径的抽象表示形式，与平台无关
 *       File 能新建、删除、重命名文件和目录，但 File 不能访问文件内容本身。如果需要访问文件内容本身，则需要使用输入/输出流。
 *       想要在Java程序中表示一个真实存在的文件或目录，那么必须有一个File对象，但是Java程序中的一个File对象，可能没有一个真实存在的文件或目录。
 *       File对象可以作为参数传递给流的构造器
 *
 * 常用构造器
 *       public File(String pathname)
 *      以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果pathname是相对路径，
 *      则默认的当前路径在系统属性user.dir中存储。
 *           绝对路径：是一个固定的路径,从盘符开始
 *           相对路径：是相对于某个位置开始
 *       public File(String parent,String child)以parent为父路径，child为子路径创建File对象。
 *      c根据一个父File对象和子文件路径创建File对象
 *
 *       路径中的每级目录之间用一个路径分隔符隔开。
 *       路径分隔符和系统有关：
 *           windows和DOS系统默认使用“\”来表示
 *           UNIX和URL使用“/”来表示
 *       Java程序支持跨平台运行，因此路径分隔符要慎用。
 *       为了解决这个隐患，File类提供了一个常量：
 *          public static final String separator。根据操作系统，动态的提供分隔符。
 *       举例：
 *          File file1 = new File("d:\\atguigu\\info.txt");
 *          File file2 = new File("d:" + File.separator + "atguigu" + File.separator + "info.txt");
 *          File file3 = new File("d:/atguigu");
 *
 */
public class File_IDEA {
    @Test
    public void test1(){
        //常用构造器
        //1.public File(String pathname)
        File file1 = new File("hello.text");
        File file2 = new File("E:\\BaiduNetdiskDownload\\DUOXIE1092\\Evil Goddess 1.092");

        //2.public File(String parent,String child)
        File file3 = new File("E:\\BaiduNetdiskDownload","DUOXIE1092");

        //3.public File(File parent,String child)
        File file4 = new File(file3,"Evil Goddess 1.092");
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);

    }
}
