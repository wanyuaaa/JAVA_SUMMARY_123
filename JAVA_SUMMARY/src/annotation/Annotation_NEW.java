package annotation;

import java.lang.annotation.*;

/**
 * @author wanyu
 * @createTime 2022-02-15 23:25
 *
 * JDK8中注解的新特性
 *
 * 可重复注解
 *       Java 8对注解处理提供了两点改进：可重复的注解及可用于类型的注解。此外，反射也得到了加强，
 *      在Java8中能够得到方法参数的名称。这会简化标注在方法参数上的注解。
 *
 * 类型注解：
 *       JDK1.8之后，关于元注解@Target的参数类型ElementType枚举值多了两个：TYPE_PARAMETER,TYPE_USE。
 *       在Java 8之前，注解只能是在声明的地方所使用，Java8开始，注解可以应用在任何地方。
 *           ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *           ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 *
 */
//@Repeatable(AnnotationMyself.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Annotation_NEW {
    String[] value();
}
