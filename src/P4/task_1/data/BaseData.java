package P4.task_1.data;

import P4.task_1.cars.BaseCar;
import P4.task_1.cars.MinibusCar;
import P4.task_1.cars.PassengerCar;
import P4.task_1.cars.Truck;

class BaseData {

    BaseCar createCarByType(String type){
        switch (type){
            case "Passenger Car": {
                return new PassengerCar();}
            case "Minibus Car": {
                return new MinibusCar();}
            case "Truck": {
                return new Truck();}
            default:
                throw new NullPointerException("Current car type is not found");

        }
    }
}
