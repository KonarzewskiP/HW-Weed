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
                .sorted(Comparator.comparing(StateUSA::getLowQuality))
                .limit(number)
                .collect(Collectors.toList());
    }
}
