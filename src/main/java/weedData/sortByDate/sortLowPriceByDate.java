package weedData.sortByDate;

import weedData.StateUSA;

import java.util.List;

public class sortLowPriceByDate implements StatisticsSortedByDate{
    private final List<StateUSA> statesUSA;

    public sortLowPriceByDate(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public List<StateUSA> sortedByDate() {
        return null;
    }
}
