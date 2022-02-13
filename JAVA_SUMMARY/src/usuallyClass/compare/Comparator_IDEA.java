package usuallyClass.compare;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wanyu
 * @createTime 2022-02-14 0:37
 *
 * 定制排序：java.util.Comparator
 *
 *  当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口的
 * 排序规则不适合当前的操作，那么可以考虑使用 Comparator 的对象来排序，强行对多个对象进行整体排序的比较。
 *  重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返回正整数，则表示o1大于o2；
 * 如果返回0，表示相等；返回负整数，表示o1小于o2。
 *  可以将 Comparator 传递给 sort 方法（如 Collections.sort 或 Arrays.sort），从而允许在排序顺序上实现精确控制。
 *  还可以使用 Comparator 来控制某些数据结构（如有序 set或有序映射）的顺序，或者为那些没有自然顺序的对象 collection 提供排序。
 *
 * Comparable /Comparator区别
 * Comparable接口方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小
 * Comparator属于临时性比较
 *
 */
public class Comparator_IDEA {

    @Test
    public void comparatorTest(){
        String[] arr = new String[]{"aa","bb","dd","hh","ee","dd"};
        //按字符串从大到小排序
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
    }

    @Test
    public void compareTest(){
        Goods[] arr = new Goods[5];
        Goods a = new Goods("a", 22.0);
        Goods b = new Goods("dd", 222.0);
        Goods c = new Goods("d", 212.0);
        Goods d = new Goods("e", 122.0);
        Goods e = new Goods("e", 123.0);

        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;
        arr[4] = e;

        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if(o1.name.equals(o2.name)){
                    return -Double.compare(o1.price, o2.price);
                }else return -o1.name.compareTo(o2.name);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}

class Goods2{
    String name;
    Double price;

    public Goods2(String str,Double price){
        this.name = str;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}