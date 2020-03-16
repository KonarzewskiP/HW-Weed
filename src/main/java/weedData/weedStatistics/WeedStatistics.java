package weedData.weedStatistics;

import lombok.Getter;
import lombok.ToString;
import weedData.StateUSA;
import weedData.bestPriceByYear.BestPriceByYearBetweenAllStatestInterface;
import weedData.bestPriceWeedBetweenAllStates.BestPriceInterface;
import weedData.bestPriceWeedForEachState.BestPriceForEachStateInterface;
import weedData.bestPricebyMonth.BestPriceByMonthBetweenAllStatesInterface;
import weedData.priceListAndBestAveragePriceGenerator.PriceListAndBestAvgPriceInterface;
import weedData.StateWithAvgPrices;
import weedData.sortByDate.StatisticsSortedByDate;

import java.time.LocalDate;
import java.util.*;

@Getter
@ToString
public abstract class WeedStatistics {

    PriceListAndBestAvgPriceInterface priceListAndBestAvgPriceInterface;
    BestPriceInterface bestPriceInterface;
    BestPriceForEachStateInterface bestPriceForEachStateInterface;
    BestPriceByYearBetweenAllStatestInterface bestPriceByYearBetweenAllStatestInterface;
    BestPriceByMonthBetweenAllStatesInterface bestPriceByMonthBetweenAllStatesInterface;
    StatisticsSortedByDate statisticsSortedByDate;


    public Map<String, StateWithAvgPrices> generateAveragePriceList() {
        return priceListAndBestAvgPriceInterface.statesWithAveragePricesList();
    }

    // nazwa metody zaczyna sie od 'show', ale metoda nic nie pokazuje
    // getBestAveragePrices byloby ok
    public List<StateWithAvgPrices> showBestAveragePrice(int number) {
        return priceListAndBestAvgPriceInterface.sortedNumberStatesWithBestPrice(number);
    }
    public List<StateUSA> showBestPriceOfWeed(int number){
        return bestPriceInterface.showBestPriceWeed(number);
    }

    public Map<String, Optional<StateUSA>> historicallyBestPriceForEachState(){
        return bestPriceForEachStateInterface.bestPriceForEachState();
    }

    public Map<Integer, Optional<StateUSA>> bestPriceBetweenAllStatesByYear(){
        return  bestPriceByYearBetweenAllStatestInterface.bestPriceByYear();
    }

    public Map<Integer, Map<Integer, Optional<StateUSA>>> bestPriceBetweenAllStatesByMonth(){
        return bestPriceByMonthBetweenAllStatesInterface.bestPriceByMonth();
    }

    public List<StateUSA> sortedByDate(){
        return statisticsSortedByDate.sortedByDate();
    }
}

//        1. Sprawdź, który stan ma ogółem najlepsze średnie ceny trawy. (ignoruj wpisy, dla których brakuje danych)
//        2. Pokaż 5 najniższych cen wysokiej jakości palenia.
//        3. Pokaż historycznie najlepszą cenę średniej jakości zielska dla każdego stanu.
//        4. Na każdy możliwy rok pokaż stan, w którym dało się najtaniej kupić jakikolwiek towar.
//        4*(dla ambitnych). To samo co wyżej tylko na każdy dostępny "rok-miesiąc"
//        5. Posortuj wpisy latami.