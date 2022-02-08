package IntArrays.Util;

/**
 * @author wanyu
 * @create 2022-02-04 16:16
 */ //工具类
public class Int_Arrays_Util {

    //冒泡排序
    public void bubbleSort(int[] random_int) {
        int t;
        for (int i = 0; i < random_int.length - 1; i++) {
            for (int j = 0; j < random_int.length - 1 - i; j++) {
                if (random_int[j] > random_int[j + 1]) {
                    t = random_int[j];
                    random_int[j] = random_int[j + 1];
                    random_int[j + 1] = t;
                }
            }
        }

    }

}
