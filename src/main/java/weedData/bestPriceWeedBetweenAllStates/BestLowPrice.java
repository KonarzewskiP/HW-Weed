package weedData.bestPriceWeedBetweenAllStates;

import weedData.StateUSA;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BestLowPrice implements BestPriceInterface {
    private final List<StateUSA> statesUSA;

    public BestLowPrice(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public List<StateUSA> showBestPriceWeed(int number) {
        return statesUSA
                .stream()
                .sorted(new Comparator<StateUSA>() {
                    @Override
                    public int compare(StateUSA o1, StateUSA o2) {
                        return o1.getLowQuality().compareTo(o2.getLowQuality());
                    }
                })
                .limit(number)
                .collect(Collectors.toList());
    }
}
