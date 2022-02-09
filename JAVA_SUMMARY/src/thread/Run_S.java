package thread;

/**
 * @author wanyu
 * @createTime 2022-02-09 20:58
 *
 * 多线程的创建和启动：
 *      方式一：继承于Thread类
 *              1.创建一个继承于Thread类的子类
 *              2.重写Thread的run()方法
 *              3.创建Thread类的子类对象
 *              4.调用Start()
 *
 * Java语言的JVM允许程序运行多个线程，它通过java.lang.Thread类来体现。
 * Thread类的特性
 *      每个线程都是通过某个特定Thread对象的run()方法来完成操作的，经常把run()方法的主体称为线程体
 *      通过该Thread对象的start()方法来启动这个线程，而非直接调用run()
 *
 */
public class Run_S {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();

        //创建匿名子类对象
        new Thread(){
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2 == 0)
                        System.out.println("thread3:"+i);
                }
            }
        }.start();

        new Thread(){
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2 == 0)
                        System.out.println("thread4:"+i);
                }
            }
        }.start();


        for (int i = 0; i < 100; i++) {
            if(i%2 == 0)
                System.out.println("main:"+i);
        }

    }
}

//1.创建一个继承于Thread类的子类
class MyThread1 extends Thread{
    //2.重写Thread的run()方法
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0)
                System.out.println("thread1:"+i);
        }
    }
}

//1.创建一个继承于Thread类的子类
class MyThread2 extends Thread{
    //2.重写Thread的run()方法
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0)
                System.out.println("thread2:"+i);
        }
    }
}