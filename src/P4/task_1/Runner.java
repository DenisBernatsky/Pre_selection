package P4.task_1;

import P3.task_1_new.utils.ReadAndWriteInFile;
import P4.task_1.cars.BaseCar;
import P4.task_1.data.CarsDataSQL;
import P4.task_1.data.CarsDataXML;
import P4.task_1.taxis.Taxis;

import java.util.ArrayList;

public class Runner {

    private static final String FILE_XML_NAME = "Data.xml";
    private static final String FILE_TXT_NAME = "notes.txt";

    public static void main(String[] args) {
        CarsDataXML data = new CarsDataXML(FILE_XML_NAME);
        CarsDataSQL dataSQL = new CarsDataSQL();
        Taxis taxis = new Taxis();
        ReadAndWriteInFile readAndWriteInFile = new ReadAndWriteInFile();
        ArrayList<BaseCar> taxisCarsList = data.getCarListFromEntity();
        taxis.getAllCarsInfo(taxisCarsList);

        taxis.getAllCarsPrice(taxisCarsList);

        taxis.getAllCarsPrice(taxis.searchByPrice(1000, 13000, taxisCarsList));

        ArrayList<BaseCar> taxisCarsListDB = dataSQL.getCarListFromEntity();
        taxis.getAllCarsPrice(taxisCarsListDB);
        readAndWriteInFile.writeInFile(FILE_TXT_NAME, taxis.getAllCarsPrice(taxisCarsListDB));

    }



}
