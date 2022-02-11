package thread;

import java.util.concurrent.*;

/**
 * @author wanyu
 * @createTime  2022-02-11 11:43
 *
 * 线程池
 *
 *  背景：经常创建和销毁、使用量特别大的资源，比如并发情况下的线程，对性能影响很大。
 *  思路：提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。可以避免频繁创建销毁、
 * 实现重复利用。类似生活中的公共交通工具。
 *  好处：
 *       提高响应速度（减少了创建新线程的时间）
 *       降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *       便于线程管理
 *           corePoolSize：核心池的大小
 *           maximumPoolSize：最大线程数
 *           keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *           …
 *
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //设置线程池--静态属性、方法属于类，不被多态子类继承，而是被父类隐藏起来，需要向上转型调用
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
//        threadPoolExecutor.setCorePoolSize(15);
//        threadPoolExecutor.setMaximumPoolSize(10);

        NumberThread1 numberThread1 = new NumberThread1();
        NumberThread2 numberThread2 = new NumberThread2();

        //2.执行指定线程操作，提供实现runnable或callable接口的实现类
        executorService.execute(numberThread1);//runnable
        Future<Integer> submit = executorService.submit(numberThread2);//callable

        //3.关闭线程池
        executorService.shutdown();

        Integer sum = null;
        try {
            sum = submit.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum);
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"："+i);
            }
        }
    }
}

class NumberThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"："+i);
                sum+=i;
            }
        }
        return sum;
    }
}