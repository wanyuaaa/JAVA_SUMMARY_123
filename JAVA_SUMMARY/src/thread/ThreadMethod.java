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
 *      7.join()：插入线程
 *
 */
public class ThreadMethod {
    public static void main(String[] args) {
        TMethod tMethod = new TMethod("线程一");
        //tMethod.setName("线程一");
        Thread.currentThread().setName("main_s:");
        tMethod.start();

        for (int i = 0; i < 100; i++) {
            if(i%2 == 0)
                System.out.println(TMethod.currentThread().getName()+":"+i);

            if(i == 20) {
                try {
                    tMethod.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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