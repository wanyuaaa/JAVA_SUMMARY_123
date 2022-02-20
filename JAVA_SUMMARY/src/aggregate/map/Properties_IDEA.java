package aggregate.map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author wanyu
 * @createTime 2022-02-19 17:
 *
 * Properties
 *
 * Properties 类是 Hashtable 的子类，该对象用于处理属性文件
 * 由于属性文件里的 key、value 都是字符串类型，所以 Properties 里的 key 和 value 都是字符串类型
 * 存取数据时，建议使用setProperty(String key,String value)方法和getProperty(String key)方法
 *
 */
public class Properties_IDEA {
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        pros.load(new FileInputStream("jdbc.properties"));
        String user = pros.getProperty("user");
        System.out.println(user);
    }
}
