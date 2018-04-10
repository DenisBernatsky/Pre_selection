package tests;

import P5.cars.BaseCar;
import dataProvider.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TaxisTest extends BaseTest {

    @BeforeTest
    public void testSetup(){
    }

    @Test
    @Parameters({"expect"})
    public void testPrice(int expect){
        Assert.assertEquals(taxis.getAllCarsPrice(taxisCarsListXMLAndDB), expect, "Cars price is not equals");
    }

    @Test(dataProvider = "testSearchDataProvider", dataProviderClass = TestDataProvider.class)
    public void testSearch(int min, int max){
        taxis.searchByPrice(min, max, taxisCarsListXMLAndDB);
        for (BaseCar car: taxis.searchByPrice(min, max, taxisCarsListXMLAndDB)) {
            Assert.assertTrue(min <= car.getPrice() && car.getPrice() <= max,
                    "Cars price is not correct for car_id = " + car.getId() +
                    "\n Expected min price: " + min + "\n" + "Expected max price: " + max + "\n Actual price: "  + car.getPrice() );
        }
    }

    @Test(expectedExceptions = AssertionError.class)
    @Parameters({"min", "max"})
    public void testSearchNegative(int min, int max){
        for (BaseCar car: taxis.searchByPrice(min, max, taxisCarsListXMLAndDB)) {
            Assert.assertTrue(min > car.getPrice() && car.getPrice() > max,
                    "Cars price is not correct for car_id = " + car.getId() +
                    "\n Expected min price: " + min + "\n" + "Expected max price: " + max + "\n Actual price: "  + car.getPrice());
        }
    }



}
