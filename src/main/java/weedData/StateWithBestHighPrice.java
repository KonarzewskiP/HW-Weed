package weedData;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;

public class StateWithBestHighPrice implements Comparator<StateWithAveragePrices> {
    @Override
    public int compare(StateWithAveragePrices o1, StateWithAveragePrices o2) {
        return o2.getAverageHighPrice().compareTo(o1.getAverageHighPrice());
    }
}
