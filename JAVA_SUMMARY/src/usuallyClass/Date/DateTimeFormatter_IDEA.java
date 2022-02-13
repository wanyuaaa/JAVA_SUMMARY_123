package usuallyClass.Date;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author wanyu
 * @createTime 2022-02-13 19:04
 * <p>
 * DateTimeFormatter
 * 格式化与解析日期或时间
 * <p>
 * java.time.format.DateTimeFormatter 类：该类提供了三种格式化方法：
 *  预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
 *  本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
 *  自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
 */
public class DateTimeFormatter_IDEA {
    @Test
    public void dateTest() {
        //1.预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期-->字符串
        LocalDateTime now = LocalDateTime.now();
        String format_now = isoLocalDateTime.format(now);
        System.out.println(now);
        System.out.println(format_now);
        //解析：字符串-->日期
        TemporalAccessor parse = isoLocalDateTime.parse(format_now);
        System.out.println(parse);

        //2.本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatterL = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
        String formatL = dateTimeFormatterL.format(now1);
        System.out.println(formatL);
        DateTimeFormatter dateTimeFormatterS = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withZone(ZoneId.systemDefault());
        String formatS = dateTimeFormatterS.format(now1);
        System.out.println(formatS);

        //3.自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);
        //解析
        TemporalAccessor parse1 = dateTimeFormatter.parse(format);
        System.out.println(parse1);
    }
}
