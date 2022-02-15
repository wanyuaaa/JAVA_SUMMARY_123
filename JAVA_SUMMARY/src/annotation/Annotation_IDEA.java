package annotation;

/**
 * @author wanyu
 * @createTime 2022-02-15 20:48
 *
 * Annotation(5.0)
 *
 * 一 概述
 *      1.从JDK 5.0开始, Java增加了对元数据(MetaData)的支持, 也就是Annotation(注解)
 *      2.Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。
 *      通过使用 Annotation, 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。代码分析工具、
 *      开发工具和部署工具可以通过这些补充信息进行验证或者进行部署
 *      3.Annotation 可以像修饰符一样被使用, 可用于修饰包,类, 构造器, 方法, 成员变量, 参数, 局部变量的声明,
 *      这些信息被保存在 Annotation的 “name=value” 对中。
 *      4.在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，
 *      例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。
 *      5.未来的开发模式都是基于注解的，JPA是基于注解的，Spring2.5以上都是基于注解的，Hibernate3.x以后也是基于注解的，
 *      现在的Struts2有一部分也是基于注解的了，注解是一种趋势，一定程度上可以说：框架 = 注解 + 反射 + 设计模式。
 *
 * 二 示例
 *      示例一：生成文档相关的注解
 *       @author 标明开发该类模块的作者，多个作者之间使用,分割
 *       @version 标明该类模块的版本
 *       @see 参考转向，也就是相关主题
 *       @since 从哪个版本开始增加的
 *       @param 对方法中某参数的说明，如果没有参数就不能写
 *       @return 对方法返回值的说明，如果方法的返回值类型是void就不能写
 *       @exception 对方法可能抛出的异常进行说明 ，如果方法没有用throws显式抛出的异常就不能写其中
 *       @param @return 和 @exception 这三个标记都是只用于方法的。
 *       @param的格式要求：@param 形参名 形参类型 形参说明
 *       @return 的格式要求：@return 返回值类型 返回值说明
 *       @exception的格式要求：@exception 异常类型 异常说明
 *       @param和@exception可以并列多个
 *
 *      示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 *      @Override: 限定重写父类方法, 该注解只能用于方法
 *      @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 *      @SuppressWarnings: 抑制编译器警告
 *
 *      示例三：跟踪代码依赖性，实现替代配置文件功能
 *      Servlet3.0提供了注解(annotation),使得不再需要在web.xml文件中进行Servlet的部署。
 *      spring框架中关于“事务”的管理
 *
 * 利用反射获取注解信息
 *      JDK 5.0 在 java.lang.reflect 包下新增了 AnnotatedElement 接口, 该接口代表程序中可以接受注解的程序元素
 *      当一个 Annotation 类型被定义为运行时 Annotation 后, 该注解才是运行时可见,
 *      当 class 文件被载入时保存在 class 文件中的 Annotation 才会被虚拟机读取
 *      程序可以调用 AnnotatedElement对象的如下方法来访问 Annotation 信息
 *
 */
public class Annotation_IDEA {
    @SuppressWarnings("unused")
    String abc;
}

@AnnotationMyself("自定义测试")
class person{
    private String name;
    private int age;

    public person() {
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("走路");
    }

    public void run(){
        System.out.println("跑步");
    }
}

interface Info{
    void show();
}

class Student extends person implements Info{

    public Student() {
    }

    @Override
    public void walk(){

    }

    @Override
    public void run() {

    }

    @Override
    public void show() {

    }
}