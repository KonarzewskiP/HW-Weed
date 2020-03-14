package weedData.bestPricebyMonth;

import weedData.StateUSA;

import java.util.*;

import static java.util.stream.Collectors.*;

public class BestHighPriceByMonth implements BestPriceByMonthBetweenAllStatesInterface{
    private final List<StateUSA> statesUSA;

    public BestHighPriceByMonth(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public Map<Integer, Map<Integer, Optional<StateUSA>>> bestPriceByMonth() {
        return statesUSA
                .stream()
                .collect(groupingBy(state -> state.getDate().getYear(),
                        groupingBy(stateDate -> stateDate.getDate().getMonth().getValue(),
                                minBy(Comparator.comparing(StateUSA::getHighQuality)))));
    }
}
