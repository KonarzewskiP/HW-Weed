package weedData.sortByDate;

import weedData.StateUSA;

import java.util.List;

public class sortHighMediumLowPriceByDate implements StatisticsSortedByDate {
    private final List<StateUSA> statesUSA;

    public sortHighMediumLowPriceByDate(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public List<StateUSA> sortedByDate() {
        return null;
    }
}
