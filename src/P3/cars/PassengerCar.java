package P3.cars;

public class PassengerCar extends BaseCar {

    private static String carType = "Passenger Car";
    private static int consumption = 8;
    private static String carName = "Citroen C5";
    private static int price = 9700;

    public PassengerCar() {
        super(carName, carType, consumption, price);
    }

    @Override
    public void getCarInfo() {
        System.out.println("Get passenger car info");
    }
}
