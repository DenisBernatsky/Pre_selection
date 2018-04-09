package P4.cars;

import P4.enums.CarTypesEnum;

public class MinibusCar extends BaseCar {

    public MinibusCar(String name, int consumption, int price) {
        super(name, CarTypesEnum.MINIBUS.getCarType(), consumption, price);
    }

}
