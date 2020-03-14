package weedData.weedStatistics;

import weedData.StateUSA;
import weedData.priceListGenerator.AverageMediumPriceList;

import java.util.List;

public class WeedStatisticsMediumPrice extends WeedStatistics {
    public WeedStatisticsMediumPrice(List<StateUSA> states) {
        priceListGeneratorInterface = new AverageMediumPriceList(states);
    }
}
