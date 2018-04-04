package P4.task_1.data;

import P4.task_1.cars.BaseCar;
import P4.task_1.cars.MinibusCar;
import P4.task_1.cars.PassengerCar;
import P4.task_1.cars.Truck;

class BaseData {

    BaseCar createCarByType(String type, String name, int consumption, int price){
        switch (type){
            case "Passenger Car": {
                return new PassengerCar(name, consumption, price);}
            case "Minibus Car": {
                return new MinibusCar(name, consumption, price);}
            case "Truck": {
                return new Truck(name, consumption, price);}
            default:
                throw new NullPointerException("Current car type is not found");

        }
    }
}
