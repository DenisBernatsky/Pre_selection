package P5.utils;

import P5.cars.BaseCar;

import java.util.ArrayList;

public class ListUtils {

    public ArrayList<BaseCar> joinLists(ArrayList<BaseCar> a, ArrayList<BaseCar> b) {
        if ((a == null) || (a.isEmpty() && (b != null))) return b;
        if ((b == null) || b.isEmpty()) return a;
        int aSize = a.size();
        int bSize = b.size();

        ArrayList<BaseCar> result = new ArrayList<>(aSize + bSize);
        result.addAll(a);
        result.addAll(b);

        return result;
    }
}
