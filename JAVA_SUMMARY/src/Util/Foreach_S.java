package Util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wanyu
 * @create 2022-02-16 16:51
 *
 * foreach
 *
 */
public class Foreach_S {
    @Test
    public void foreachTest(){
        Collection arrayList1 = new ArrayList<>();
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("c");
        arrayList1.add("d");
        arrayList1.add("e");

        //本质-->迭代器
        for (Object arr:arrayList1){
            System.out.println(arr);
        }

        //取出元素，重新赋值，不改变原数组
        String[] str = new String[5];
        for (String myStr : str) {
            myStr = "atguigu";
            System.out.println(myStr);
        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
