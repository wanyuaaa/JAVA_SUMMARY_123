package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wanyu
 * @createTime 2022-02-11 9:34
 * <p>
 * 实现Callable接口
 * <p>
 *  与使用Runnable相比， Callable功能更强大些
 *       相比run()方法，可以有返回值
 *       方法可以抛出异常
 *       支持泛型的返回值
 *       需要借助FutureTask类，比如获取返回结果
 *
 * 如何理解Callable接口比Runnable接口强大：
 *      1.call()有返回值
 *      2.call()可以抛异常
 *      3.call()可以声明泛型
 *
 */
public class Callable_S {
    public static void main(String[] args) {
        //3.创建实现类对象
        Callable_t callable_t = new Callable_t();
        //4.将此实现类对象传到future的构造方法中
        FutureTask<Integer> futureTask = new FutureTask<>(callable_t);
        //5.将futureTask传递到thread类构造器中，创建thread对象，并且start()
        Thread thread1 = new Thread(futureTask);
        thread1.start();

        try {
            //6.获取call()的返回值
            Integer o = futureTask.get();
            System.out.println(o.toString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

//1.创建callable的实现类
class Callable_t implements Callable<Integer> {
    //2.实现call()方法
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}