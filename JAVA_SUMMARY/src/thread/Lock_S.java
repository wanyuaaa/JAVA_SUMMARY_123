package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wanyu
 * @createTime 2022-02-10 21:46
 * <p>
 * Lock(锁)
 *
 *   从JDK 5.0开始，Java提供了更强大的线程同步机制——通过显式定义同步锁对象来实现同步。同步锁使用Lock对象充当。
 *   java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具。锁提供了对共享资源的独占访问，
 *  每次只能有一个线程对Lock对象加锁，线程开始访问共享资源之前应先获得Lock对象。
 *   ReentrantLock 类实现了Lock ，它拥有与 synchronized 相同的并发性和内存语义，在实现线程安全的控制中，
 *  比较常用的是ReentrantLock，可以显式加锁、释放锁。
 *
 * synchronized 与 Lock 的对比
 *      1. Lock是显式锁（手动开启和关闭锁，别忘记关闭锁），synchronized是隐式锁，出了作用域自动释放
 *      2. Lock只有代码块锁，synchronized有代码块锁和方法锁
 *      3. 使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性（提供更多的子类）
 *
 * 优先使用顺序：
 *      Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 */
public class Lock_S {
    public static void main(String[] args) {
        Lock_test lock_test = new Lock_test();

        Thread thread1 = new Thread(lock_test);
        thread1.setName("窗口一");
        Thread thread2 = new Thread(lock_test);
        thread2.setName("窗口二");
        Thread thread3 = new Thread(lock_test);
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Lock_test implements Runnable {
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    public void run() {
        while (true) {
            try {
                lock.lock();
                Thread.sleep(10);
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出票号：" + ticket);
                    ticket--;
                } else break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}