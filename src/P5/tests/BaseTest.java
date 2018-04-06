package P5.tests;

import P5.utils.DBConnections;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    @AfterSuite
    public void tearDown(){
        DBConnections.closeConnection();
    }
}
