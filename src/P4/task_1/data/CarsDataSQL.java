package P4.task_1.data;

import P4.task_1.cars.BaseCar;
import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.*;
import java.util.ArrayList;

public class CarsDataSQL extends BaseData implements DataInterface{

    private static final String DB_NAME = "taxis";
    private static final String DB_URL = "jdbc:derby:" + DB_NAME;
    private static final String DB_LOGIN = "admin";
    private static final String DB_PASSWORD = "admin";
    private static final String SQL_ALL_VALUES = "SELECT TYPE, NAME, PRICE, CONSUMPTION, ID FROM CARS";
    private static final String DB_CREATE_URL = String.format("jdbc:derby:%s;create=true;user=%s;password=%s", DB_NAME, DB_LOGIN, DB_PASSWORD);

    private static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
    }

    public ArrayList<BaseCar> getCarListFromEntity() throws SQLException {
        Connection connection = getConnection();
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
    return carList;
    }

    public void createDB(){
        if (!checkBdConnect()){
            Connection connection = null;
            try {
                DriverManager.registerDriver(new EmbeddedDriver());
                connection = DriverManager.getConnection(DB_CREATE_URL);
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
            finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            System.out.println("Data base already exist");
        }
    }

    private boolean checkBdConnect(){
        Connection con;
        try {
            con = getConnection();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
