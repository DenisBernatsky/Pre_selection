package P5.data;

import P5.cars.BaseCar;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DataInterface {

    ArrayList<BaseCar> getCarListFromEntity() throws SQLException;
}
