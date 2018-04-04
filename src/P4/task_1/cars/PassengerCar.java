package P4.task_1.cars;

public class PassengerCar extends BaseCar {

    public PassengerCar(String name, int consumption, int price) {
        super(name, CarTypes.PASSENGER.getCarType(), consumption, price);
    }

}
