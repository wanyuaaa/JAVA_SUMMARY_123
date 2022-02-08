package array.Util;

/**
 * @author wanyu
 * @createTime 2022-02-04 16:16
 */
//工具类
public class Int_Arrays_Util {

    //冒泡排序
    public void bubbleSort(int[] arr) {
        int t;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public int getMax(int[] arr) {
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) maxValue = arr[i];
        }
        return maxValue;
    }

    public int getMin(int[] arr) {
        int minValue = 0;
        for (int i = 0; i < arr.length; i++) {
            if (minValue > arr[i]) minValue = arr[i];
        }
        return minValue;
    }

    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int getAvg(int[] arr) {
        int sum = getSum(arr);
        return sum / arr.length;
    }

    //反转数组
    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

    }

    //复制数组
    public int[] copy(int[] arr) {
        int[] arrCopy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = arr[i];
        }
        return arrCopy;
    }

    //遍历数组
    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第" + i + "个元素为：" + arr[i] + "\t");
        }
    }

    //查找指定参数
    public int gerIndex(int[] arr, int dest) {
        for (int i = 0; i < arr.length; i++) {
            if (dest == arr[i]) return i;
        }
        return -1;
    }
}
