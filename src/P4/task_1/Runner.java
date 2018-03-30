package P4.task_1;

import P4.task_1.cars.BaseCar;
import P4.task_1.taxis.Taxis;
import P4.task_1.utils.ReadAndWriteInFile;
import P4.task_1.utils.XmlReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Runner {

    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Taxis taxis = new Taxis();
        System.out.println("Taxis price is: " + taxis.getAllCarsPrice() + " usd");

        int minPrice = 12000;
        int maxPrice = 20000;

        ArrayList<BaseCar> searchResultList = taxis.searchByPrice(minPrice, maxPrice);
        System.out.println("Array cars wirh min price: " + minPrice + "and max: " + maxPrice);

        // search by price
        StringBuilder text = new StringBuilder(" ");
        for (BaseCar element:searchResultList) {
            text.append("Cars model: ").append(element.getCarName()).append("        id: ").append(element.getId()).append("\n ");
        }

        ReadAndWriteInFile readAndWriteInFile = new ReadAndWriteInFile();
        readAndWriteInFile.writeInFile(FILE_NAME, "В файл записано: \n" + text);
        try {
            System.out.println(readAndWriteInFile.getTextFromFile(FILE_NAME));
        } catch (IOException e) {
            System.out.println("IOException in getTextFromFile");
        }

        XmlReader xml = new XmlReader("Data.xml");
        try {
            xml.getId();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }



}
