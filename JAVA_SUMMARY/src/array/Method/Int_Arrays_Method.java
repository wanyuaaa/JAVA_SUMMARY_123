package array.Method;

import array.Util.Int_Arrays_Util;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author wanyu
 * @createTime 2022-02-04 16:16
 */ //方法类
public class Int_Arrays_Method {

    //生成随机大数组，比较快速排序和冒泡排序效率
    public int[] IntArrays() {
        System.out.println("请输入随机数组的长度！");

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        //生成隨機數組
        int[] random_int = new int[num];

        Random r = new Random(1);

        for (int i = 0; i < num - 1; i++) {
            random_int[i] = r.nextInt(100000);
        }

        //查找
        //Arrays.binarySearch(random_int,1000);

        //快速排序时间
        long sortStart = System.currentTimeMillis();
        Arrays.sort(random_int);
        long sortEnd = System.currentTimeMillis();
        long sortTime = sortEnd - sortStart;

        //System.out.println("排序結果為："+Arrays.toString(random_int));
        System.out.println("快速排序的耗時為：" + sortTime + "ms");

        //冒泡排序时间
        long bubbleSortStart = System.currentTimeMillis();
        Int_Arrays_Util arrays = new Int_Arrays_Util();
        arrays.bubbleSort(random_int);
        long bubbleSortEnd = System.currentTimeMillis();
        long bubbleSortTime = bubbleSortEnd - bubbleSortStart;

        //System.out.println("排序結果為："+Arrays.toString(random_int));
        System.out.println("冒泡排序的耗時為：" + bubbleSortTime + "ms");

        return random_int;
    }

}
