package P4.task_1.cars;

public class MinibusCar extends BaseCar {


    public MinibusCar(String name, int consumption, int price) {
        super(name, CarTypes.MINIBUS.getCarType(), consumption, price);
    }

}
