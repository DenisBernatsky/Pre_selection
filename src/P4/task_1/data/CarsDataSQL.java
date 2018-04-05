package P4.task_1.data;

import P4.task_1.cars.BaseCar;
import P4.task_1.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarsDataSQL extends BaseData implements DataInterface{
    private DBUtils dbUtils = new DBUtils();
    private static final String STR_TYPE = "TYPE";
    private static final String STR_NAME = "NAME";
    private static final String STR_PRICE = "PRICE";
    private static final String STR_CONSUMPTION = "CONSUMPTION";
    private static final String STR_ID = "ID";
    private static final String SQL_ALL_VALUES = "SELECT * FROM CARS";

    public ArrayList<BaseCar> getCarListFromEntity() throws SQLException {
        ResultSet result = dbUtils.getStatement(SQL_ALL_VALUES);
        ArrayList<BaseCar> carList = new ArrayList<>();

        String carName;
        String carType;
        int consumption;
        int id;
        int price;
        BaseCar car = null;

        while (result.next()){
            carName = result.getString(STR_NAME);
            carType = result.getString(STR_TYPE);
            id = result.getInt(STR_ID);
            consumption = result.getInt(STR_CONSUMPTION);
            price = result.getInt(STR_PRICE);
            car = createCarByType(carType, carName, consumption, price);
            car.setId(id);
            carList.add(car);
        }
    return carList;
    }

}
