package P2.task_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Lists {

    private static int value = 100000;

    public ArrayList<String> addElementsArrayList(){
        final long startTime = System.currentTimeMillis();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < value; i++){
            String text = ("Item number-" + new Random().nextInt());
            list.add(text);
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for add elements in ArrayList: " + (endTime - startTime) + "ms");
        return list;
    }

    public LinkedList<String> addElementsLinkedList(){
        final long startTime = System.currentTimeMillis();
        LinkedList<String> list = new LinkedList<String>();
        for (int i = 0; i < value; i++){
            String text = ("Item number-" + new Random().nextInt());
            list.add(text);
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for add elements in LinkedList: " + (endTime - startTime) + "ms");
        return list;
    }

    public void removeElementsArrayList(ArrayList list){
        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            if (i % 3 == 0) {
                list.remove(i);
            }
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for remove elements in ArrayList: " + (endTime - startTime) + "ms");

    }

    public void removeElementsLinkedList(LinkedList list){
        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            if (i % 3 == 0) {
                list.remove(i);
            }
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for remove elements in LinkedList: " + (endTime - startTime) + "ms");

    }

}
