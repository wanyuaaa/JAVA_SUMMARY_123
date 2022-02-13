package usuallyClass.BigIntegerBigDecimal;

/**
 * @author wanyu
 * @createTime 2022-02-14 1:24
 *
 * BigInteger
 *
 *  Integer类作为int的包装类，能存储的最大整型值为2^31-1，Long类也是有限的，最大为2^63-1。
 * 如果要表示再大的整数，不管是基本数据类型还是他们的包装类都无能为力，更不用说进行运算了。
 *
 *  java.math包的BigInteger可以表示不可变的任意精度的整数。BigInteger 提供所有 Java 的基本整数操作符的对应物，
 * 并提供 java.lang.Math 的所有相关方法。另外，BigInteger 还提供以下运算：模算术、GCD 计算、质数测试、素数生成、
 * 位操作以及一些其他操作。
 *
 *  构造器
 *       BigInteger(String val)：根据字符串构建BigInteger对象
 *
 *  常用方法
 *       public BigInteger abs()：返回此 BigInteger 的绝对值的 BigInteger。
 *       BigInteger add(BigInteger val) ：返回其值为 (this + val) 的 BigInteger
 *       BigInteger subtract(BigInteger val) ：返回其值为 (this - val) 的 BigInteger
 *       BigInteger multiply(BigInteger val) ：返回其值为 (this * val) 的 BigInteger
 *       BigInteger divide(BigInteger val) ：返回其值为 (this / val) 的 BigInteger。整数相除只保留整数部分。
 *       BigInteger remainder(BigInteger val) ：返回其值为 (this % val) 的 BigInteger。
 *       BigInteger[] divideAndRemainder(BigInteger val)：返回包含 (this / val) 后跟(this % val) 的两个 BigInteger 的数组。
 *       BigInteger pow(int exponent) ：返回其值为 (thisexponent) 的 BigInteger。
 *
 */
public class BigInteger_IDEA {
}
