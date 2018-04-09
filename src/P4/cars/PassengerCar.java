package P4.cars;

import P4.enums.CarTypesEnum;

public class PassengerCar extends BaseCar {

    public PassengerCar(String name, int consumption, int price) {
        super(name, CarTypesEnum.PASSENGER.getCarType(), consumption, price);
    }

}
