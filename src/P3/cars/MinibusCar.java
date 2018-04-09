package P3.cars;

public class MinibusCar extends BaseCar {

    private static String carType = "Minibus Car";
    private static int consumption = 12;
    private static String carName = "Volvo F34";
    private static int price = 12340;


    public MinibusCar() {
        super(carName, carType, consumption, price);
    }

    @Override
    public void getCarInfo() {
        System.out.println("Get minibus car info");
    }
}
