package P2.task_2;

public class Runner {
    public static void main(String[] args) {
        Lists list = new Lists();
        list.addElementsArrayList();
        list.addElementsLinkedList();

        Sets sets = new Sets();
        sets.addElementsHashSet();
        sets.addElementsTreeSet();

        Maps maps = new Maps();
        maps.addElementsHashMap();
        maps.addElementsTreeMap();

    }

}
