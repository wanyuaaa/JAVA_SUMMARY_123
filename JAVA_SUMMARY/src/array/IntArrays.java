package array;

import array.Method.Int_Arrays_Method;

/**
 * @author wanyu
 * @createTime 2022-02-04 2:10
 * 1·十大排序算法：
 * 快速排序：直接选择排序/堆排序
 * 交换排序：⭐冒泡排序O（n²）/⭐快速排序O（nlog2n）
 * 插入排序：直接插入排序/折半插入排序/Shell排序
 * 并归排序
 * 桶式排序
 * 基数排序
 */
public class IntArrays {
    public static void main(String[] args) {

        Int_Arrays_Method int_arrays_method = new Int_Arrays_Method();

        Thread thread1 = new Thread(int_arrays_method);
        Thread thread2 = new Thread(int_arrays_method);
        Thread thread3 = new Thread(int_arrays_method);

        thread1.start();
        thread2.start();
        thread3.start();


        //快速排序和冒泡排序比较
        //Int_Arrays_Method arrays = new Int_Arrays_Method();
        //arrays.IntArrays();

        //工具类调用
//        Int_Arrays_Method arrays = new Int_Arrays_Method();
//        int[] arr = arrays.IntArrays();
//
//        Int_Arrays_Util int_arrays_util = new Int_Arrays_Util();
//        int max = int_arrays_util.getMax(arr);
//        System.out.println(max);
//
//        //输出值
//        int[] arr1 = new int[]{};//地址
//        System.out.println(arr1);
//        char[] arr2 = new char[]{'a', 'b', 'c'};//abc
//        System.out.println(arr2);
    }
}


