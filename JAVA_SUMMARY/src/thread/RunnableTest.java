package thread;

/**
 * @author wanyu
 * @create 2022-02-10 9:45
 *
 * Runnable测试
 *
 */
public class RunnableTest {
    public static void main(String[] args) {
        RunnableTest_s runnableTest_s = new RunnableTest_s();

        Thread thread1 = new Thread(runnableTest_s);
        thread1.setName("窗口一");
        Thread thread2 = new Thread(runnableTest_s);
        thread2.setName("窗口二");
        Thread thread3 = new Thread(runnableTest_s);
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableTest_s implements Runnable{
    private int ticket = 1000;
    Object object=new Object();

    public void run() {
            while (true){
                synchronized (object){
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+"售出票号："+ticket);
                    ticket--;
                }else break;
            }
        }
    }
}