package thread;

/**
 * @author wanyu
 * @createTime 2022-02-09 21:37
 *
 * Thread中常用的方法：
 *      1.start()：启动线程，并执行对象的run()方法
 *      2.run()：线程在被调度时执行的操作
 *      3.static Thread currentThread()：返回当前线程。
 *      4.getName()
 *      5.setName()
 *      6.yield()：释放当前cpu的执行权
 *      7.join()：a线程中调用b线程的join()，此时a进入阻塞，直到b执行完
 *      8.stop()：结束线程，已过时
 *      9.sleep(long millis)：线程休眠
 *      10.isAlive()：判断当前线程是否存活
 *
 * 线程的优先级
 *       线程的优先级等级
 *              MAX_PRIORITY：10
 *              MIN _PRIORITY：1
 *              NORM_PRIORITY：5        默认优先级
 *       涉及的方法
 *              getPriority() ：返回线程优先值
 *              setPriority(int newPriority) ：改变线程的优先级
 *       说明
 *              线程创建时继承父线程的优先级
 *              低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用
 *
 */
public class ThreadMethod {
    public static void main(String[] args) {
        TMethod tMethod = new TMethod("线程一");
        //tMethod.setName("线程一");
        Thread.currentThread().setName("main_s:");
        System.out.println(tMethod.getPriority());
        tMethod.setPriority(10);
        tMethod.start();

        for (int i = 0; i < 100; i++) {
            if(i%2 == 0)
                System.out.println(TMethod.currentThread().getName()+":"+i);

//            if(i == 20) {
//                try {
//                    tMethod.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}

class TMethod extends Thread{

    public TMethod(String name){
        super.setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0)
                System.out.println(TMethod.currentThread().getName()+":"+i);
        }
    }
}