package thread;

/**
 * @author wanyu
 * @createTime 2022-02-11 0:56
 *
 * 线程通信
 *   wait() 与 notify() 和 notifyAll()
 *       wait()：令当前线程挂起并放弃CPU、同步资源并等待，使别的线程可访问并修改共享资源，而当前线程排队等候其他
 *      线程调用notify()或notifyAll()方法唤醒，唤醒后等待重新获得对监视器的所有权后才能继续执行。
 *       notify()：唤醒正在排队等待同步资源的线程中优先级最高者结束等待
 *       notifyAll ()：唤醒正在排队等待资源的所有线程结束等待.
 *   这三个方法只有在synchronized方法或synchronized代码块中才能使用，否则会报java.lang.IllegalMonitorStateException异常。
 *   因为这三个方法必须有锁对象调用，而任意对象都可以作为synchronized的同步锁，因此这三个方法只能在Object类中声明
 *   必须是synchronized的同监视器
 *
 * sleep()和wait()的异同：
 *      相同点：一旦执行都可以使当前线程阻塞状态
 *      不同点：1.两个方法声明位置不同，sleep方法在thread类中，wait在object中
 *             2.sleep可以在任何地方调用，wait要在同步代码块中使用
 *             3.关于是否释放同步监视器，两个方法都是用在同步代码块或同步方法中，sleep不会释放，wait会放锁
 *
 */
public class Communication {
    public static void main(String[] args) {
        Communication_S communication_s = new Communication_S();
        Thread thread1 = new Thread(communication_s);
        Thread thread2 = new Thread(communication_s);

        thread1.setName("线程一");
        thread2.setName("线程二");

        thread1.start();
        thread2.start();
    }
}

class Communication_S implements Runnable{
    private int  num = 1;

    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (num<=100){
                    System.out.println(Thread.currentThread().getName()+"输出:"+num);
                    num ++;
                }else break;

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}