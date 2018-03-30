package P3.legacy;

import P3.legacy.entity.Bouquet;
import P3.legacy.entity.Flower;
import P3.legacy.entity.Rose;
import P3.legacy.entity.Violet;
import P3.legacy.utils.ReadAndWriteInFile;

import java.io.IOException;
import java.util.ArrayList;

public class Runner {
    private static final int ROSE_COUNT = 45;
    private static final int VIOLET_COUNT = 4;
    private static final String FILE_NAME = "notes.txt";


    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();
        ArrayList<Flower> bouquetList = new ArrayList<Flower>();
        ArrayList<Flower> roseList = bouquet.makeOneTypeFlowerList(ROSE_COUNT, new Rose("Rose", "Red"));
        ArrayList<Flower> violetList = bouquet.makeOneTypeFlowerList(VIOLET_COUNT, new Violet("Violet"));
        bouquetList.addAll(roseList);
        bouquetList.addAll(violetList);

        String price = null;
        try {
            price = Integer.toString(bouquet.getBouquetPrice(bouquetList));
        } catch (Exception e){
            System.out.println("Error");
        }

        String text = "Стоймость букета: " + price;
        System.out.println(text);

        ReadAndWriteInFile readAndWriteInFile = new ReadAndWriteInFile();
        readAndWriteInFile.writeInFile(FILE_NAME, "В файл записано: " + text);
        try {
            System.out.println(readAndWriteInFile.getTextFromFile(FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
