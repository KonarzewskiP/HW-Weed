package weedData;


import weedData.importing.DataImporter;
import weedData.weedStatistics.*;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataImporter dataImporter = new DataImporter("D:\\JavaProjects\\SDA\\programowanie2\\" +
                "HW-Weed\\src\\main\\resources\\marijuana-street-price-clean.csv");
        WeedStatistics weedStatisticsHighMedLowQuality = new WeedStatisticsHighMediumLowPrice(dataImporter.readStatesHighMediumLowQuality());
        WeedStatistics weedStatisticsHighQuality = new WeedStatisticsHighPrice(dataImporter.readStatesHighQuality());
        WeedStatistics weedStatisticsMedQuality = new WeedStatisticsMediumPrice(dataImporter.readStatesMediumQuality());
        WeedStatistics weedStatisticsLowQuality = new WeedStatisticsLowPrice(dataImporter.readStatesLowQuality());

        System.out.println("\n>>>>>   Data states with HIGH MEDIUM and LOW quality:    <<<<<\n");
        Map<String ,StateWithAvgPrices> statesWithAvgPrices = weedStatisticsHighMedLowQuality.generatePriceList();
        for (Map.Entry<String, StateWithAvgPrices> st :statesWithAvgPrices.entrySet()) {
            System.out.println(st.getKey());
            System.out.println("H:"+st.getValue().getAvgHigh()+"/M:"+st.getValue().getAvgMedium()+"/L:"+st.getValue().getAvgHigh());
        }
//
//        System.out.println("\nState with the lowest average weed price of all time:");
//        StateWithAvgPrices lowestAveragePriceOfAllTime = weedStatisticsHighMedLowQuality.stateWithTheLowestAverageWeedPrice();
//        System.out.println(lowestAveragePriceOfAllTime.getName()+"\n\t"+lowestAveragePriceOfAllTime.getAvgHigh());


        System.out.println("\n>>>>>   Data states with HIGH  quality:  <<<<<\n");
        System.out.println("(n) States with the best price of high quality weed:");
        List<StateWithAvgPrices> statesWithBestHighQualityPrice = weedStatisticsHighQuality.sortedNumberStatesWithBestHighQualityPrice(5);
        for (StateWithAvgPrices state : statesWithBestHighQualityPrice) {
            System.out.println(state.getName()+"\n\t"+state.getAvgHigh());
        }

        System.out.println("\n>>>>>   Data states with MEDIUM  quality:    <<<<<\n");

        System.out.println("\n>>>>>   Data states with LOW quality:    <<<<<\n");

    }
}
//        1. Sprawdź, który stan ma ogółem najlepsze średnie ceny trawy. (ignoruj wpisy, dla których brakuje danych)
//        2. Pokaż 5 najniższych cen wysokiej jakości palenia.
//        3. Pokaż historycznie najlepszą cenę średniej jakości zielska dla każdego stanu.
//        4. Na każdy możliwy rok pokaż stan, w którym dało się najtaniej kupić jakikolwiek towar.
//        4*(dla ambitnych). To samo co wyżej tylko na każdy dostępny "rok-miesiąc"
//        5. Posortuj wpisy latami.