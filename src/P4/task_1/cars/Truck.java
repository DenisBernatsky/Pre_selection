package P4.task_1.cars;

import P4.task_1.enums.CarTypesEnum;

public class Truck extends BaseCar {

    public Truck(String name, int consumption, int price) {
        super(name, CarTypesEnum.TRUCK.getCarType(), consumption, price);
    }

}
