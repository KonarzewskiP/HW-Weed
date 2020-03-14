package weedData.weedStatistics;

import lombok.Getter;
import lombok.ToString;
import weedData.priceListGenerator.PriceListGeneratorInterface;
import weedData.StateUSA;
import weedData.StateWithAvgPrices;

import java.util.*;

@Getter
@ToString
public abstract class WeedStatistics {
//    private final List<StateUSA> statesUSA;
    PriceListGeneratorInterface priceListGeneratorInterface;

//    public WeedStatistics(List<StateUSA> states) {
//        this.statesUSA = states;
//    }

    public Map<String, StateWithAvgPrices> generatePriceList() {
        return priceListGeneratorInterface.statesWithPricesList();
    }

    public List<StateWithAvgPrices> sortedNumberStatesWithBestHighQualityPrice(int number) {
        return priceListGeneratorInterface.sortedNumberStatesWithBestPrice(number);
    }

}

//        1. Sprawdź, który stan ma ogółem najlepsze średnie ceny trawy. (ignoruj wpisy, dla których brakuje danych)
//        2. Pokaż 5 najniższych cen wysokiej jakości palenia.
//        3. Pokaż historycznie najlepszą cenę średniej jakości zielska dla każdego stanu.
//        4. Na każdy możliwy rok pokaż stan, w którym dało się najtaniej kupić jakikolwiek towar.
//        4*(dla ambitnych). To samo co wyżej tylko na każdy dostępny "rok-miesiąc"
//        5. Posortuj wpisy latami.