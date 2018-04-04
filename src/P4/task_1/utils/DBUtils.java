package P4.task_1.utils;

import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.*;

public class DBUtils {
    private static final String DB_NAME = "taxis";
    private static final String DB_URL = "jdbc:derby:" + DB_NAME;
    private static final String DB_LOGIN = "admin";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_CREATE_URL = String.format("jdbc:derby:%s;create=true;user=%s;password=%s", DB_NAME, DB_LOGIN, DB_PASSWORD);

    public void createDB(){

        try {
            DriverManager.registerDriver(new EmbeddedDriver());
            System.out.println(DB_CREATE_URL);
            Connection connection = DriverManager.getConnection(DB_CREATE_URL);
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printSqlResult(String sql){
        try {
            ResultSet resultSet = getStatement(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                System.out.println("==============");
                for (int i = 1; i <= metaData.getColumnCount(); i++ ) {
                    System.out.println(String.format("'%s' : '%s'", metaData.getColumnName(i), resultSet.getString(i)));
                    
                }
                System.out.println("==============");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getStatement(String sql){
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Cannot opened connection to Data Base");
            e.printStackTrace();
        }
        return resultSet;
    }

}
