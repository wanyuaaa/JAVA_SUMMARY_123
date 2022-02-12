package usuallyClass;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author wanyu
 * @createTime 2022-02-12 14:43
 * <p>
 * String转换
 */
public class StringInteger {

    @Test
    public void method1() {
        String s1 = "abc";
        int i = Integer.parseInt(s1);
    }

    //String-->char[]
    @Test
    public void method2() {
        String s1 = "abc123";
        char[] charArray = s1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] charArray2 = new char[]{'h','e','l','l','o'};
        String s2 = new String(charArray2);
        System.out.println(s2);
    }

    //String-->byte[]
    @Test
    public void method3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes();
        System.out.println(Arrays.toString(bytes));

        //编码
        byte[] gbk = s1.getBytes("gbk");
        System.out.println(Arrays.toString(gbk));

        //解码
        String s2 = new String(gbk,"gbk");
        System.out.println(s2);

    }
}
