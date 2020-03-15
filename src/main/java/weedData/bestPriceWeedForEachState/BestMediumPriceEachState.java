package weedData.bestPriceWeedForEachState;

import weedData.StateUSA;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.minBy;


public class BestMediumPriceEachState implements BestPriceForEachStateInterface {
    public final List<StateUSA> statesUSA;

    public BestMediumPriceEachState(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public Map<String, Optional<StateUSA>> bestPriceForEachState() {
        return statesUSA
                .stream()
                .collect(groupingBy(StateUSA::getStateName,
                        minBy(Comparator.comparing(StateUSA::getMediumQuality))));
    }
}
