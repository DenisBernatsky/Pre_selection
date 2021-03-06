package P5.data;

import P5.cars.BaseCar;
import P5.enums.CarsDataDBEnum;
import P5.utils.DBConnections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CarsDataSQL extends BaseData implements DataInterface {


    private static final String SQL_ALL_VALUES = "SELECT TYPE, NAME, PRICE, CONSUMPTION, ID FROM CARS";

    public ArrayList<BaseCar> getCarListFromEntity() {
        Connection connection = DBConnections.getConnection();
        Statement statement;

        ArrayList<BaseCar> carList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SQL_ALL_VALUES);
            String carName;
            String carType;
            int consumption;
            int id;
            int price;
            BaseCar car;

            while (result.next()) {
                carName = result.getString(CarsDataDBEnum.NAME.getColumnName());
                carType = result.getString(CarsDataDBEnum.TYPE.getColumnName());
                id = result.getInt(CarsDataDBEnum.ID.getColumnName());
                consumption = result.getInt(CarsDataDBEnum.CONSUMPTION.getColumnName());
                price = result.getInt(CarsDataDBEnum.PRICE.getColumnName());
                car = createCarByType(carType, carName, consumption, price);
                car.setId(id);
                carList.add(car);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public void createDB(){
        Connection connection;
        try {
            connection = DBConnections.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE cars (ID int GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "NAME varchar(255), TYPE varchar(255), CONSUMPTION varchar(255),  PRICE varchar(255))");
            statement.addBatch("INSERT INTO cars (NAME, TYPE, CONSUMPTION, PRICE) VALUES ('Volvo', 'Passenger Car', '7', '14500')");
            statement.addBatch("INSERT INTO cars (NAME, TYPE, CONSUMPTION, PRICE) VALUES ('Citroen', 'Minibus Car', '12', '25500')");
            statement.addBatch("INSERT INTO cars (NAME, TYPE, CONSUMPTION, PRICE) VALUES ('LADA', 'Minibus Car', '14', '26500')");
            statement.addBatch("INSERT INTO cars (NAME, TYPE, CONSUMPTION, PRICE) VALUES ('VAZ', 'Truck', '22', '95080')");
            statement.addBatch("INSERT INTO cars (NAME, TYPE, CONSUMPTION, PRICE) VALUES ('Mazda', 'Passenger Car', '11', '8700')");
            statement.addBatch("INSERT INTO cars (NAME, TYPE, CONSUMPTION, PRICE) VALUES ('Volvo', 'Passenger Car', '7', '12500')");
            statement.addBatch("INSERT INTO cars (NAME, TYPE, CONSUMPTION, PRICE) VALUES ('Citroen', 'Minibus Car', '12', '16500')");
            statement.addBatch("INSERT INTO cars (NAME, TYPE, CONSUMPTION, PRICE) VALUES ('LADA', 'Minibus Car', '14', '6500')");
            statement.addBatch("INSERT INTO cars (NAME, TYPE, CONSUMPTION, PRICE) VALUES ('MAN', 'Truck', '24', '45080')");
            statement.addBatch("INSERT INTO cars (NAME, TYPE, CONSUMPTION, PRICE) VALUES ('Mazda', 'Passenger Car', '11', '12700')");
            statement.executeBatch();
            connection.commit();
            System.out.println("Data base is created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
