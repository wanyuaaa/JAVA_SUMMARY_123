package IO.internet;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wanyu
 * @create 2022-02-23 15:02
 *
 * URL
 *
 *  URL(Uniform Resource Locator)：统一资源定位符，它表示 Internet 上某一资源的地址。
 *  它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate这个资源。
 *  通过URL我们可以访问Internet上的各种网络资源，比如最常见的www，ftp站点。浏览器通过解析给定的URL可以在网络上查找相应的文件或其他资源。
 *  URL的基本结构由5部分组成：
 *      <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
 *      例如:
 *          http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123
 *      #片段名：即锚点，例如看小说，直接定位到章节
 *      参数列表格式：参数名=参数值&参数名=参数值....
 *  为了表示URL，java.net中实现了类URL。我们可以通过下面的构造器来初始化一个URL对象：
 *      public URL (String spec)：通过一个表示URL地址的字符串可以构造一个URL对象。
 *          例如：URL url = new URL ("http://www.baidu.com/");
 *      public URL(URL context, String spec)：通过基URL和相对URL构造一个URL对象。
 *          例如：URL downloadUrl = new URL(url, “download.html")
 *      public URL(String protocol, String host, String file);
 *          例如：new URL("http","www.baidu.com", “download. html");
 *      public URL(String protocol, String host, int port, String file);
 *      例如: URL game = new URL("http", "www.baidu.com", 80, “download.html");
 *  URL类的构造器都声明抛出非运行时异常，必须要对这一异常进行处理，通常是用 try-catch 语句进行捕获。
 *
 * URL类常用方法
 *
 *  一个URL对象生成后，其属性是不能被改变的，但可以通过它给定的方法来获取这些属性：
 *      public String getProtocol( ) 获取该URL的协议名
 *      public String getHost( ) 获取该URL的主机名
 *      public String getPort( ) 获取该URL的端口号
 *      public String getPath( ) 获取该URL的文件路径
 *      public String getFile( ) 获取该URL的文件名
 *      public String getQuery( ) 获取该URL的查询名
 *
 */
public class URL_IDEA {
    public static void main(String[] args){
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //通过一个表示URL地址的字符串可以构造一个URL对象。
            URL url = new URL("http://192.168.1.10/sap/indexExamine.do");
            //示到URL所引用的远程对象的连接。
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            fileOutputStream = new FileOutputStream("JAVA_SUMMARY//abc.html");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test1() {
        try {
            URL url = new URL("http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123");
            //获取该URL的协议名
            System.out.println(url.getProtocol());
            //获取该URL的主机名
            System.out.println(url.getHost());
            //获取该URL的端口号
            System.out.println(url.getPort());
            //获取该URL的文件路径
            System.out.println(url.getPath());
            //获取该URL的文件名
            System.out.println(url.getFile());
            //获取该URL的查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
