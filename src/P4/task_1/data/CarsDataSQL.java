package P4.task_1.data;

import P4.task_1.cars.BaseCar;

import java.sql.*;
import java.util.ArrayList;

public class CarsDataSQL extends BaseData implements DataInterface{

    private static final String DB_NAME = "taxis";
    private static final String DB_URL = "jdbc:derby:" + DB_NAME;
    private static final String DB_LOGIN = "admin";
    private static final String DB_PASSWORD = "admin";
    private static final String SQL_ALL_VALUES = "SELECT * FROM CARS";

    public ArrayList<BaseCar> getCarListFromEntity() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SQL_ALL_VALUES);
        ArrayList<BaseCar> carList = new ArrayList<>();

        String carName;
        String carType;
        int consumption;
        int id;
        int price;
        BaseCar car;

        while (result.next()){
            carName = result.getString(CarsDataDBEnum.NAME.getColumnName());
            carType = result.getString(CarsDataDBEnum.TYPE.getColumnName());
            id = result.getInt(CarsDataDBEnum.ID.getColumnName());
            consumption = result.getInt(CarsDataDBEnum.CONSUMPTION.getColumnName());
            price = result.getInt(CarsDataDBEnum.PRICE.getColumnName());
            car = createCarByType(carType, carName, consumption, price);
            car.setId(id);
            carList.add(car);
        }
        connection.close();
        statement.close();
    return carList;
    }

}
