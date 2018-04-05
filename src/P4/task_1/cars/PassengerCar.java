package P4.task_1.cars;

import P4.task_1.enums.CarTypesEnum;

public class PassengerCar extends BaseCar {

    public PassengerCar(String name, int consumption, int price) {
        super(name, CarTypesEnum.PASSENGER.getCarType(), consumption, price);
    }

}
