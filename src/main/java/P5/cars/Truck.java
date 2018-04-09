package P5.cars;

import P5.enums.CarTypesEnum;

public class Truck extends BaseCar {

    public Truck(String name, int consumption, int price) {
        super(name, CarTypesEnum.TRUCK.getCarType(), consumption, price);
    }

}
