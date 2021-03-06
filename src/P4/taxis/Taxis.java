package P4.taxis;

import P4.cars.BaseCar;
import P4.exceptions.CarExceptions;

import java.util.ArrayList;

public class Taxis {
    private static int minPrice = 0;
    private static int maxPrice = 100000;

    private static int getMinPrice() {
        return minPrice;
    }

    private static int getMaxPrice() {
        return maxPrice;
    }

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
        if (minPrice < getMinPrice() || maxPrice > getMaxPrice()){
            throw new CarExceptions("Not correct price. Min price is " + getMinPrice() + " and max price " + getMaxPrice());
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
