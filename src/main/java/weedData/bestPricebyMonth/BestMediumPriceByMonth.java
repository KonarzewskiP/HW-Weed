package weedData.bestPricebyMonth;

import weedData.StateUSA;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.minBy;

public class BestMediumPriceByMonth implements BestPriceByMonthBetweenAllStatesInterface{
    private final List<StateUSA> statesUSA;

    public BestMediumPriceByMonth(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public Map<Integer, Map<Integer, Optional<StateUSA>>> bestPriceByMonth() {
        return statesUSA
                .stream()
                .collect(groupingBy(state -> state.getDate().getYear(),
                        groupingBy(stateDate -> stateDate.getDate().getMonth().getValue(),
                                minBy(Comparator.comparing(StateUSA::getMediumQuality)))));
    }
}
