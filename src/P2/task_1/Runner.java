package P2.task_1;

import P2.task_1.cars.BaseCar;
import P2.task_1.taxis.Taxis;

public class Runner {
    public static void main(String[] args) {
        Taxis taxis = new Taxis();
        for (BaseCar i: taxis.getAllTaxisCars()) {
            System.out.println(i.getCarName() + " id: " + i.getId());

        }

        System.out.println("Taxis price is: " + taxis.getAllCarsPrice() + " usd");

    }
}
