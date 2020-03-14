package weedData.weedStatistics;

import weedData.StateUSA;
import weedData.priceListGenerator.AverageAllPriceList;

import java.util.List;

public class WeedStatisticsHighMediumLowPrice extends WeedStatistics {

    public WeedStatisticsHighMediumLowPrice(List<StateUSA> states){
        priceListGeneratorInterface = new AverageAllPriceList(states);
    }
}
