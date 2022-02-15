package Enum;

/**
 * @author wanyu
 * @createTime 2022-02-15 16:11
 *
 * Enum(5.0)
 *
 * 一 枚举类的使用
 *      1.类的对象只有有限个，当需要定义一组常量时，强烈建议使用枚举类
 *      2.如果枚举类中只有一个对象，我们可以用单例模式实现
 *
 * 二 如何定义枚举类
 *      1.5.0前，自定义
 *      2.5.0后，可以使用enum关键字定义枚举类
 *              定义的枚举类默认继承java.lang.enum
 *
 * 三 Enum类中常用的方法
 *      1.values()：返回枚举类型的对象数组
 *      2.valueOf(String str)：可以把一个字符串转为对应枚举类对象，要求字符串必须是枚举类对象的常量
 *      3.toString()：返回当前枚举常量名称
 *      4.equals()：对比枚举是否相同，不可修改
 *      5.hashCode()：和equals保持一致，不可变
 *      6.getDeclaringClass()：得到枚举常量所属枚举类型的class对象，可以判断两个枚举常量是否为一个枚举类型
 *      7.name()：得到枚举常量的名称，建议toString()
 *      8.ordinal()：得到当前枚举常量的次序
 *      9.compareTo()：可以比较两个枚举常量的大小
 *      10.clone()：不能被克隆，实现了一个抛出CloneNotSupportedException异常的不变Clone()
 *
 * 四 使用enum关键字实现枚举类的实现接口的方法
 *      1.和普通 Java 类一样，枚举类可以实现一个或多个接口
 *      2.若每个枚举值在调用实现的接口方法呈现相同的行为方式，则只要统一实现该方法即可
 *      3.若需要每个枚举值在调用实现的接口方法呈现出不同的行为方式,则可以让每个枚举值分别来实现该方法
 *
 */
public class Enum_IDEA {
    public static void main(String[] args) {
        //1.自定义
        Season1 spring = Season1.SPRING;
        String seasonName = spring.getSeasonName();
        String seasonDesc = spring.getSeasonDesc();
        System.out.println(seasonName+"的特点："+seasonDesc);

        //2.使用enum关键字定义枚举类
        //定义的枚举类默认继承java.lang.enum
        Season2 summer = Season2.SUMMER;
        String string = summer.toString();
        System.out.println(string);

        //values
        Season2[] values = Season2.values();
        for (int i = 0; i < values.length; i++)
            System.out.println(values[i]);

        //valueOf(String str)
        Season2 winter = Season2.valueOf("WINTER");
        System.out.println(winter);

        System.out.println(winter == summer);

    }
}

interface info{
    void show();
}

//使用enum关键字定义枚举类
enum Season2 implements info{
    //1.创建常量对象,多个之间用逗号隔开
    SPRING("春天","春暖花开"){
        public void show(){
            System.out.println(1);
        };
    },
    SUMMER("夏天","夏日炎炎"){
        public void show(){
            System.out.println(2);
        };
    },
    AUTUMN("秋天","秋高气爽"){
        public void show(){
            System.out.println(3);
        };
    },
    WINTER("冬天","冰天雪的"){
        public void show(){
            System.out.println(4);
        };
    };

    //2.声明Season对象的属性,需要用final修饰
    private final String seasonName;
    private final String seasonDesc;

    //1.私有化构造器
    private Season2(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}


//自定义枚举类
class Season1{
    //1.声明Season对象的属性,需要用final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化构造器
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.创建常量对象
    public static final Season1 SPRING = new Season1("春天","春暖花开");
    public static final Season1 SUMMER = new Season1("夏天","夏日炎炎");
    public static final Season1 AUTUMN = new Season1("秋天","秋高气爽");
    public static final Season1 WINTER = new Season1("冬天","冰天雪的");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}