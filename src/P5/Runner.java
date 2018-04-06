package P5;

import P5.cars.BaseCar;
import P5.data.CarsDataSQL;
import P5.data.CarsDataXML;
import P5.taxis.Taxis;
import P5.utils.ReadAndWriteInFileUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Runner {

    private static final String FILE_XML_NAME = "Data.xml";
    private static final String FILE_TXT_NAME = "notes.txt";

    public static void main(String[] args) throws SQLException {
        CarsDataXML data = new CarsDataXML(FILE_XML_NAME);
        CarsDataSQL dataSQL = new CarsDataSQL();
        Taxis taxis = new Taxis();
        ReadAndWriteInFileUtils readAndWriteInFile = new ReadAndWriteInFileUtils();

        // XMl get data
        ArrayList<BaseCar> taxisCarsListXML = data.getCarListFromEntity();
        taxis.getAllCarsInfo(taxisCarsListXML);
        taxis.getAllCarsPrice(taxisCarsListXML);
        int CarsPriceXML = taxis.getAllCarsPrice(taxis.searchByPrice(10000, 13000, taxisCarsListXML));

        // SQL get data
        ArrayList<BaseCar> taxisCarsListDB = dataSQL.getCarListFromEntity();

        taxis.getAllCarsInfo(taxisCarsListDB);
        taxis.getAllCarsPrice(taxisCarsListDB);
        int CarsPriceDB  = taxis.getAllCarsPrice(taxis.searchByPrice(10000, 19000, taxisCarsListDB));

        // Write in txt file
        readAndWriteInFile.writeInFile(FILE_TXT_NAME, CarsPriceDB + " DB" + "\n" + CarsPriceXML + " XML");

        // Read from txt file
        try {
            System.out.println(readAndWriteInFile.getTextFromFile(FILE_TXT_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
