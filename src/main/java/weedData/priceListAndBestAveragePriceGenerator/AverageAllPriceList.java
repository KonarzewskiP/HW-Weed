package weedData.priceListAndBestAveragePriceGenerator;

import weedData.StateUSA;
import weedData.StateWithAvgPrices;
import weedData.States;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageAllPriceList implements PriceListAndBestAvgPriceInterface {
    private final List<StateUSA> statesUSA;

    public AverageAllPriceList(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public Map<String, StateWithAvgPrices> statesWithAveragePricesList() {
        Map<String, StateWithAvgPrices> state = new HashMap<>();
        for (StateUSA s : statesUSA) {
            BigDecimal averageHighPrice = avgHighPrice(s.getStateAbbreviation());
            BigDecimal averageMediumPrice = avgMediumPrice(s.getStateAbbreviation());
            BigDecimal averageLowPrice = avgLowPrice(s.getStateAbbreviation());
            StateWithAvgPrices stateWithAvgPrices = new StateWithAvgPrices();
            stateWithAvgPrices.setAvgHigh(averageHighPrice);
            stateWithAvgPrices.setAvgMedium(averageMediumPrice);
            stateWithAvgPrices.setAvgLow(averageLowPrice);
            stateWithAvgPrices.setName(s.getStateName());
            state.put(s.getStateName(), stateWithAvgPrices);
        }
        return state;
    }

    @Override
    public List<StateWithAvgPrices> sortedNumberStatesWithBestPrice(int number){
        return statesWithAveragePricesList()
                .values()
                .stream()
                .sorted(Comparator.comparing(StateWithAvgPrices::average))
                .limit(number)
                .collect(Collectors.toList());
    }

    private BigDecimal avgHighPrice(States state) {
        double number = statesUSA.stream()
                .filter(states1 -> states1.getStateAbbreviation() == state)
                .collect(Collectors.averagingDouble(value ->value.getHighQuality().doubleValue()));
        return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
    }
    private BigDecimal avgMediumPrice(States state) {
        double number = statesUSA.stream()
                .filter(states1 -> states1.getStateAbbreviation() == state)
                .collect(Collectors.averagingDouble(value ->value.getMediumQuality().doubleValue()));
        return new BigDecimal(number).setScale(2,RoundingMode.HALF_UP);
    }
    private BigDecimal avgLowPrice(States state) {
        double number = statesUSA.stream()
                .filter(states1 -> states1.getStateAbbreviation() == state)
                .collect(Collectors.averagingDouble(value ->value.getLowQuality().doubleValue()));
        return new BigDecimal(number).setScale(2,RoundingMode.HALF_UP);
    }

}

