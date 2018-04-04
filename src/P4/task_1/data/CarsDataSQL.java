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

        String name = null;
        String type = null;
        int price = 0;
        int consumption = 0;
        int id = 0;
        BaseCar car = null;

        ArrayList<BaseCar> carList = new ArrayList<>();
        for (HashMap<String, String> map : Objects.requireNonNull(mapListAllDBCars)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                switch (entry.getKey()) {
                    case STR_NAME:
                        name = entry.getValue();
                        break;
                    case STR_TYPE:
                        type = entry.getValue();
                        break;
                    case STR_PRICE:
                        price = Integer.parseInt(entry.getValue());
                        break;
                    case STR_CONSUMPTION:
                        consumption = Integer.parseInt(entry.getValue());
                        break;
                    case STR_ID:
                        id = Integer.parseInt(entry.getValue());
                        break;
                }
            }
            car = createCarByType(type, name, consumption, price);
            car.setId(id);
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
            String carName;
            String carType;
            int consumption;
            int id;
            int price;

            for (int i = 1; i < metaData.getColumnCount(); i++ ) {

                switch (metaData.getColumnName(i)) {
                    case STR_NAME:
                        carName = result.getString(i);
                        break;
                    case STR_TYPE:
                        carType = result.getString(i);
                        break;
                    case STR_PRICE:
                        price = Integer.parseInt(result.getString(i));
                        break;
                    case STR_CONSUMPTION:
                        consumption = Integer.parseInt(result.getString(i));
                        break;
                    case STR_ID:
                        id = Integer.parseInt(result.getString(i));
                        break;
                }

                String a = metaData.getColumnName(i);
                String d = result.getString(i);

                dbResult.put(metaData.getColumnName(i), result.getString(i));
            }
            mapListAllDBCars.add(dbResult);
        }
        result.close();
        return mapListAllDBCars;
    }

}
