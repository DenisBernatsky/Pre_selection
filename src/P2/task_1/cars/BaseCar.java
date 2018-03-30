package P2.task_1.cars;

public class BaseCar {
    private String carName;
    private String carType;
    private int consumption;
    private int id;
    private int price;

    public BaseCar(String carName, String carType, int consumption, int price) {
        this.carName = carName;
        this.carType = carType;
        this.consumption = consumption;
        this.price = price;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public void getCarInfo(){
        System.out.println("Get base car info");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

}
