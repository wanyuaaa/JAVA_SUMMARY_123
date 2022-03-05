package xml_test;

import jdk.jfr.Name;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author wanyu
 * @createTime 2022-03-06 0:13
 */
public class xml_read {
    @Test
    public void test1() throws DocumentException {
        //1.读取xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        //2.通过document对象获取根元素
        Element rootElement = document.getRootElement();
        //3.通过根元素获取book标签对象
        List<Element> book = rootElement.elements("book");

        for(Element e : book){
            //System.out.println(e.asXML());
            Element name = e.element("name");
            String nameText = name.getText();
            Element price = e.element("price");
            Double priceText = Double.valueOf(price.getText());
            Element author = e.element("author");
            String authorText = author.getText();

            System.out.println(new book(nameText,priceText,authorText).toString());
        }
    }
}
