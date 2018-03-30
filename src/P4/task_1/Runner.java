package P4.task_1;

import P4.task_1.cars.BaseCar;
import P4.task_1.data.CarsDataXML;

public class Runner {

    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {

        int dataId = 2;
        CarsDataXML data = new CarsDataXML();
        BaseCar car = (BaseCar) data.transformData(Integer.toString(dataId));
        System.out.println(car.getPrice());


    }



}
