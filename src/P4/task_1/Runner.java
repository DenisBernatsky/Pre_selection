package P4.task_1;

import P4.task_1.cars.BaseCar;
import P4.task_1.data.CarsDataXML;
import P4.task_1.taxis.Taxis;
import P4.task_1.utils.XmlReader;

import java.util.ArrayList;

public class Runner {

    private static final String FILE_NAME = "Data.xml";

    public static void main(String[] args) {
        CarsDataXML data = new CarsDataXML();
        Taxis taxis = new Taxis();
        ArrayList<BaseCar> taxisCarsList = data.getCarListFromXml(FILE_NAME);

        for (BaseCar car: taxisCarsList) {
            System.out.println(car.getCarName() + " " + car.getCarType() + " " + car.getPrice());

        }
        taxis.getAllCarsPrice(taxisCarsList);

    }



}
