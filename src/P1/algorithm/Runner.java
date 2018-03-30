package P1.algorithm;

import java.util.LinkedList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<String> listStrings = new LinkedList<String>();
        listStrings.add("0 Zero Y");
        listStrings.add("1 One  Y");
        listStrings.add("2 Two Y");
        listStrings.add("3 Three Y");
        listStrings.add("4 Four Y");
        listStrings.add("5 Five Y");
        listStrings.add("6 Six Y");
        listStrings.add("7 Seven Y");
        listStrings.add("8 Eight Y");

        for (int i = 0; i <listStrings.size(); i++) {
            String value = listStrings.get(i);
            if (i % 2 == 0) {
                String test = value.substring(1, value.length() - 1);
                char firstChar = value.charAt(0);
                char lastChar = value.charAt(value.length() - 1);
                System.out.println("Change: " +  lastChar + test + firstChar);
            }
            else {
                System.out.println("Skip:   " + value);
            }
        }
    }
}
