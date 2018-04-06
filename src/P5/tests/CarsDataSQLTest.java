package P5.tests;

import P5.data.CarsDataSQL;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CarsDataSQLTest extends BaseTest {
    private CarsDataSQL dataSQL;

    @BeforeTest
    public void testSetup(){
        dataSQL = new CarsDataSQL();
    }

    @Test
    public void testGetCarListFromEntity(){
        assertTrue(!dataSQL.getCarListFromEntity().isEmpty(), "List is empty");
    }

}