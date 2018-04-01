package P4.task_1.taxis;

import P4.task_1.cars.BaseCar;
import P4.task_1.cars.MinibusCar;
import P4.task_1.cars.PassengerCar;
import P4.task_1.cars.Truck;
import P4.task_1.exceptions.CarExceptions;

import java.util.ArrayList;

public class Taxis {

    private static final int MINIBUS_COUNT = 5;
    private static final int PASSENGER_CAR_COUNT = 67;
    private static final int TRUCK_COUNT = 2;

    public void getAllCarsPrice(ArrayList<BaseCar> list){
        int price = 0;
        for (BaseCar i: list){
            price +=i.getPrice();
        }
        System.out.println("Cars price: " + price + " USD");;
    }

    public void getAllCarsInfo(ArrayList<BaseCar> list){
        for (BaseCar car: list) {
            System.out.println("Car: " + car.getCarName() +
                    " Type: " + car.getCarType() +
                    " Price: " + car.getPrice() +
                    " Consumption: "  + car.getConsumption());
        }
    }

    public ArrayList<BaseCar> getAllMinibus(){
        ArrayList<BaseCar>carList = new ArrayList<BaseCar>();
        for (int i = 0; i < MINIBUS_COUNT; i++){
            BaseCar car = new MinibusCar();
            car.setId(i+1);
            carList.add(car);
        }
        return carList;

    }

    public ArrayList<BaseCar> getAllPassengerCar(){
        ArrayList<BaseCar> carList = new ArrayList<BaseCar>();
        for (int i = 0; i < PASSENGER_CAR_COUNT; i++){
            BaseCar car = new PassengerCar();
            car.setId(i+1);
            carList.add(car);
        }
        return carList;
    }

    public ArrayList<BaseCar> getAllTruck(){
        ArrayList<BaseCar> carList = new ArrayList<BaseCar>();
        for (int i = 0; i < TRUCK_COUNT; i++){
            BaseCar car = new Truck();
            car.setId(i+1);
            carList.add(car);
        }
        return carList;
    }

    public ArrayList<BaseCar> getAllTaxisCars(){
        ArrayList<BaseCar> carsList = new ArrayList<BaseCar>();
        carsList.addAll(getAllMinibus());
        carsList.addAll(getAllPassengerCar());
        carsList.addAll(getAllTruck());
        return carsList;
    }


    public ArrayList<BaseCar> searchByPrice(int minPrice, int maxPrice , ArrayList<BaseCar> list){
        if (minPrice < 0 || maxPrice > 100000){
            throw new CarExceptions("Not correct price. Min price is 0 and max price 100000.");
        }

        ArrayList<BaseCar> result = new ArrayList<>();
        for (BaseCar element:list) {
            if (minPrice <= element.getPrice() && element.getPrice() <= maxPrice) {
                result.add(element);
            }
        }
        return result;
    }

}
