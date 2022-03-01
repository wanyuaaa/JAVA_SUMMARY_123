package IO.internet;

/**
 * @author wanyu
 * @create 2022-02-23 15:07
 *
 *  URL的方法 openStream()：能从网络上读取数据
 *  若希望输出数据，例如向服务器端的 CGI （公共网关接口-Common Gateway Interface-的简称，是用户浏览器和服务器端的应用程序
 *   进行连接的接口）程序发送一些数据，则必须先与URL建立连接，然后才能对其进行读写，此时需要使用URLConnection 。
 *  URLConnection：表示到URL所引用的远程对象的连接。当与一个URL建立连接时，首先要在一个 URL对象上通过方法openConnection()
 *   生成对应的 URLConnection对象。如果连接过程失败，将产生IOException.
 *      URL netChinaRen = new URL ("http://www.atguigu.com/index.shtml");
 *      URLConnection u = netChinaRen.openConnection( );
 *  通过URLConnection对象获取的输入流和输出流，即可以与现有的CGI程序进行交互。
 *      public Object getContent( ) throws IOException
 *      public int getContentLength( )
 *      public String getContentType( )
 *      public long getDate( )
 *      public long getLastModified( )
 *      public InputStream getInputStream( )throws IOException
 *      public OutputStream getOutputStream( )throws IOException
 *
 * URI、URL和URN的区别
 * URI:是uniform resource identifier，统一资源标识符，用来唯一的标识一个资源。而URL是uniform resource locator，统一资源定位符，
 *     它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate这个资源。
 * URN:uniform resource name，统一资源命名，是通过名字来标识资源，比如mailto:java-net@java.sun.com。也就是说，URI是以一种抽象的，
 *     高层次概念定义统一资源标识，而URL和URN则是具体的资源标识的方式。URL和URN都是一种URI。在Java的URI中，一个URI实例可以代表绝对的，
 *     也可以是相对的，只要它符合URI的语法规则。而URL类则不仅符合语义，还包含了定位该资源的信息，因此它不能是相对的。
 *
 */
public class URLConnection_IDEA {
}
