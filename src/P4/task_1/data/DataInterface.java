package P4.task_1.data;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface DataInterface {

    int getId() throws ParserConfigurationException, IOException, SAXException;
    int getPrice();
    int getConsumption();
    String getName();
    String getType();
}
