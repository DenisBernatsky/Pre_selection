package P4.task_1.utils;

import P4.task_1.data.DataInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlReader  implements DataInterface{

    private String file;
    private DocumentBuilderFactory inst = DocumentBuilderFactory.newInstance();

    public XmlReader(String file) {
        this.file = file;
    }


    @Override
    public int getId() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder inst = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = inst.parse(new File("Data.xml"));
        document.normalizeDocument();
        Node root = document.getDocumentElement();
        NodeList list = root.getChildNodes();
        NodeList nodeList = document.getElementsByTagName("car");
        for (int i = 0; i < nodeList.getLength(); i++) {
            // Выводим информацию по каждому из найденных элементов
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String consumption = element.getElementsByTagName("consumption").item(0).getTextContent();



        }
        return 0;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getConsumption() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }
}
