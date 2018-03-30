package P3.legacy.entity;

import P3.legacy.exceptions.FlowerExceptions;

import java.util.ArrayList;

public class Bouquet {

    public ArrayList<Flower>  makeOneTypeFlowerList(int flowerCount, Flower flower) {
        ArrayList<Flower> bouquet = new ArrayList<Flower>();
        for (int i = 0; i < flowerCount; i++) {
            bouquet.add(flower);
        }
        return bouquet;
    }

    public int getBouquetPrice(ArrayList<Flower>  flowerList) {
        int price = 0;
        if (flowerList.isEmpty()){
            throw new FlowerExceptions("List is empty");
        }

        for (Flower flower : flowerList) {
            price += flower.getPrice();
        }
        if (price == 0) {
            throw new FlowerExceptions("Price is 0");
        }
        return price;
    }


}
