package P4.task_1.data;

import P4.task_1.cars.BaseCar;
import P4.task_1.utils.Record;
import P4.task_1.utils.XmlReader;


public class CarsDataXML {

    public Object transformData(String id, String filePath) {
        Record info = (new XmlReader(filePath)).getNode("//items");
        String rexExpFormat = "//items/car[@id='%s']";
        BaseCar car = new BaseCar();
        car.setId((Integer.parseInt(info.findByXpath(String.format(rexExpFormat + "//id", id)))));
        car.setCarName((info.findByXpath(String.format(rexExpFormat + "//name", id))));
        car.setCarType((info.findByXpath(String.format(rexExpFormat + "//type", id))));
        car.setConsumption((Integer.parseInt(info.findByXpath(String.format(rexExpFormat + "//consumption", id)))));
        car.setPrice((Integer.parseInt(info.findByXpath(String.format(rexExpFormat + "//price", id)))));
        return car;
    }


}
