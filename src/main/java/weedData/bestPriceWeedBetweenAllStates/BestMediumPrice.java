package weedData.bestPriceWeedBetweenAllStates;

import weedData.StateUSA;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BestMediumPrice implements BestPriceInterface {
    private final List<StateUSA> statesUSA;

    public BestMediumPrice(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public List<StateUSA> showBestPriceWeed(int number) {
        return statesUSA
                .stream()
                .sorted(new Comparator<StateUSA>() {
                    @Override
                    public int compare(StateUSA o1, StateUSA o2) {
                        return o1.getMediumQuality().compareTo(o2.getMediumQuality());
                    }
                })
                .limit(number)
                .collect(Collectors.toList());
    }
}
