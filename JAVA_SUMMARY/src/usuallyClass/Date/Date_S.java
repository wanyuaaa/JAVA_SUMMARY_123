package usuallyClass.Date;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author wanyu
 * @createTime 2022-02-12 17:08
 *
 * Date
 *
 * java.util.Date
 *      |----java.sql.Date
 *
 * 1.构造器的使用
 *      构造器一：Date()
 * 2.方法的使用
 *
 */
public class Date_S {
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test2(){
        //构造器
        Date date = new Date();
       //java.sql.Date date1 = new java.sql.Date();

        System.out.println(date.toString());
        System.out.println(date.getTime());

        //构造器
        Date date1 = new Date(date.getTime());
    }
}
