package annotation;

import java.lang.annotation.*;

/**
 * @author wanyu
 * @createTime 2022-02-15 22:11
 *
 * 自定义Annotation
 *
 *  定义新的 Annotation 类型使用 @interface 关键字
 *  自定义注解自动继承了java.lang.annotation.Annotation接口
 *  Annotation 的成员变量在 Annotation 定义中以无参数方法的形式来声明。其方法名和返回值定义了该成员的名字和类型。
 * 我们称为配置参数。类型只能是八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、以上所有类型的数组。
 *  可以在定义 Annotation 的成员变量时为其指定初始值, 指定成员变量的初始值可使用 default 关键字
 *  如果只有一个参数成员，建议使用参数名为value
 *  如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认值。格式是“参数名 = 参数值”，
 * 如果只有一个参数成员，且名称为value，可以省略“value=”
 *  没有成员定义的 Annotation 称为标记; 包含成员变量的 Annotation 称为元数据 Annotation
 *
 * 注意：自定义注解必须配上注解的信息处理流程才有意义。
 *
 * 三 元注解
 *       对现有注解进行解释说明
 *       JDK 的元 Annotation 用于修饰其他 Annotation 定义
 *       JDK5.0提供了4个标准的meta-annotation类型，分别是：
 *           Retention
 *               @Retention: 只能用于修饰一个 Annotation 定义, 用于指定该 Annotation 的生命
 *               周期,@Retention包含一个 RetentionPolicy 类型的成员变量, 使用@Rentention
 *               时必须为该 value 成员变量指定值:
 *               RetentionPolicy.SOURCE:在源文件中有效（即源文件保留），编译器直接丢弃这种策略的注释
 *               RetentionPolicy.CLASS:在class文件中有效（即class保留），当运行Java程序时,JVM不会保留注解。这是默认值
 *               RetentionPolicy.RUNTIME:在运行时有效（即运行时保留），当运行Java程序时,JVM会保留注释。
 *               程序可以通过反射获取该注释。
 *           Target
 *              @Target: 用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素。
 *              并且@Target 也包含一个名为 value 的成员变量。
 *           Documented
 *              @Documented: 用于指定被该元 Annotation 修饰的 Annotation 类将被javadoc工具提取成文档。
 *              默认情况下，javadoc是不包括注解的。
 *              定义为Documented的注解必须设置Retention值为RUNTIME。
 *           Inherited
 *              @Inherited: 被它修饰的 Annotation 将具有继承性。如果某个类使用了被@Inherited修饰的Annotation,
 *              则其子类将自动具有该注解。
 *              比如：如果把标有@Inherited注解的自定义的注解标注在类级别上，子类则可以继承父类类级别的注解
 *              实际应用中，使用较少
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface AnnotationMyself {
    String[] value() default "abc";
}

