package usuallyClass.String;

import java.util.Arrays;

/**
 * @author wanyu
 * @createTime 2022-02-12 21:08
 * <p>
 * 1. 模拟一个trim方法，去除字符串两端的空格。
 * 2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 * 3. 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取"ab"在 "abkkcadkabkebfkabkskab"中出现的次数
 * 4.获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;
 * str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 * 5.对字符串中字符进行自然顺序排序。
 * 提示：
 * 1）字符串变成字符数组。
 * 2）对数组排序，选择，冒泡，Arrays.sort();
 * 3）将排序后的数组变成字符串。
 */
public class StringTest {
    public static void main(String[] args) {
        //1.
        String str1 = "   abc   ";
        String trim = trim(str1);
        System.out.println("1-->" + trim);

        //2.
        String str2 = "abcdefg";
        String reversal = reversal(str2);
        System.out.println("2-->" + reversal);

        //3.
        String str3 = "ab";
        String str4 = "abkkcadkabkebfkabkskab";
        int count = find(str3, str4);
        System.out.println("3-->" + count);

        //4.
        String str5 = "abcwerthelloyuiodef";
        String str6 = "cvhellobnm";

        String compare = compare(str5, str6);
        System.out.println("4-->" + compare);

        //5.
        String str7 = "dcgnlmekhjifab";
        char[] chars = str7.toCharArray();
        Arrays.sort(chars);
        String str8 = new String(chars);
        System.out.println("5-->" + str8);
    }

    private static int find(String str3, String str4) {
        int count = 0;
        int s = str3.length();
        int l = str4.length();

        for (int i = 0; i + s <= l; i++) {
            String ll = str4.substring(i, i + s);
            if (str3.equals(ll)) {
                count++;
            }
        }
        return count;
    }

    private static String compare(String str1, String str2) {
        int l = str1.length();
        int s = str2.length();
        String compare = "";

        for (int i = 0; i < s; i++) {
            int i1 = s - i;
            for (int j = 0; j + i1 <= s; j++) {
                String ss = str2.substring(j, j + i1);
                for (int k = 0; k + i1 <= l; k++) {
                    String ll = str1.substring(k, k + i1);
                    if (ss.equals(ll)) {
                        compare = ss;
                        return compare;
                    }
                }
            }
        }
        return compare;
    }

    private static String reversal(String str) {
        char[] chars1 = str.toCharArray();
        char[] chars2 = new char[str.length()];
        for (int i = 0; i < chars1.length; i++) {
            int j = chars1.length - i - 1;
            chars2[j] = chars1[i];
        }
        String reversal = new String(chars2);
        return reversal;
    }

    private static String trim(String str) {
        String trim = str.trim();
        return trim;
    }
}
