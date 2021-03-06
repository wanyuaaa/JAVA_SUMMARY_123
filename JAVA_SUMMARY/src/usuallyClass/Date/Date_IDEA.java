package usuallyClass.Date;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
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
 *      toString()
 *      getTime()
 * 3.java.sql.Date<-->java.util.Date
 *
 * java.util.date/java.sql.date(1.0) --> instant(8.0)
 * simpleDateFormat(1.0) -->DateTimeFormatter(8.0)
 * calendar(1.1) -->localDate/localTime/LocalDateTime(7.0/8.0)
 *
 */
public class Date_IDEA {
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test2(){
        //构造器
        Date date = new Date();
        long l = System.currentTimeMillis();
        java.sql.Date date1 = new java.sql.Date(l);

        System.out.println(date.toString());
        System.out.println(date.getTime());
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        //构造器
        Date date2 = new Date(l);
    }

    @Test
    public void test3(){
        Date date = new Date();
        //java.sql.Date<-->java.util.Date
        java.sql.Date date1 = new java.sql.Date(date.getTime());
    }
}
