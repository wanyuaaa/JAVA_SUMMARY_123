package IO.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wanyu
 * @createTime 2022-02-20 21:17
 *
 *  File类的获取功能
 *       public String getAbsolutePath()：获取绝对路径
 *       public String getPath() ：获取路径
 *       public String getName() ：获取名称
 *       public String getParent()：获取上层文件目录路径。若无，返回null
 *       public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
 *       public long lastModified() ：获取最后一次的修改时间，毫秒值
 *      <适用于文件目录>
 *       public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
 *       public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
 *
 *  File类的重命名功能
 *       public boolean renameTo(File dest):把文件重命名为指定的文件路径
 *
 *  File类的判断功能
 *       public boolean isDirectory()：判断是否是文件目录
 *       public boolean isFile() ：判断是否是文件
 *       public boolean exists() ：判断是否存在
 *       public boolean canRead() ：判断是否可读
 *       public boolean canWrite() ：判断是否可写
 *       public boolean isHidden() ：判断是否隐藏
 *
 *  File类的创建功能
 *       public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
 *       public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
 *       public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
 *          注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。
 *
 *  File类的删除功能
 *       public boolean delete()：删除文件或者文件夹
 *          删除注意事项：
 *              Java中的删除不走回收站。
 *              要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
 *
 */
public class File_API {
    @Test
    public void test4() throws IOException {
        //文件创建
        File file1 = new File("abc.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else System.out.println("false");

        //文件目录创建
        File file2 = new File("H:\\User\\Wanyu\\JAVA_SUMMARY\\ABC");
        if(!file2.exists()){
            file2.mkdirs();
            System.out.println("创建成功");
        }else System.out.println("false");
    }

    @Test
    public void test3(){
        File file1 = new File("hi.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }

    @Test
    public void test1(){
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hello.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date(file1.lastModified()));
        System.out.println(format);

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

        File file3 = new File("H:\\User\\Wanyu\\JAVA_SUMMARY");
        String[] list = file3.list();
        for (String s:list) {
            System.out.println(s);
        }

        File[] file4 = file3.listFiles();
        for (File s:file4) {
            System.out.println(s);
        }
    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("H:\\User\\Wanyu\\JAVA_SUMMARY\\hi.txt");

        //需要file1必须存在，file2必须不存在
        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }
}
