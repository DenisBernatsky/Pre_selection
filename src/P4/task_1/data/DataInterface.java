package P4.task_1.data;

import P4.task_1.cars.BaseCar;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DataInterface {

    ArrayList<BaseCar> getCarListFromEntity() throws SQLException;
}
