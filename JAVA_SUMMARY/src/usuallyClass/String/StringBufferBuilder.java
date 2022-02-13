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
 * StringBuffer类不同于String，其对象必须使用构造器生成。有三个构造器：
 *      StringBuffer()：初始容量为16的字符串缓冲区
 *      StringBuffer(int size)：构造指定容量的字符串缓冲区
 *      StringBuffer(String str)：将内容初始化为指定字符串内容
 *
 * StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
 * StringBuffer delete(int start,int end)：删除指定位置的内容
 * StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
 * StringBuffer insert(int offset, xxx)：在指定位置插入xxx
 * StringBuffer reverse() ：把当前字符序列逆转
 *
 * public int indexOf(String str)
 * public String substring(int start,int end)
 * public int length()
 * public char charAt(int n )
 * public void setCharAt(int n ,char ch)
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
