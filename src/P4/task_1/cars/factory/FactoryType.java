package P4.task_1.cars.factory;

import P4.task_1.cars.BaseCar;
import P4.task_1.cars.MinibusCar;
import P4.task_1.cars.PassengerCar;
import P4.task_1.cars.Truck;

public class FactoryType {
    private String name;
    private int consumption;
    private int price;

    private  FactoryType(){}

    public FactoryType(String name, int consumption, int price) {
        this.name = name;
        this.consumption = consumption;
        this.price = price;
    }

    public BaseCar createMinibusType(){
        return new MinibusCar(name, consumption, price);
    }

    public BaseCar createTruckType(){
        return new Truck(name, consumption, price);
    }

    public BaseCar createPassengersType(){
        return new PassengerCar(name, consumption, price);
    }

}
