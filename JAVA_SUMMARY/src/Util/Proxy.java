package Util;

/**
 * @author wanyu
 * @createTime 2022-02-07 21:55
 *
 * 代理模式(Proxy)
 *
 * 代理模式是Java开发中使用较多的一种设计模式。代理设计就是为其他对象提供一种代理以控制对这个对象的访问。
 *
 *
 *
 */
public class Proxy {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}

interface NetWork{
    void browse();
}

//被代理类
class Server implements NetWork{

    public void browse() {
        System.out.println("Server访问网络");
    }
}

//代理类
class ProxyServer implements NetWork{

    private NetWork work;
    public ProxyServer(NetWork netWork){
        this.work = netWork;
    }

    public void check(){
        System.out.println("联网前检查工作");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
}

interface A {
    int x = 0;
}
class B {
    int x = 1;
}
class C extends B implements A {
    public void pX() {
        //System.out.println(x);
        System.out.println(super.x);
        System.out.println(A.x);
    }
    public static void main(String[] args) {
        new C().pX();
    }
}