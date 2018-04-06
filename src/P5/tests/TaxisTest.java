package P5.tests;

import P5.cars.BaseCar;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TaxisTest extends BaseTest{

    @BeforeTest
    public void testSetup(){
    }

    @Test
    @Parameters({"expect"})
    public void testPrice(int expect){
        Assert.assertEquals(taxis.getAllCarsPrice(taxisCarsListXMLAndDB), expect, "Cars price is not equals");
    }

    @Test
    @Parameters({"min", "max"})
    public void testSearch(int min, int max){
        for (BaseCar car: taxis.searchByPrice(min, max, taxisCarsListXMLAndDB)) {
            Assert.assertTrue(min <= car.getPrice(), "Cars price less than min price."+ "\n Min price: " + min + "\n Actual result: "  + car.getPrice() + "\n");
            Assert.assertTrue(car.getPrice() <= max, "Cars price more than max price."+ "\n Max price: " + max + "\n Actual result: "  + car.getPrice() + "\n");
        }
    }


}
