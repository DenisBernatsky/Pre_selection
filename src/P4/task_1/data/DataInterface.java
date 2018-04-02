package P4.task_1.data;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface DataInterface {

    int getId(String id) throws ParserConfigurationException, IOException, SAXException;
    int getPrice(String id);
    int getConsumption(String id);
    String getName(String id);
    String getType(String id);
}
