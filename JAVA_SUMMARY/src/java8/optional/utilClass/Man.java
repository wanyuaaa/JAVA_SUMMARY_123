package java8.optional.utilClass;

/**
 * @author wanyu
 * @createTime 2022-02-27 23:13
 */
public class Man {
    private Woman woman;

    public Man() {
    }

    public Man(Woman woman) {
        this.woman = woman;
    }

    public Woman getWoman() {
        return woman;
    }

    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    @Override
    public String toString() {
        return "Man{" +
                "woman=" + woman +
                '}';
    }
}
