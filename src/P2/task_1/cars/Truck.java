package P2.task_1.cars;

public class Truck extends BaseCar {

    private static String carType = "Truck";
    private static int consumption = 21;
    private static String carName = "MAN AS-6";
    private static int price = 34000;

    public Truck() {
        super(carName, carType, consumption, price);
    }

    @Override
    public void getCarInfo() {
        System.out.println("Get truck car info");
    }
}
