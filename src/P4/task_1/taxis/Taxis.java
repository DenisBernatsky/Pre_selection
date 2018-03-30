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

    public int getAllCarsPrice(){
        int price = 0;
        for (BaseCar i: getAllTaxisCars()){
            price +=i.getPrice();
        }
        return price;
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


    public ArrayList<BaseCar> searchByPrice(int minPrice, int maxPrice){
        if (minPrice < 0 || maxPrice > 100000){
            throw new CarExceptions("Not correct price. Min price is 0 and max price 100000.");
        }

        ArrayList<BaseCar> result = new ArrayList<>();
        for (BaseCar element:getAllTaxisCars()) {
            if (minPrice <= element.getPrice() && element.getPrice() <= maxPrice) {
                result.add(element);
            }
        }
        return result;
    }

}
