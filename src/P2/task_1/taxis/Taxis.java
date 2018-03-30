package P2.task_1.taxis;

import P2.task_1.cars.BaseCar;
import P2.task_1.cars.MinibusCar;
import P2.task_1.cars.PassengerCar;
import P2.task_1.cars.Truck;

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

}
