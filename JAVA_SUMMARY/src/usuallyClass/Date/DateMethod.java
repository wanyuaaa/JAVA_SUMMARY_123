package usuallyClass.Date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wanyu
 * @createTime 2022-02-13 15:45
 *
 * 1.system.currentTimeMillis();
 * 2.java.util.date/java.sql.date
 * 3.simpleDateFormat
 * 4.Calendar
 */
public class DateMethod {
    /*
    * simpleDateFormat的使用：simpleDateFormat堆日期date的格式化和解析
    * 1.格式化：日期-->字符串
    * 2.解析：字符串-->日期
    *
    * simpleDateFormat的实例化
    */
    @Test
    public void simpleDateFormatTest() throws ParseException {
        //实例化simpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        //日期-->字符串
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        //字符串-->日期
        String str = "2022/02/13 下午15:45";
        Date parse = simpleDateFormat.parse(str);
        System.out.println(parse);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat1.format(date);
        System.out.println(format1);

        String str2 = "2022-02-13 16:03:24";
        Date parse1 = simpleDateFormat1.parse(str2);
        System.out.println(parse1);
    }
}
