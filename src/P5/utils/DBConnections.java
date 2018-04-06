package P5.utils;

import P5.data.CarsDataSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnections {

    private static final String DB_NAME = "taxis";
    private static final String DB_URL = "jdbc:derby:" + DB_NAME;
    private static final String DB_LOGIN = "admin";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_CREATE_URL = String.format("jdbc:derby:%s;create=true;user=%s;password=%s", DB_NAME, DB_LOGIN, DB_PASSWORD);

    private DBConnections(){}

    private static Connection con = null;

    public static Connection getConnection(){
        try {
            if (con == null){
                con = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
            }
        }
        catch (SQLException e){
            System.out.println("Data base not found. Start to create.");
            e.printStackTrace();
            try {
                con =  DriverManager.getConnection(DB_CREATE_URL);
                new CarsDataSQL().createDB();
                return con;

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return con;
    }

}
