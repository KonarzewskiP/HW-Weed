package weedData.weedStatistics;

import weedData.StateUSA;
import weedData.bestPriceByYear.DoNotExecuteByYear;
import weedData.bestPriceWeedBetweenAllStates.DoNotExecuteAllStates;
import weedData.bestPriceWeedForEachState.DoNotExecuteForEachState;
import weedData.bestPricebyMonth.DoNotExecuteByMonth;
import weedData.priceListAndBestAveragePriceGenerator.AverageAllPriceList;
import weedData.sortByDate.SortHighMediumLowPriceByDate;

import java.util.List;

public class WeedStatisticsHighMediumLowPrice extends WeedStatistics {

    public WeedStatisticsHighMediumLowPrice(List<StateUSA> states){
        priceListAndBestAvgPriceInterface = new AverageAllPriceList(states);
        // jesli metod tych interfejsow nie mozna wykonac na obiekcie tej klasy
        // to albo ta klasa nie pasuje do WeedStatistics i nie powinna tego
        // rozszerzac, albo WeedStatistics robi za duzo na raz i powinna zostac
        // rozbita np na dwa interfejsy lub interfejs + klase abstrakcyjna
        bestPriceInterface = new DoNotExecuteAllStates();
        bestPriceForEachStateInterface = new DoNotExecuteForEachState();
        bestPriceByYearBetweenAllStatestInterface = new DoNotExecuteByYear();
        bestPriceByMonthBetweenAllStatesInterface = new DoNotExecuteByMonth();
        statisticsSortedByDate = new SortHighMediumLowPriceByDate(states);
    }
}
