package Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wanyu
 * @createTime 2022-02-25 22:39
 *
 * Proxy
 *
 *  代理设计模式的原理:
 * 使用一个代理将对象包装起来, 然后用该代理对象取代原始对象。任何对原始对象的调用都要通过代理。
 * 代理对象决定是否以及何时将方法调用转到原始对象上。
 *  之前为大家讲解过代理机制的操作，属于静态代理，特征是代理类和目标对象的类都是在编译期间确定下来，
 * 不利于程序的扩展。同时，每一个代理类只能为一个接口服务，这样一来程序开发中必然产生过多的代理。最
 * 好可以通过一个代理类完成全部的代理功能。
 *  动态代理是指客户通过代理类来调用其它对象的方法，并且是在程序运行时根据需要动态创建目标类的代理对象。
 *  动态代理使用场合:
 *      调试
 *      远程方法调用
 *  动态代理相比于静态代理的优点：
 *      抽象角色中（接口）声明的所有方法都被转移到调用处理器一个集中的方法中处理，这样，我们可以更加灵活和统一的处理众多的方法。
 *
 */
public class Proxy_IDEA {
    public static void main(String[] args) {
        //静态代理
        ClothFactory nikeClothFactory = new NikeClothFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.produceCloth();

        System.out.println("---------------------------------------------");

        //动态代理
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(superMan);
        proxyInstance.eat("水果");
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
    }
}

interface Human{
    String getBelief();

    void eat(String food);
}

//生成动态代理
//1.如何根据加载到内存中的被代理类，动态创建一个代理类及对象？
//2.当通过代理类的对象调用方法时，如何动态的去调用被代理类中同名方法？
class ProxyFactory{
    //调用此方法，返回一个被代理类的代理对象
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);

        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);
        return o;
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj;//需要被代理类对象赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会调用如下方法invoke();
    //当被代理类的方法a功能声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method即为代理对象调用的方法，args为方法的参数列表，obj为当前代理类
        Object invoke = method.invoke(obj, args);

        return invoke;
    }
}

class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}

//静态代理方法
interface ClothFactory{
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory{

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理类处理");

        clothFactory.produceCloth();

        System.out.println("代理类收尾");

    }
}

class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("耐克工厂工作");
    }
}