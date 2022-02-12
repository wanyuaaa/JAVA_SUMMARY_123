package usuallyClass.String;

import java.util.Date;

/**
 * @author wanyu
 * @createTime 2022-02-12 15:59
 *
 * String/StringBuffer/StringBuilder三者的异同
 *
 * String：不可变的字符序列，效率最低，底层使用char[]存储
 * StringBuffer：线程安全的可变字符序列，效率低，底层使用char[]存储
 * StringBuilder：线程不安全的可变字符序列，效率高，底层使用char[]存储
 *
 * 扩容问题：
 *      如果要添加的数据底层数组盛不下了，那就需要扩容底层素组
 *      默认扩容底层数组的长度2倍+2，同时将原有数组的数据赋值到新数组中，如果不够，直接用添加新数组长度
 *
 * 开发建议使用StingBuffer(int capacity)或StringBuilder(int capacity)
 *
 */
public class StringBufferBuilder {
    public static void main(String[] args) {
        /*源码分析*/
        String str = new String();//char[] value = new char[0];
        String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};

        StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];
        System.out.println(sb1.length());//0
        sb1.append('a');//value[0] = 'a';
        sb1.append('b');//value[1] = 'b';

        StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length()+16]{'a','b','c'};
    }
}
