package usuallyClass.compare;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author wanyu
 * @createTime 2022-02-13 23:42
 *
 * Compare
 * 1.在Java中经常会涉及到对象数组的排序问题，那么就涉及到对象之间的比较问题。
 * 2.一般java对象只能比较 ==/！=，但需要使用</>，需要比较对象大小，如何实现
 *      >Comparable
 *      >Comparator
 *
 * Comparable使用：
 *      1.像String/包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小
 *      2.像String/包装类等重写了compareTo(obj)方法，进行从小到大排序
 *      3.重写compareTo(obj)的规则：
 *          如果当前对象this大于形参对象obj，则返回正整数
 *          如果当前对象this小于形参对象obj，则返回负整数
 *          如果当前对象this等于形参对象obj，则返回零
 *
 */
public class Compare_IDEA {
    @Test
    public void SortTest(){
        String[] arr = new String[]{"aa","bb","dd","hh","ee","dd"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void compareTest(){
        Goods[] arr = new Goods[4];
        Goods a = new Goods("a", 22.0);
        Goods b = new Goods("dd", 222.0);
        Goods c = new Goods("d", 212.0);
        Goods d = new Goods("e", 122.0);

        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Goods implements Comparable{
    String name;
    Double price;

    public Goods(String str,Double price){
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

    //指明商品比较大小的方法
    public int compareTo(Object o) {
        if(o instanceof Goods){
           Goods goods =  (Goods)o;
           return -Double.compare(this.price,goods.price);
//           if(this.price > goods.price){
//               return 1;
//           }else if(this.price < goods.price){
//               return -1;
//           }else return -this.name.compareTo(goods.name);
        }
        throw new RuntimeException("传入类型不同一");
    }
}