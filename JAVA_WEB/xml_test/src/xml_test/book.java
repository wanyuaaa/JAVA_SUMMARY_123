package xml_test;

/**
 * @author wanyu
 * @createTime 2022-03-06 0:10
 */
public class book {
    private String SN;
    private String name;
    private double price;
    private String author;

    @Override
    public String toString() {
        return "book{" +
                "SN='" + SN + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }

    public book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }
}
