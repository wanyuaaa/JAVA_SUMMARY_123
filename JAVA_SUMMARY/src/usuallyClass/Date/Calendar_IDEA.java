package usuallyClass.Date;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author wanyu
 * @createTime 2022-02-13 17:24
 *
 * Calendar日历类
 *
 *  Calendar是一个抽象基类，主用用于完成日期字段之间相互操作的功能。
 *  获取Calendar实例的方法
 *       使用Calendar.getInstance()静态方法
 *       调用它的子类GregorianCalendar的构造器。
 *
 *  一个Calendar的实例是系统时间的抽象表示，通过get(int field)方法来取得想 * 要的时间信息。
 * 比如YEAR、MONTH、DAY_OF_WEEK、HOUR_OF_DAY 、MINUTE、SECOND
 *       public void set(int field,int value)
 *       public void add(int field,int amount)
 *       public final Date getTime()
 *       public final void setTime(Date date)
 *  注意:
 *       获取月份时：一月是0，二月是1，以此类推，12月是11
 *       获取星期时：周日是1，周二是2 ， 。。。。周六是7
 *
 */
public class Calendar_IDEA {
    @Test
    public void calendarTest(){
        //1.实例化
        //方式一：创建其子类GregorianCalendar的构造器
        //方式二：使用Calendar.getInstance()静态方法

        Calendar calendar = Calendar.getInstance();//GregorianCalendar.class

        //2.常用方法
        //get()
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//这个月第几天
        //set()
        calendar.set(2022,6,22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //getTime():日历类-->date
        Date time = calendar.getTime();
        //setTime():date-->日历类
        Date date = new Date();
        calendar.setTime(date);
    }
}
