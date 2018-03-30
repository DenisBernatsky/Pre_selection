package P2.legacy;

import P2.legacy.entity.Bouquet;
import P2.legacy.entity.Flower;
import P2.legacy.entity.Rose;
import P2.legacy.entity.Violet;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();
        ArrayList<Flower> bouquetList = new ArrayList<Flower>();
        ArrayList<Flower> roseList = bouquet.makeOneTypeFlowerList(11, new Rose("Rose", "Red"));
        ArrayList<Flower> violetList = bouquet.makeOneTypeFlowerList(56, new Violet("Violet"));
        bouquetList.addAll(roseList);
        bouquetList.addAll(violetList);
        System.out.println("Стоймость букета: " + bouquet.getBouquetPrice(bouquetList));



    }
}
