package Util;

/**
 * @author wanyu
 * @createTime 2022-02-07 19:28
 *
 * 模板方法设计模式(TemplateMethod)--多态的应用
 *
 * 抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模
 * 板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象
 * 类的行为方式。
 * 
 * 解决的问题：
 *  当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以
 * 把不确定的部分暴露出去，让子类去实现。
 *  换句话说，在软件开发中实现一个算法时，整体步骤很固定、通用，
 * 这些步骤已经在父类中写好了。但是某些部分易变，易变部分可以抽
 * 象出来，供不同子类实现。这就是一种模板模式。
 *
 *
 */
public class TemplateMethod {
    public static void main(String[] args) {
        subTemplate subTemplate = new subTemplate();
        subTemplate.spendTime();
    }
}

abstract class template{

    //计算代码执行花费的时间
    public void spendTime(){
        long start = System.currentTimeMillis();

        code();

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为");

    }

    public abstract void code();
}

class subTemplate extends template{
    @Override
    public void code() {


    }
}
