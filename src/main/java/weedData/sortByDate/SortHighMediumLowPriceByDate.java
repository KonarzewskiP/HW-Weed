package weedData.sortByDate;

import weedData.StateUSA;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortHighMediumLowPriceByDate implements StatisticsSortedByDate {
    private final List<StateUSA> statesUSA;

    public SortHighMediumLowPriceByDate(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public List<StateUSA> sortedByDate() {
        return statesUSA
                .stream()
                .sorted(Comparator.comparing(StateUSA::getDate))
                .collect(Collectors.toList());
    }
}
