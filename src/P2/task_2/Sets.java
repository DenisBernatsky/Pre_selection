package P2.task_2;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Sets {
    private static int value = 1000000;

    public HashSet addElementsHashSet(){
        final long startTime = System.currentTimeMillis();
        HashSet set = new HashSet();
        for (int i = 0; i < value; i++){
            String text = ("Item number-" + new Random().nextInt());
            set.add(text);
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for add elements in HashSet: " + (endTime - startTime) + "ms");
        return set;
    }

    public TreeSet addElementsTreeSet(){
        final long startTime = System.currentTimeMillis();
        TreeSet set = new TreeSet();
        for (int i = 0; i < value; i++){
            String text = ("Item number-" + new Random().nextInt());
            set.add(text);
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for add elements in TreeSet: " + (endTime - startTime) + "ms");
        return set;
    }

    public void removeElementsHashSet(HashSet set){
        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < set.size(); i++){
            if(i % 4 == 0){
            set.remove(i);
            }
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for remove elements in HashSet: " + (endTime - startTime) + "ms");
    }

    public void removeElementsTreeSet(TreeSet set){
        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < set.size(); i++){
            if(i % 4 == 0){
                set.remove(set.first());
            }
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time for remove elements in TreeSet: " + (endTime - startTime) + "ms");
    }
}
