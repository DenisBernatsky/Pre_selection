package P4.task_1.utils;

import org.w3c.dom.Node;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class Record {

    private Node node;

    Record(Node node) {
        this.node = node;
    }

    public String findByXpath(String xpathExpression) {
        try {
            XPath xpath = XPathFactory.newInstance().newXPath();
            Node node1 = (Node) xpath.evaluate(xpathExpression, node, XPathConstants.NODE);
            return node1.getTextContent();
        } catch(Exception e) {
            e.getMessage();
        }
        return "";
    }
}
