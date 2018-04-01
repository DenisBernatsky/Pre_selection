package P4.task_1.data;

import P4.task_1.cars.BaseCar;
import P4.task_1.cars.MinibusCar;
import P4.task_1.cars.PassengerCar;
import P4.task_1.cars.Truck;
import P4.task_1.utils.Record;
import P4.task_1.utils.XmlReader;

import java.util.ArrayList;


public class CarsDataXML {

    public Object createCar(String id, String filePath) {
        Record info = (new XmlReader(filePath)).getNode("//items");
        String rexExpFormat = "//items/car[@id='%s']";
        BaseCar car = createCarByType(info, rexExpFormat, id);
        car.setId((Integer.parseInt(info.findByXpath(String.format(rexExpFormat + "//id", id)))));
        car.setCarName((info.findByXpath(String.format(rexExpFormat + "//name", id))));
        car.setCarType((info.findByXpath(String.format(rexExpFormat + "//type", id))));
        car.setConsumption((Integer.parseInt(info.findByXpath(String.format(rexExpFormat + "//consumption", id)))));
        car.setPrice((Integer.parseInt(info.findByXpath(String.format(rexExpFormat + "//price", id)))));
        return car;
    }

    private BaseCar createCarByType(Record info, String rexExpFormat, String id){
        switch (info.findByXpath(String.format(rexExpFormat + "//type", id))){
            case "Passenger Car": {
                return new PassengerCar();}
            case "Minibus Car": {
                return new MinibusCar();}
            case "Truck": {
                return new Truck();}
            default:
                throw new NullPointerException("Check cars type");

        }
    }
    public ArrayList<BaseCar> getCarListFromXml(String filePath) {
        int carValuesCount = (new XmlReader(filePath)).getNumberOfNodes("//items/car");
        ArrayList<BaseCar> taxisCarsList = new ArrayList<>();
        for (int i=1; i < carValuesCount+1; i++){
            BaseCar car = (BaseCar) createCar(Integer.toString(i), filePath);
            taxisCarsList.add(car);
        }
        return taxisCarsList;
    }

}
