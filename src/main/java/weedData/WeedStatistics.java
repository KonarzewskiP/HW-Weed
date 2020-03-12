package weedData;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@ToString
public class WeedStatistics {
    private final List<StateUSA> statesUSA;

    public WeedStatistics(List<StateUSA> states) {
        this.statesUSA = states;
    }

    public Map<String, StateWithAvgPrices> statesWithAvgPricesList() {
        Map<String, StateWithAvgPrices> state = new HashMap<>();
        for (StateUSA s : statesUSA) {
            StateWithAvgPrices stateWithAvgPrices = new StateWithAvgPrices();
            BigDecimal averageHighPrice = avgHighPrice(s.getStateAbbreviation());
            BigDecimal averageMediumPrice = avgMediumPrice(s.getStateAbbreviation());
            BigDecimal averageLowPrice = avgLowPrice(s.getStateAbbreviation());
            stateWithAvgPrices.setAvgHigh(averageHighPrice);
            stateWithAvgPrices.setAvgMedium(averageMediumPrice);
            stateWithAvgPrices.setAvgLow(averageLowPrice);
            stateWithAvgPrices.setName(s.getStateName());
            stateWithAvgPrices.setBestAvg();
            state.put(s.getStateName(), stateWithAvgPrices);
        }
        return state;
    }

    private BigDecimal avgHighPrice(States state) {
        double number = statesUSA.stream()
                .filter(states1 -> states1.getStateAbbreviation() == state)
                .collect(Collectors.averagingDouble(value ->value.getHighQuality().doubleValue()));
        return new BigDecimal(number).setScale(2,RoundingMode.HALF_UP);
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

    public Optional<StateWithAvgPrices> stateWithBestHighWeedPrice(){
        Comparator<StateWithAvgPrices> stateWithHighAvgPricesComparator = Comparator.comparing(StateWithAvgPrices::getAvgHigh);
        return  statesWithAvgPricesList()
                .values()
                .stream()
                .max(Comparator.comparing(StateWithAvgPrices -> StateWithAvgPrices.getAvgHigh().doubleValue()));

//        public Optional<Map.Entry<String, StateWithAvgPrices>> stateWithBestHighWeedPrice(){
//            Comparator<StateWithAvgPrices> stateWithHighAvgPricesComparator = Comparator.comparing(StateWithAvgPrices::getAvgHigh);
//            return  statesWithAvgPricesList()
//                    .entrySet()
//                    .stream()
//                    .max(Comparator.comparing(StateWithAvgPrices -> StateWithAvgPrices.getValue().getAvgHigh().doubleValue()));


    }
}

//        1. Sprawdź, który stan ma ogółem najlepsze średnie ceny trawy. (ignoruj wpisy, dla których brakuje danych)
//        2. Pokaż 5 najniższych cen wysokiej jakości palenia.
//        3. Pokaż historycznie najlepszą cenę średniej jakości zielska dla każdego stanu.
//        4. Na każdy możliwy rok pokaż stan, w którym dało się najtaniej kupić jakikolwiek towar.
//        4*(dla ambitnych). To samo co wyżej tylko na każdy dostępny "rok-miesiąc"
//        5. Posortuj wpisy latami.