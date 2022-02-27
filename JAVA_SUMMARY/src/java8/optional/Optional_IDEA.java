package java8.optional;

import java8.optional.utilClass.Man;
import java8.optional.utilClass.Woman;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author wanyu
 * @createTime 2022-02-27 21:13
 *
 * Optional
 *
 *  Optional<T> 类(java.util.Optional) 是一个容器类，它可以保存类型T的值，代表这个值存在。或者仅仅保存null，
 *   表示这个值不存在。原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常。
 *  Optional类的Javadoc描述如下：这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，
 *   调用get()方法会返回该对象。
 *
 *
 *
 */
public class Optional_IDEA {
    @Test
    public void test1(){
        //创建Optional类对象的方法：
        //Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
        Woman woman = new Woman();
        //woman = null;
        Optional<Woman> woman1 = Optional.of(woman);

        //Optional.empty() : 创建一个空的 Optional 实例
        //Optional.ofNullable(T t)：t可以为null
        woman = null;
        Optional<Woman> woman2 = Optional.ofNullable(woman);
    }

    @Test
    public void test2(){
        Man man = new Man();
        //man = null;
        String womanName = getWomanName(man);
        System.out.println(womanName);
    }

    //如何避免空指针
    public String getWomanName(Man man){
        Optional<Man> man1 = Optional.ofNullable(man);
        Man liXanYu = man1.orElse(new Man(new Woman("liXanYu")));

        Woman woman = liXanYu.getWoman();
        Optional<Woman> woman1 = Optional.ofNullable(woman);
        Woman tanYe = woman1.orElse(new Woman("tanYe"));

        return tanYe.getName();
    }
}
