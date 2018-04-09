package P5.cars.factory;

import P5.cars.BaseCar;
import P5.cars.MinibusCar;
import P5.cars.PassengerCar;
import P5.cars.Truck;

public class FactoryType {
    private String name;
    private int consumption;
    private int price;

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
