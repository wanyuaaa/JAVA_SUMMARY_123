package thread;

/**
 * @author wanyu
 * @create 2022-02-10 15:51
 *
 * JDK中用Thread.State类定义了线程的几种状态（生命周期）
 *
 * 要想实现多线程，必须在主线程中创建新的线程对象。Java语言使用Thread类
 * 及其子类的对象来表示线程，在它的一个完整的生命周期中通常要经历如下的五
 * 种状态：
 *      新建： 当一个Thread类或其子类的对象被声明并创建时，新生的线程对象处于新建状态
 *      就绪：处于新建状态的线程被start()后，将进入线程队列等待CPU时间片，此时它已具备了运行的条件，只是没分配到CPU资源
 *      运行：当就绪的线程被调度并获得CPU资源时,便进入运行状态， run()方法定义了线程的操作和功能
 *      阻塞：在某种特殊情况下，被人为挂起或执行输入输出操作时，让出 CPU 并临时中止自己的执行，进入阻塞状态
 *              sleep()/wait()/suspend()挂起-过时
 *      死亡：线程完成了它的全部工作或线程被提前强制性地中止stop()或出现异常导致结束
 *
 */
public class State {
}
