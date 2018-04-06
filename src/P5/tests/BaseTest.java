package P5.tests;

import P5.cars.BaseCar;
import P5.data.CarsDataSQL;
import P5.data.CarsDataXML;
import P5.taxis.Taxis;
import P5.utils.DBConnections;
import P5.utils.ListUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;

public class BaseTest {
    private static final String FILE_XML_NAME = "Data.xml";
    static Taxis taxis;
    static ArrayList<BaseCar> taxisCarsListXMLAndDB;
    CarsDataSQL dataSQL;

    @BeforeSuite
    public void SuiteSetup(){
        ListUtils listUtils = new ListUtils();
        taxis = new Taxis();
        dataSQL = new CarsDataSQL();
        CarsDataXML dataXML = new CarsDataXML(FILE_XML_NAME);

        ArrayList<BaseCar> taxisCarsListXml = dataXML.getCarListFromEntity();
        ArrayList<BaseCar> taxisCarsListDB = dataSQL.getCarListFromEntity();
        taxisCarsListXMLAndDB = listUtils.joinLists(taxisCarsListXml, taxisCarsListDB);
    }

    @AfterSuite
    public void SuiteDown(){
        DBConnections.closeConnection();
    }
}
