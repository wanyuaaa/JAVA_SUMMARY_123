package java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author wanyu
 * @createTime 2022-02-27 14:49
 *
 * 构造器引用
 *
 * 格式： ClassName::new
 * 与函数式接口相结合，自动与函数式接口中方法兼容。
 * 可以把构造器引用赋值给定义的方法，要求构造器参数列表要与接口中抽象
 * 方法的参数列表一致！且方法的返回值即为构造器对应类的对象。
 *
 */
public class ConstructorReferences_IDEA {
    @Test
    public void test1(){
        //Supplier<Emp> supplier = () -> new Emp();
        Supplier<Emp> supplier = Emp::new;
        Emp emp1 = supplier.get();

        //Function<String,Emp> function = s -> new Emp(s);
        Function<String,Emp> function = Emp::new;
        Emp emp2 = function.apply("wanYu");

        //BiFunction<String,Integer,Emp> biFunction = (s,i) -> new Emp(s,i);
        BiFunction<String,Integer,Emp> biFunction = Emp::new;
        Emp emp3 = biFunction.apply("wanYu", 19);
    }
}
