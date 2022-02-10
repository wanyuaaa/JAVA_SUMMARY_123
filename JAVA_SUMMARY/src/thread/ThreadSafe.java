package thread;

/**
 * @author wanyu
 * @createTime 2022-02-10 17:39
 * <p>
 * 线程安全：
 * 1.同步代码块
 * synchronized (对象){
 * // 需要被同步的代码；
 * }
 * 说明：1.需要被同步的代码
 * 2.共同操作的数据
 * 3.同步监视器，任何一个类的对象都可以充当锁，必须是同一把锁
 * 2.2. synchronized还可以放在方法声明中，表示整个方法为同步方法。
 * 例如：
 * public synchronized void show (String name){
 * …
 * }
 * <p>
 * 局限性：同步的方式，解决了安全问题
 * 但是降低了代码执行的效率
 */
public class ThreadSafe {
    public static void main(String[] args) {
        ThreadSafe threadSafe = new ThreadSafe();
//      threadSafe.runnable();
        threadSafe.thread();
    }

    public void runnable() {
        ThreadSafe_s threadSafe_s = new ThreadSafe_s();

        Thread thread1 = new Thread(threadSafe_s);
        thread1.setName("窗口一");
        Thread thread2 = new Thread(threadSafe_s);
        thread2.setName("窗口二");
        Thread thread3 = new Thread(threadSafe_s);
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void thread() {
        ThreadSafe_t thread1 = new ThreadSafe_t();
        thread1.setName("窗口一");
        ThreadSafe_t thread2 = new ThreadSafe_t();
        thread2.setName("窗口二");
        ThreadSafe_t thread3 = new ThreadSafe_t();
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ThreadSafe_s implements Runnable {
    private int ticket = 100;

    public void run() {
        while (showTicket()) {
        }
    }

    public synchronized boolean showTicket() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "售出票号：" + ticket);
            ticket--;
            return true;
        } else return false;

    }
}

class ThreadSafe_t extends Thread {
    private static int ticket = 100;

    public void run() {
        while (showTicket()) {
        }
    }

    public synchronized static boolean showTicket() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "售出票号：" + ticket);
            ticket--;
            return true;
        } else return false;
    }
}