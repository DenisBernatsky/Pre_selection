package P4.task_1.taxis;

import P4.task_1.cars.BaseCar;
import P4.task_1.exceptions.CarExceptions;

import java.util.ArrayList;

public class Taxis {

    public String getAllCarsPrice(ArrayList<BaseCar> list){
        int price = 0;
        for (BaseCar i: list){
            price +=i.getPrice();
        }
        return "Cars price: " + price + " USD";
    }

    public void getAllCarsInfo(ArrayList<BaseCar> list){
        for (BaseCar car: list) {
            System.out.println("Car: " + car.getCarName() +
                    " Type: " + car.getCarType() +
                    " Price: " + car.getPrice() +
                    " Consumption: "  + car.getConsumption());
        }
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
