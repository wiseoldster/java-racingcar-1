package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MaxFinder {
    public static <T> ArrayList<T> findAllMax2(ArrayList<T> values, Comparator<T> comp) {
        ArrayList<T> maxValues = new ArrayList<>();
        T maxVal = values.get(0);
        for (T value : values) {
            maxVal = checkNewIsMax(comp, maxValues, maxVal, value);
        }
        return maxValues;
    }

    private static <T> T checkNewIsMax(Comparator<T> comp, ArrayList<T> maxValues, T maxVal, T newValue) {
        if (comp.compare(newValue, maxVal) == 0) {
            maxValues.add(newValue);
        }
        if (comp.compare(newValue, maxVal) > 0) {
            maxValues.clear();
            maxValues.add(newValue);
            maxVal = newValue;
        }
        return maxVal;
    }

    public static <T> ArrayList<T> findAllMax(ArrayList<T> values, Comparator<T> comp) {
        T maxVal = Collections.max(values, comp);

        return values.stream()
                .filter((T now) -> comp.compare(now, maxVal) == 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
