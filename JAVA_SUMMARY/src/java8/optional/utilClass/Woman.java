package java8.optional.utilClass;

import java.util.Objects;

/**
 * @author wanyu
 * @createTime 2022-02-27 23:12
 */
public class Woman{
    private String name;

    public Woman() {
    }

    public Woman(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Woman)) return false;
        Woman woman = (Woman) o;
        return Objects.equals(getName(), woman.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                '}';
    }
}
