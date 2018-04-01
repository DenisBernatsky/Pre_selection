package P4.task_1;

import P4.task_1.cars.BaseCar;
import P4.task_1.data.CarsDataXML;
import P4.task_1.utils.XmlReader;

import java.util.ArrayList;

public class Runner {

    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {

        int dataId = 2;
        CarsDataXML data = new CarsDataXML();

        int carValuesCount = (new XmlReader("Data.xml")).getNumberOfNodes("//items/car");
        ArrayList<BaseCar> taxisCarsList = new ArrayList<>();
        for (int i=1; i < carValuesCount+1; i++){
            BaseCar car = (BaseCar) data.transformData(Integer.toString(i), "Data.xml");
            taxisCarsList.add(car);
        }

        System.out.println(taxisCarsList.get(4).getCarName());

    }



}
