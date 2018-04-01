package P4.task_1.utils;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XmlReader{

    private final File file;
    public XmlReader(String file) {
        this.file =  new File(file);
    }

    public Record getNode(String xpathExpression) {
        try {
            InputStream inputStream = new FileInputStream(file);
            InputSource inputSource = new InputSource(inputStream);
            XPath xpath = XPathFactory.newInstance().newXPath();
            return new Record((Node) xpath.evaluate(xpathExpression, inputSource, XPathConstants.NODE));
        } catch (FileNotFoundException | XPathExpressionException e) {
            e.getMessage();
        }
        throw new AssertionError(String.format("Cannot find node by xpath '%s' in file: %s", xpathExpression, file));
    }

    public int getNumberOfNodes(String xpathExpression) {
        try {
            InputStream inputStream = new FileInputStream(file);
            InputSource inputSource = new InputSource(inputStream);
            XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList nodes = (NodeList) xpath.evaluate(xpathExpression, inputSource, XPathConstants.NODESET);
            return nodes.getLength();
        } catch (FileNotFoundException | XPathExpressionException e) {
            e.getMessage();
        }
        return 0;
    }
}
