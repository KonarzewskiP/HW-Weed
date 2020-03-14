package weedData.weedStatistics;

import weedData.StateUSA;
import weedData.bestPriceByYear.BestMediumPriceByYear;
import weedData.bestPriceWeedBetweenAllStates.BestMediumPrice;
import weedData.bestPriceWeedForEachState.BestMediumPriceEachState;
import weedData.bestPricebyMonth.BestMediumPriceByMonth;
import weedData.priceListAndBestAveragePriceGenerator.AverageMediumPriceList;
import weedData.sortByDate.SortMediumPriceByDate;

import java.util.List;

public class WeedStatisticsMediumPrice extends WeedStatistics {
    public WeedStatisticsMediumPrice(List<StateUSA> states) {
        priceListAndBestAvgPriceInterface = new AverageMediumPriceList(states);
        bestPriceInterface = new BestMediumPrice(states);
        bestPriceForEachStateInterface = new BestMediumPriceEachState(states);
        bestPriceByYearBetweenAllStatestInterface = new BestMediumPriceByYear(states);
        bestPriceByMonthBetweenAllStatesInterface = new BestMediumPriceByMonth(states);
        statisticsSortedByDate = new SortMediumPriceByDate(states);
    }
}
