import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            try {
                try{
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    factory.setNamespaceAware(true); //включаем поддержку пространств имён
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document doc = builder.parse("foods.xml"); //создание объекта документа

                    Element documentElement = doc.getDocumentElement(); //возвращает элемент документа

                    if ("foods".equals(documentElement.getTagName())) {
                        NodeList elementsByTagName = documentElement.getElementsByTagName("food"); //дочерние элементы
                        for (int i = 0; i < elementsByTagName.getLength(); ++i) {
                            Element element = (Element) elementsByTagName.item(i);
                            String shop = null, name = null, maker = null, group = null, composition = null, price = null;
                            NodeList props = element.getElementsByTagName("*"); // дочерние элементы
                            for (int j = 0; j < props.getLength(); ++j) { //кол-во дочерних узлов
                                Element prop = (Element) props.item(j);
                                if ("shop".equals(prop.getTagName())) { //имя данного элемента
                                    shop = prop.getTextContent();
                                } else if ("name".equals(prop.getTagName())) {
                                    name =prop.getTextContent();
                                }
                                else if ("maker".equals(prop.getTagName())) {
                                    maker =prop.getTextContent();
                                }
                                else if ("group".equals(prop.getTagName())) {
                                    group = prop.getTextContent();
                                }
                                else if ("composition".equals(prop.getTagName())) {
                                    composition= prop.getTextContent();
                                    price = prop.getAttribute("price");

                                }
                            }
                            Food food = Food.initialize().setShop(shop).setName(name).setMaker(maker).setGroup(group).setComposition(composition).setPrice(price);
                            food.print();
                        }
                    }
                }catch (ParserConfigurationException exc){
                    exc.printStackTrace();
                }
            }catch (SAXException exc){
                exc.printStackTrace();
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
