package Reflection.utilClass;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author wanyu
 * @create 2022-02-24 13:28
 */
public class Creature<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5703264965863595327L;

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
