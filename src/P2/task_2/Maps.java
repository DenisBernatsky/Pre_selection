package P2.task_2;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class Maps {

    private static int value = 1000000;

    public HashMap<String, Integer> addElementsHashMap(){
        final long startTime = System.currentTimeMillis();
        HashMap<String, Integer> set = new HashMap<String, Integer>();
        for (int i = 0; i < value; i++){
            String text = ("Item number-" + new Random().nextInt());
            int number = new Random().nextInt();
            set.put(text, number);

        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for add elements in HashMap: " + (endTime - startTime) + "ms");
        return set;
    }

    public void addElementsTreeMap(){
        final long startTime = System.currentTimeMillis();
        TreeMap<String, Integer> set = new TreeMap<String, Integer>();
        for (int i = 0; i < value; i++){
            String text = ("Item number-" + new Random().nextInt());
            int number = new Random().nextInt();
            set.put(text, number);
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for add elements in TreeMap: " + (endTime - startTime) + "ms");
    }

}
