package P4.data;

import P4.cars.BaseCar;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DataInterface {

    ArrayList<BaseCar> getCarListFromEntity() throws SQLException;
}
