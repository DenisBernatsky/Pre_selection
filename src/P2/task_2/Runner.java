package P2.task_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Runner {
    public static void main(String[] args) {
        Lists list = new Lists();
        ArrayList arList = list.addElementsArrayList();
        LinkedList linList = list.addElementsLinkedList();

        list.removeElementsArrayList(arList);
        list.removeElementsLinkedList(linList);

        Sets sets = new Sets();
        HashSet hSet = sets.addElementsHashSet();
        TreeSet tSet = sets.addElementsTreeSet();

        sets.removeElementsHashSet(hSet);
        sets.removeElementsTreeSet(tSet);


        Maps maps = new Maps();
        maps.addElementsHashMap();
        maps.addElementsTreeMap();

    }

}
