package usuallyClass.BigIntegerBigDecimal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author wanyu
 * @createTime 2022-02-14 1:26
 *
 * BigDecimal
 *
 *  一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中，要求数字精度比较高，故用到java.math.BigDecimal类。
 *
 *  BigDecimal类支持不可变的、任意精度的有符号十进制定点数。
 *
 *  构造器
 *       public BigDecimal(double val)
 *       public BigDecimal(String val)
 *
 *  常用方法
 *       public BigDecimal add(BigDecimal augend)
 *       public BigDecimal subtract(BigDecimal subtrahend)
 *       public BigDecimal multiply(BigDecimal multiplicand)
 *       public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
 *
 */
public class BigDecimal_IDEA {
    @Test
    public void testBigInteger() {
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        // System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));
    }

}
