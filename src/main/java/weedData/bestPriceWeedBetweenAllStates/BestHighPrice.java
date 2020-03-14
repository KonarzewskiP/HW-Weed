package weedData.bestPriceWeedBetweenAllStates;

import weedData.StateUSA;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BestHighPrice implements BestPriceInterface {
    private final List<StateUSA> statesUSA;

    public BestHighPrice(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public List<StateUSA> showBestPriceWeed(int number) {
        return statesUSA
                .stream()
                .sorted(new Comparator<StateUSA>() {
                    @Override
                    public int compare(StateUSA o1, StateUSA o2) {
                        return o1.getHighQuality().compareTo(o2.getHighQuality());
                    }
                })
                .limit(number)
                .collect(Collectors.toList());
    }
}
