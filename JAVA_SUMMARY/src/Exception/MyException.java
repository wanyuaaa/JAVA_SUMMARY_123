package Exception;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author wanyu
 * @createTime 2022-02-08 19:34
 *
 * 生成自定义异常类
 *      1.继承现有异常结构：RuntimeException/Exception
 *      2.提供全局常量serialVersionUID
 *      3.提供重载构造器
 *
 */
public class MyException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = -3514676900666028090L;

    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }

}
