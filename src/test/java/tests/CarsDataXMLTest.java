package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class CarsDataXMLTest extends BaseTest {

    @Test
    public void testGetCarListFromEntity() {
        assertTrue(!dataXML.getCarListFromEntity().isEmpty(), "List is empty");
    }

}