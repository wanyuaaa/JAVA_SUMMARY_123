package usuallyClass.Date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author wanyu
 * @createTime 2022-02-13 17:48
 *
 * JDK 1.0中包含了
 * 一个java.util.Date类，但是它的大多数方法已经在JDK 1.1引入Calendar类之后被弃用
 * 了。而Calendar并不比Date好多少。它们面临的问题是：
 *      可变性：像日期和时间这样的类应该是不可变的。
 *      偏移性：Date中的年份是从1900开始的，而月份都从0开始。
 *      格式化：格式化只对Date有用，Calendar则不行。
 *      此外，它们也不是线程安全的；不能处理闰秒等。
 *      总结：对日期和时间的操作一直是Java程序员最痛苦的地方之一。
 *
 * 新时间日期API
 *       第三次引入的API是成功的，并且Java 8中引入的java.time API 已经纠正了过去的缺陷，将来很长一段时间内它都会为我们服务。
 *       Java 8 吸收了 Joda-Time 的精华，以一个新的开始为 Java 创建优秀的 API。新的 java.time 中包含了所有关于
 *      本地日期（LocalDate）、
 *      本地时间（LocalTime）、
 *      本地日期时间（LocalDateTime）、
 *      时区（ZonedDateTime）、
 *      持续时间（Duration）
 *      历史悠久的 Date 类新增了 toInstant() 方法，用于把 Date 转换成新的表示形式。
 *      这些新增的本地化时间日期 API 大大简化了日期时间和本地化的管理。
 *
 */
public class Date_NEW {

    @Test
    public void dateTest(){
        //偏移量问题
        Date date1 = new Date(2022 - 1900, 2 - 1, 13);
        System.out.println(date1);
    }

    @Test
    public void time(){
        //1.now()：获取当前时间
        LocalDate now1 = LocalDate.now();
        LocalTime now2 = LocalTime.now();
        LocalDateTime now = LocalDateTime.now();

        //2.of()：设置时间
        LocalDateTime t = LocalDateTime.of(2022, 6, 7, 13, 22, 45);

        //3.getXxx()
        System.out.println(t.getDayOfMonth());
        System.out.println(t.getDayOfWeek());
        System.out.println(t.getMonth());
        System.out.println(t.getMonthValue());
        System.out.println(t.getMinute());
        System.out.println(t.getSecond());

        //体现不可变性
        LocalDateTime update = now.withDayOfMonth(22);
        System.out.println(now);
        System.out.println(update);

        //+
        LocalDateTime plusMonths = now.plusMonths(3);
        System.out.println(now);
        System.out.println(plusMonths);

        //-
        LocalDateTime minusDays = now.minusDays(6);
        System.out.println(now);
        System.out.println(minusDays);

    }
}
