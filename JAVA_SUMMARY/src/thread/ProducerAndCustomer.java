package thread;

/**
 * @author wanyu
 * @createTime 2022-02-11 1:16
 */
public class ProducerAndCustomer {
    public static void main(String[] args) {
        Clerk clerk = Clerk.getClerk();
        Customer customer = new Customer(clerk);
        Producer producer = new Producer(clerk);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(customer);

        thread1.currentThread().setPriority(10);
        thread2.currentThread().setPriority(1);

        thread2.start();
        thread1.start();
    }

}

class Clerk {
    static int product = 0;
    static int count = 0;

    private static Clerk clerk = null;

    private Clerk() {
    }

    public synchronized static Clerk getClerk() {
        if (clerk == null)
            new Clerk();
        return clerk;
    }
}

class Customer implements Runnable {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ProducerAndCustomer.class) {
                if (clerk.count == 50){
                    ProducerAndCustomer.class.notifyAll();
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ProducerAndCustomer.class.notifyAll();
                if (clerk.product> 0) {
                    clerk.product--;
                    clerk.count++;
                    System.out.println("Customer消费了货物，当前剩余货物：" + clerk.product+";count:"+ clerk.count);
                }
                try {
                    ProducerAndCustomer.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ProducerAndCustomer.class) {
                if (clerk.count == 50){
                    ProducerAndCustomer.class.notifyAll();
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ProducerAndCustomer.class.notifyAll();
                if (clerk.product < 20) {
                    clerk.product ++;
                    clerk.count++;
                    System.out.println("producer生产了货物，当前拥有货物：" + clerk.product+";count:"+ clerk.count);
                }
                try {
                    ProducerAndCustomer.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}