package P5.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CarsDataSQLTest extends BaseTest {

    @Test
    public void testGetCarListFromEntity(){
        assertTrue(!dataSQL.getCarListFromEntity().isEmpty(), "List is empty");
    }

}