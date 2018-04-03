package P4.task_1;

import P4.task_1.cars.BaseCar;
import P4.task_1.data.CarsDataSQL;
import P4.task_1.data.CarsDataXML;
import P4.task_1.taxis.Taxis;
import P4.task_1.utils.ReadAndWriteInFileUtils;

import java.io.IOException;
import java.util.ArrayList;

public class Runner {

    private static final String FILE_XML_NAME = "Data.xml";
    private static final String FILE_TXT_NAME = "notes.txt";

    public static void main(String[] args) {
        CarsDataXML data = new CarsDataXML(FILE_XML_NAME);
        CarsDataSQL dataSQL = new CarsDataSQL();
        Taxis taxis = new Taxis();
        ReadAndWriteInFileUtils readAndWriteInFile = new ReadAndWriteInFileUtils();

        // XMl get data
        ArrayList<BaseCar> taxisCarsListXML = data.getCarListFromEntity();
        taxis.getAllCarsInfo(taxisCarsListXML);
        taxis.getAllCarsPrice(taxisCarsListXML);
        String CarsPriceXML = taxis.getAllCarsPrice(taxis.searchByPrice(1000, 13000, taxisCarsListXML));

        // SQL get data
        ArrayList<BaseCar> taxisCarsListDB = dataSQL.getCarListFromEntity();
        taxis.getAllCarsInfo(taxisCarsListDB);
        taxis.getAllCarsPrice(taxisCarsListDB);
        String CarsPriceDB  = taxis.getAllCarsPrice(taxis.searchByPrice(10000, 19000, taxisCarsListDB));

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
