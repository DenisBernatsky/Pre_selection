package P4.task_1.cars;

public class BaseCar {
    private String carName;
    private String carType;
    private int consumption;
    private int id;
    private int price;

    public BaseCar(String carName, String carType, int consumption, int price) {
        this.setCarName(carName);
        this.setCarType(carType);
        this.setConsumption(consumption);
        this.setPrice(price);
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

    private void setCarType(String carType) {
        this.carType = carType;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public void getCarInfo(){
        System.out.println("Get " + carType + "car info");
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

    public void setPrice(int price) {
        this.price = price;
    }

}
