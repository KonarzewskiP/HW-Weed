package weedData.sortByDate;

import weedData.StateUSA;

import java.util.List;

public class sortMediumPriceByDate implements StatisticsSortedByDate {
    private final List<StateUSA> statesUSA;

    public sortMediumPriceByDate(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public List<StateUSA> sortedByDate() {
        return null;
    }
}
