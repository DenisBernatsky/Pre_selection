package runners;

import listeners.Listener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG tng = new TestNG();
        tng.addListener(tla);
        tng.addListener(new Listener());

        XmlSuite suite = new XmlSuite();
        suite.setName("Test Suite");

        List<String> files = new ArrayList<>(new ArrayList<String>() {{
            add("./src/main/resources/TaxisTestData.xml");
        }});
        suite.setSuiteFiles(files);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        tng.setXmlSuites(suites);

        tng.run();
    }


}
