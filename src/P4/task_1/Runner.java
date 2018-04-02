package P4.task_1;

import P4.task_1.cars.BaseCar;
import P4.task_1.data.CarsDataXML;
import P4.task_1.taxis.Taxis;

import java.util.ArrayList;

public class Runner {

    private static final String FILE_NAME = "Data.xml";

    public static void main(String[] args) {
        CarsDataXML data = new CarsDataXML(FILE_NAME);
        Taxis taxis = new Taxis();
        ArrayList<BaseCar> taxisCarsList = data.getCarListFromXml();
        taxis.getAllCarsInfo(taxisCarsList);

        taxis.getAllCarsPrice(taxisCarsList);

        taxis.getAllCarsPrice(taxis.searchByPrice(1000, 13000, taxisCarsList));


    }



}
