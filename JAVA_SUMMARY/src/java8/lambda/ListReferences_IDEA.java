package java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * @author wanyu
 * @createTime 2022-02-27 15:00
 *
 * 数组引用
 * 格式： type[] :: new
 *
 */
public class ListReferences_IDEA {
    @Test
    public void test1(){
        //Function<Integer,String[]> function = i -> new String[i];
        Function<Integer,String[]> function = String[]::new;
        String[] arr1 = function.apply(5);

    }
}
