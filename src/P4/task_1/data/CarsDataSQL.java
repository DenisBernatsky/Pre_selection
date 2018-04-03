package P4.task_1.data;

import P4.task_1.cars.BaseCar;
import P4.task_1.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CarsDataSQL extends BaseData implements DataInterface{
    private DBUtils dbUtils = new DBUtils();
    private static final String STR_TYPE = "TYPE";
    private static final String STR_NAME = "NAME";
    private static final String STR_PRICE = "PRICE";
    private static final String STR_CONSUMPTION = "CONSUMPTION";
    private static final String STR_ID = "ID";
    private static final String SQL_ALL_VALUES = "SELECT * FROM CARS";

    public ArrayList<BaseCar> getCarListFromEntity() {
        ArrayList<HashMap<String, String>> mapListAllDBCars = null;
        try {
            mapListAllDBCars = getListMapFromDb();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseCar car = null;
        ArrayList<BaseCar> carList = new ArrayList<>();
        for (HashMap<String, String> map : Objects.requireNonNull(mapListAllDBCars)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equals(STR_TYPE)){
                    car = createCarByType(entry.getValue());
                        for (Map.Entry<String, String> dict : map.entrySet()){
                            if (dict.getKey().equals(STR_TYPE)){
                                car.setCarType(dict.getValue());}
                            if (dict.getKey().equals(STR_NAME)){
                                car.setCarName(dict.getValue());}
                            if (dict.getKey().equals(STR_PRICE)){
                                car.setPrice(Integer.parseInt(dict.getValue()));}
                            if (dict.getKey().equals(STR_CONSUMPTION)){
                                car.setConsumption(Integer.parseInt(dict.getValue()));}
                            if (dict.getKey().equals(STR_ID)){
                                car.setId(Integer.parseInt(dict.getValue()));
                            }
                        }
                }
            }
            carList.add(car);
        }
        return carList;
    }

    private ArrayList<HashMap<String, String>> getListMapFromDb() throws SQLException {
        ResultSet result = dbUtils.getStatement(SQL_ALL_VALUES);
        ArrayList<HashMap<String, String>> mapListAllDBCars = new ArrayList<>();
        ResultSetMetaData metaData = result.getMetaData();
        HashMap <String, String> dbResult = new HashMap<>();
        while (result.next()){
            for (int i = 1; i <= metaData.getColumnCount(); i++ ) {
            dbResult.put(metaData.getColumnName(i), result.getString(i));
            }
            mapListAllDBCars.add(dbResult);
        }
        result.close();
        return mapListAllDBCars;
    }

}
