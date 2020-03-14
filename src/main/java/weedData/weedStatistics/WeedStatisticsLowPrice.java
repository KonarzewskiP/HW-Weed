package weedData.weedStatistics;

import weedData.StateUSA;
import weedData.priceListGenerator.AverageLowPriceList;

import java.util.List;

public class WeedStatisticsLowPrice extends WeedStatistics {
    public WeedStatisticsLowPrice(List<StateUSA> states) {
        priceListGeneratorInterface = new AverageLowPriceList(states);
    }
}
