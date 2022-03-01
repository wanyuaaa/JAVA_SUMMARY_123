package IO.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wanyu
 * @create 2022-02-23 10:42
 */
public class InetAddress_IDEA {
    public static void main(String[] args) {
        try {
            InetAddress byName1 = InetAddress.getByName("192.168.1.44");
            System.out.println(byName1);

            InetAddress byName2 = InetAddress.getByName("www.baidu.com");
            System.out.println(byName2);

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
