package P4.data;

import P4.cars.BaseCar;
import P4.utils.XmlReaderUtils;
import P4.utils.XpathUtils;

import java.util.ArrayList;


public class CarsDataXML extends BaseData implements DataInterface{
    
    private static final String REX_EXP_FORMAT = "//items/car[@id='%s']";
    private static final String LOCATOR_ALL_ITEMS = "//items";
    private static final String LOCATOR_ID = REX_EXP_FORMAT + "//id";
    private static final String LOCATOR_NAME = REX_EXP_FORMAT + "//name";
    private static final String LOCATOR_TYPE = REX_EXP_FORMAT + "//type";
    private static final String LOCATOR_CONSUMPTION = REX_EXP_FORMAT + "//consumption";
    private static final String LOCATOR_PRICE = REX_EXP_FORMAT + "//price";
    private static final String LOCATOR_ALL_CARS = "//items/car";
    private String filePath;
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public CarsDataXML(String filePath) {
        this.filePath = filePath;
    }
    
    private BaseCar createCar(String id) {
        setId(id);
        XpathUtils info = (new XmlReaderUtils(filePath)).getNode(LOCATOR_ALL_ITEMS);
        BaseCar car = createCarByType(info.findByXpath(String.format(LOCATOR_TYPE, id)), getName(), getConsumption(), getPrice());
        car.setId(getId());
        return car;
    }

    public ArrayList<BaseCar> getCarListFromEntity() {
        int carValuesCount = (new XmlReaderUtils(filePath)).getNumberOfNodes(LOCATOR_ALL_CARS);
        ArrayList<BaseCar> taxisCarsList = new ArrayList<>();
        for (int i=1; i < carValuesCount+1; i++){
            BaseCar car = createCar(Integer.toString(i));
            taxisCarsList.add(car);
        }
        return taxisCarsList;
    }

    public int getId(){
        XpathUtils info = (new XmlReaderUtils(filePath)).getNode(LOCATOR_ALL_ITEMS);
        return (Integer.parseInt(info.findByXpath(String.format(LOCATOR_ID, id))));
    }

    public int getPrice() {
        XpathUtils info = (new XmlReaderUtils(filePath)).getNode(LOCATOR_ALL_ITEMS);
        return Integer.parseInt(info.findByXpath(String.format(LOCATOR_PRICE, id)));
    }

    public int getConsumption() {
        XpathUtils info = (new XmlReaderUtils(filePath)).getNode(LOCATOR_ALL_ITEMS);
        return Integer.parseInt(info.findByXpath(String.format(LOCATOR_CONSUMPTION, id)));
    }

    public String getName() {
        XpathUtils info = (new XmlReaderUtils(filePath)).getNode(LOCATOR_ALL_ITEMS);
        return info.findByXpath(String.format(LOCATOR_NAME, id));
    }

    public String getType() {
        XpathUtils info = (new XmlReaderUtils(filePath)).getNode(LOCATOR_ALL_ITEMS);
        return info.findByXpath(String.format(LOCATOR_TYPE, id));
    }
}
