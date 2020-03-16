package weedData.priceListAndBestAveragePriceGenerator;

import weedData.StateUSA;
import weedData.StateWithAvgPrices;
import weedData.States;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageMediumPriceList implements PriceListAndBestAvgPriceInterface {

    private final List<StateUSA> statesUSA;
    public AverageMediumPriceList(List<StateUSA> statesUSA) {
        this.statesUSA = statesUSA;
    }

    @Override
    public Map<String, StateWithAvgPrices> statesWithAveragePricesList() {
        Map<String, StateWithAvgPrices> state = new HashMap<>();
        for (StateUSA s : statesUSA) {
            BigDecimal averageMediumPrice = avgMediumPrice(s.getStateAbbreviation());
            StateWithAvgPrices stateWithAvgPrices = new StateWithAvgPrices();
            stateWithAvgPrices.setAvgMedium(averageMediumPrice);
            stateWithAvgPrices.setName(s.getStateName());
            state.put(s.getStateName(), stateWithAvgPrices);
        }
        return state;
    }
    private BigDecimal avgMediumPrice(States state) {
        double number = statesUSA.stream()
                .filter(states1 -> states1.getStateAbbreviation() == state)
                // nice
                .collect(Collectors.averagingDouble(value -> value.getMediumQuality().doubleValue()));
        return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
    }
    @Override
    public List<StateWithAvgPrices> sortedNumberStatesWithBestPrice(int number){
        return statesWithAveragePricesList()
                .values()
                .stream()
                .sorted((o1, o2) -> o1.getAvgMedium().compareTo(o2.getAvgMedium()))
                .limit(number)
                .collect(Collectors.toList());
    }

}
