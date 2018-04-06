package P5.tests;
import P5.cars.BaseCar;
import P5.data.CarsDataXML;
import P5.taxis.Taxis;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TaxisTest {
    private static final String FILE_XML_NAME = "Data.xml";
    Taxis taxis = new Taxis();
    CarsDataXML data = new CarsDataXML(FILE_XML_NAME);
    ArrayList<BaseCar> taxisCarsListXML = data.getCarListFromEntity();

    @Test
    @Parameters({"expect"})
    public void testPrice(int expect){
        int sum = taxis.getAllCarsPrice(taxisCarsListXML);
        Assert.assertEquals(sum, expect, "Cars price is not equals");
    }

    @Test
    @Parameters({"min", "max"})
    public void testSearch(int min, int max){
        ArrayList<BaseCar> list = taxis.searchByPrice(min, max, taxisCarsListXML);
        for (BaseCar car: list) {
            Assert.assertTrue(min < car.getPrice(), "Cars price less than min price."+ "\n Min price: " + min + "\n Actual result: "  + car.getPrice() + "\n");
            Assert.assertTrue(car.getPrice() < max, "Cars price more than max price."+ "\n Max price: " + max + "\n Actual result: "  + car.getPrice() + "\n");
        }
    }

}
