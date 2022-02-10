package thread;

/**
 * @author wanyu
 * @create 2022-02-10 9:53
 */
public class ThreadTest {
    public static void main(String[] args) {
        ThreadTest_s threadTest_s1 = new ThreadTest_s();
        threadTest_s1.setName("窗口一");
        ThreadTest_s threadTest_s2 = new ThreadTest_s();
        threadTest_s1.setName("窗口二");
        ThreadTest_s threadTest_s3 = new ThreadTest_s();
        threadTest_s1.setName("窗口三");

        threadTest_s1.start();
        threadTest_s2.start();
        threadTest_s3.start();
    }
}

class ThreadTest_s extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            if(ticket>0){
                System.out.println(getName()+"售出票号："+ticket);
                ticket--;
            }else break;
        }
    }
}