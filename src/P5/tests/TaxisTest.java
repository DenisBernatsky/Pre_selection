package P5.tests;
import P5.cars.BaseCar;
import P5.data.CarsDataSQL;
import P5.data.CarsDataXML;
import P5.taxis.Taxis;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class TaxisTest extends BaseTest{
    private static final String FILE_XML_NAME = "Data.xml";
    private Taxis taxis;
    private ArrayList<BaseCar> taxisCarsListXMLAndDB = null;

    @BeforeTest
    public void testSetup(){
        taxis = new Taxis();
        CarsDataXML data = new CarsDataXML(FILE_XML_NAME);
        CarsDataSQL dataSQL = new CarsDataSQL();
        ArrayList<BaseCar> taxisCarsListXml = data.getCarListFromEntity();
        ArrayList<BaseCar>  taxisCarsListDB = dataSQL.getCarListFromEntity();
        taxisCarsListXMLAndDB = taxisCarsListXml;
        taxisCarsListXMLAndDB.addAll(taxisCarsListDB);
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
            Assert.assertTrue(min < car.getPrice(), "Cars price less than min price."+ "\n Min price: " + min + "\n Actual result: "  + car.getPrice() + "\n");
            Assert.assertTrue(car.getPrice() < max, "Cars price more than max price."+ "\n Max price: " + max + "\n Actual result: "  + car.getPrice() + "\n");
        }
    }


}
