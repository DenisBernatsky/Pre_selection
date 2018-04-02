package P4.task_1.data;

import P4.task_1.cars.BaseCar;
import P4.task_1.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarsDataSQL extends BaseData implements DataInterface{
    private DBUtils dbUtils = new DBUtils();


    public ArrayList<BaseCar> getCarListFromEntity() {
        ArrayList<HashMap<String, String>> mapListAllDBCars = getListMapFromDb();
        BaseCar car = null;
        ArrayList<BaseCar> carList = new ArrayList<>();
        for (HashMap<String, String> map : mapListAllDBCars) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equals("TYPE")){
                    car = createCarByType(entry.getValue());
                        for (Map.Entry<String, String> dict : map.entrySet()){
                            if (dict.getKey().equals("TYPE")){
                                car.setCarType(dict.getValue());}
                            if (dict.getKey().equals("NAME")){
                                car.setCarName(dict.getValue());}
                            if (dict.getKey().equals("PRICE")){
                                car.setPrice(Integer.parseInt(dict.getValue()));}
                            if (dict.getKey().equals("CONSUMPTION")){
                                car.setConsumption(Integer.parseInt(dict.getValue()));}
                            if (dict.getKey().equals("ID")){
                                car.setId(Integer.parseInt(dict.getValue()));
                            }
                        }
                }
            }
            carList.add(car);
        }

        return carList;
    }

    private ArrayList<HashMap<String, String>> getListMapFromDb(){
        ResultSet result = dbUtils.getStatement("SELECT * FROM CARS");
        ArrayList<HashMap<String, String>> mapListAllDBCars = new ArrayList<>();
        try {
            ResultSetMetaData metaData = result.getMetaData();
            while (result.next()){
                HashMap <String, String> dbResult = new HashMap<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++ ) {
                      dbResult.put(metaData.getColumnName(i), result.getString(i));
                   }
                mapListAllDBCars.add(dbResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
                }
        return mapListAllDBCars;
    }

}
