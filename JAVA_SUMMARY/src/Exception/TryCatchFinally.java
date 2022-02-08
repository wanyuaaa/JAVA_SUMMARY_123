package Exception;

import org.junit.jupiter.api.Test;

/**
 * @author wanyu
 * @createTime 2022-02-08 16:58
 *
 * try-catch-finally
 *
 * 在编写程序时，经常要在可能出现错误的地方加上检测的代码，如进行x/y运算时，要检测分母为0，数据为空，输入的不是数据
 * 而是字符等。过多的if-else分支会导致程序的代码加长、臃肿，可读性差。因此采用异常处理机制。
 *
 * Java异常处理
 * Java采用的异常处理机制，是将异常处理的程序代码集中在一起，与正常的程序代码分开，使得程序简洁、优雅，并易于维护。
 *
 * 异常处理：抓抛模型
 *      过程一"抛"：
 *      Java程序的执行过程中如出现异常，会生成一个异常类对象，该异常对象将被提交给Java运行时系统，这个过程称为抛出(throw)异常。
 *      异常对象的产生：
 *              1.系统自动生成异常对象
 *              2.手动生成一个异常对象，并抛出throw
 *
 *              throw 和 throws区别
 *              throw异常的生成阶段：手动抛出异常对象
 *              throws异常的处理方式：声明方法可能要抛出的各种异常类
 *
 *      过程二"抓"：
 *      可以理解为异常的处理方式：
 *              1.try-catch-finally
 *                      try{
 *                          ...... //可能产生异常的代码
 *                      }
 *                      catch( ExceptionName1 e ){
 *                          ...... //当产生ExceptionName1型异常时的处置措施
 *                      }
 *                      catch( ExceptionName2 e ){
 *                          ...... //当产生ExceptionName2型异常时的处置措施
 *                      }
 *                      [ finally{
 *                          ...... //无论是否发生异常，都无条件执行的语句
 *                      }
 *
 *                      1.finally是可选的，像数据库，IO，Socket需手动执行的可以放到
 *                      2.使用try将可能出现的异常包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常的对象，根据此对象
 *                      类型去catch中匹配
 *                      3.一旦匹配一个catch就跳出，在没有finally的情况下
 *                      4.catch的异常有子父类关系，则子类异常一定声明在父类上面
 *                      5.常用的异常对象处理方式，String getMessage/printStackTrace()
 *                      6.在try中声明的变量，在除了try中，其他不可调用
 *              2.throws
 *                      1.throws+异常类型卸载方法声明处，指明方法执行时，可能会抛出的异常类型，一旦方法体执行出现异常，
 *                      仍会在异常代码出生成一个异常类对像，此对象满足throws后异常类型，就会抛出，异常代码后的代码就不会执行
 *                      2.try-catch-finally将异常真正的处理掉了，throws只是将异常抛给了方法的调用者，并没有将异常处理掉
 *
 * 开发中如何选择：
 *      1.父类中被重写的方法没有抛出异常，子类重写的方法也不能抛出异常
 *      2.执行方法a中，先后又调用了另外的几个方法，这几个放发是递进关系执行的，我们建议这几个方法用throws抛出，
 *      而执行的方法a进行try-catch-finally处理
 *
 */
public class TryCatchFinally {

    @Test
    public void test1(){
        String str = "123";
        str = "abc";
        try {
            int i = Integer.valueOf(str);
            System.out.println(1);//try内捕获抛出并不执行
        }catch (NumberFormatException e){
            System.out.println("NumberFormatException:"+e);
            e.printStackTrace();
        }finally {
            System.out.println(2);
        }
        System.out.println(3);

        throw new RuntimeException("123");
    }
}
