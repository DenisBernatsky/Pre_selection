package P4.task_1.data;

import P4.task_1.cars.BaseCar;
import P4.task_1.cars.MinibusCar;
import P4.task_1.cars.PassengerCar;
import P4.task_1.cars.Truck;
import P4.task_1.utils.XpathUtils;
import P4.task_1.utils.XmlReaderUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;


public class CarsDataXML implements DataInterface{
    
    private static final String REX_EXP_FORMAT = "//items/car[@id='%s']";
    private static final String LOCATOR_ALL_CARS = "//items";
    private static final String LOCATOR_ID = REX_EXP_FORMAT + "//id";
    private static final String LOCATOR_NAME = REX_EXP_FORMAT + "//name";
    private static final String LOCATOR_TYPE = REX_EXP_FORMAT + "//type";
    private static final String LOCATOR_CONSUMPTION = REX_EXP_FORMAT + "//consumption";
    private static final String LOCATOR_PRICE = REX_EXP_FORMAT + "//price";
    private String filePath;

    public CarsDataXML(String filePath) {
        this.filePath = filePath;
    }
    
    public Object createCar(String id) {
        XpathUtils info = (new XmlReaderUtils(filePath)).getNode(LOCATOR_ALL_CARS);
        BaseCar car = createCarByType(info, id);
        car.setId((Integer.parseInt(info.findByXpath(String.format(LOCATOR_ID, id)))));
        car.setCarName((info.findByXpath(String.format(LOCATOR_NAME, id))));
        car.setCarType((info.findByXpath(String.format(LOCATOR_TYPE, id))));
        car.setConsumption((Integer.parseInt(info.findByXpath(String.format(LOCATOR_CONSUMPTION, id)))));
        car.setPrice((Integer.parseInt(info.findByXpath(String.format(LOCATOR_PRICE, id)))));
        return car;
    }

    private BaseCar createCarByType(XpathUtils info, String id){
        switch (info.findByXpath(String.format(LOCATOR_TYPE, id))){
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
    public ArrayList<BaseCar> getCarListFromXml() {
        int carValuesCount = (new XmlReaderUtils(filePath)).getNumberOfNodes("//items/car");
        ArrayList<BaseCar> taxisCarsList = new ArrayList<>();
        for (int i=1; i < carValuesCount+1; i++){
            BaseCar car = (BaseCar) createCar(Integer.toString(i));
            taxisCarsList.add(car);
        }
        return taxisCarsList;
    }

    @Override
    public int getId() throws ParserConfigurationException, IOException, SAXException {
        return 0;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getConsumption() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }
}
