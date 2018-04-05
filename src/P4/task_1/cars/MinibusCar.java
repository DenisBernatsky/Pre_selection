package P4.task_1.cars;

import P4.task_1.enums.CarTypesEnum;

public class MinibusCar extends BaseCar {

    private MinibusCar(){}

    public MinibusCar(String name, int consumption, int price) {
        super(name, CarTypesEnum.MINIBUS.getCarType(), consumption, price);
    }

}
