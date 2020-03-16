package weedData;


import weedData.importing.DataImporter;
import weedData.weedStatistics.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        DataImporter dataImporter = new DataImporter("src/main/resources/marijuana-street-price-clean.csv");
        WeedStatistics weedStatisticsHighMedLowQuality = new WeedStatisticsHighMediumLowPrice(dataImporter.readStatesHighMediumLowQuality());
        WeedStatistics weedStatisticsHighQuality = new WeedStatisticsHighPrice(dataImporter.readStatesHighQuality());
        WeedStatistics weedStatisticsMedQuality = new WeedStatisticsMediumPrice(dataImporter.readStatesMediumQuality());
        WeedStatistics weedStatisticsLowQuality = new WeedStatisticsLowPrice(dataImporter.readStatesLowQuality());

///////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n>>>>>   Data for states with HIGH MEDIUM and LOW quality:    <<<<<\n");
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\nEx.1 - 5 States with the lowest average weed price of all time:");
        List<StateWithAvgPrices> lowestAveragePriceOfAllTime = weedStatisticsHighMedLowQuality.showBestAveragePrice(5);
        for (StateWithAvgPrices state : lowestAveragePriceOfAllTime) {
            System.out.println(state.getName() + "\n\t" + state.getAverageTotal());
        }

///////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n>>>>>   Data for states with HIGH quality:  <<<<<\n");
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Ex.2 - 5 best prices of high quality weed between all states:");
        List<StateUSA> highBestPrice = weedStatisticsHighQuality.showBestPriceOfWeed(5);
        for (StateUSA state : highBestPrice) {
            System.out.println(state.getStateName() + "\n\t" + state.getHighQuality() + " - " + state.getDate());
        }
//        System.out.println("\nHistorically best high quality price for each state:");
//        Map<String, Optional<StateUSA>> highBestEachState = weedStatisticsHighQuality.historicallyBestPriceForEachState();
//        for (Map.Entry<String,Optional<StateUSA>> state : highBestEachState.entrySet()){
//            System.out.println(state.getKey());
//            System.out.println("\t"+state.getValue().get().getHighQuality()+" - "+state.getValue().get().getDate());
//        }
        System.out.println("\nEx4. -The best prices of high quality weed between all states by year:");
        Map<Integer, Optional<StateUSA>> highBestByYear = weedStatisticsHighQuality.bestPriceBetweenAllStatesByYear();
        for (Map.Entry<Integer, Optional<StateUSA>> state : highBestByYear.entrySet()) {
            System.out.println(state.getKey());
            System.out.println("\t" + state.getValue().get().getStateName() + " "
                    + state.getValue().get().getHighQuality() + " - " + state.getValue().get().getDate());
        }
//        System.out.println("\nThe best prices of high quality weed between all states by a month:");
//        Map<Integer, Map<Integer, Optional<StateUSA>>> highBestByMonth = weedStatisticsHighQuality.bestPriceBetweenAllStatesByMonth();
//        for (Map.Entry<Integer, Map<Integer, Optional<StateUSA>>> state : highBestByMonth.entrySet()) {
//            System.out.println(state.getKey());
//            for (Map.Entry<Integer, Optional<StateUSA>> stateDate : state.getValue().entrySet()) {
//                System.out.println("\t" +stateDate.getKey());
//                System.out.println("\t\t" + stateDate.getValue().get().getStateName() + " " +
//                        stateDate.getValue().get().getHighQuality() + " - " + stateDate.getValue().get().getDate());
//            }
//        }
        System.out.println("\nEx.5 - High quality weed sorted by a date:".toUpperCase());
        List<StateUSA> highBestPriceSorted = weedStatisticsHighQuality.sortedByDate();
        for (StateUSA state : highBestPriceSorted) {
            System.out.println(state.getStateName() + "\n\t" + state.getHighQuality() + " - " + state.getDate());
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n>>>>>   Data for states with MEDIUM quality:    <<<<<\n");
///////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("The best prices of medium quality weed between all states:");
//        List<StateUSA> mediumBestPrice = weedStatisticsMedQuality.showBestPriceOfWeed(5);
//        for (StateUSA state : mediumBestPrice) {
//            System.out.println(state.getStateName()+"\n\t"+state.getMediumQuality()+" - "+state.getDate());
//        }
        System.out.println("\nEx3. - Historically best medium quality price for each state:".toUpperCase());
        Map<String, Optional<StateUSA>> mediumBestEachState = weedStatisticsMedQuality.historicallyBestPriceForEachState();
        for (Map.Entry<String, Optional<StateUSA>> state : mediumBestEachState.entrySet()) {
            System.out.println(state.getKey());
            System.out.println("\t" + state.getValue().get().getMediumQuality() + " - " + state.getValue().get().getDate());
        }
        System.out.println("\nEx4. -The best prices of medium quality weed between all states by year:");
        Map<Integer, Optional<StateUSA>> mediumBestByYear = weedStatisticsMedQuality.bestPriceBetweenAllStatesByYear();
        for (Map.Entry<Integer, Optional<StateUSA>> state : mediumBestByYear.entrySet()) {
            System.out.println(state.getKey());
            System.out.println("\t" + state.getValue().get().getStateName() + " "
                    + state.getValue().get().getMediumQuality() + " - " + state.getValue().get().getDate());
        }
        System.out.println("\nEx.4* - The best prices of medium quality weed between all states by a month:".toUpperCase());
        Map<Integer, Map<Integer, Optional<StateUSA>>> mediumBestByMonth = weedStatisticsMedQuality.bestPriceBetweenAllStatesByMonth();
        for (Map.Entry<Integer, Map<Integer, Optional<StateUSA>>> state : mediumBestByMonth.entrySet()) {
            System.out.println(state.getKey());
            for (Map.Entry<Integer, Optional<StateUSA>> stateDate : state.getValue().entrySet()) {
                System.out.println("\t" + stateDate.getKey());
                System.out.println("\t\t" + stateDate.getValue().get().getStateName() + " " +
                        stateDate.getValue().get().getMediumQuality() + " - " + stateDate.getValue().get().getDate());
            }

        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n>>>>>   Data for states with LOW quality:    <<<<<\n");
        //////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("The best prices of low quality weed between all states:");
//        List<StateUSA> lowBestPrice = weedStatisticsLowQuality.showBestPriceOfWeed(5);
//        for (StateUSA state : lowBestPrice) {
//            System.out.println(state.getStateName()+"\n\t"+state.getLowQuality()+" - "+state.getDate());
//        }
//        System.out.println("\nHistorically best low quality price for each state:");
//        Map<String, Optional<StateUSA>> lowBestEachState = weedStatisticsLowQuality.historicallyBestPriceForEachState();
//        for (Map.Entry<String,Optional<StateUSA>> state : lowBestEachState.entrySet()){
//            System.out.println(state.getKey());
//            System.out.println("\t"+state.getValue().get().getLowQuality()+" - "+state.getValue().get().getDate());
//        }
        System.out.println("\nEx.4 - The best prices of low quality weed between all states by year:".toUpperCase());
        Map<Integer, Optional<StateUSA>> lowBestByYear = weedStatisticsLowQuality.bestPriceBetweenAllStatesByYear();
        for (Map.Entry<Integer, Optional<StateUSA>> state : lowBestByYear.entrySet()) {
            System.out.println(state.getKey());
            System.out.println("\t" + state.getValue().get().getStateName() + " " + state.getValue().get().getLowQuality() + " - " + state.getValue().get().getDate());
        }
        System.out.println("\nEx.5 - High quality weed sorted by a date:".toUpperCase());
//        List<StateUSA> lowBestPriceSorted = weedStatisticsLowQuality.sortedByDate();
//        for (StateUSA state : lowBestPriceSorted) {
//            System.out.println(state.getStateName()+"\n\t"+state.getLowQuality()+" - "+state.getDate());
//        }
//        System.out.println("\nThe best prices of low quality weed between all states by a month:");
//        Map<Integer, Map<Integer, Optional<StateUSA>>> lowBestByMonth = weedStatisticsLowQuality.bestPriceBetweenAllStatesByMonth();
//        for (Map.Entry<Integer, Map<Integer, Optional<StateUSA>>> state : lowBestByMonth.entrySet()) {
//            System.out.println(state.getKey());
//            for (Map.Entry<Integer, Optional<StateUSA>> stateDate : state.getValue().entrySet()) {
//                System.out.println("\t" +stateDate.getKey());
//                System.out.println("\t\t" + stateDate.getValue().get().getStateName() + " " +
//                        stateDate.getValue().get().getLowQuality() + " - " + stateDate.getValue().get().getDate());
//            }
//
//        }
    }
}
//        1. Sprawdź, który stan ma ogółem najlepsze średnie ceny trawy. (ignoruj wpisy, dla których brakuje danych)
//        2. Pokaż 5 najniższych cen wysokiej jakości palenia.
//        3. Pokaż historycznie najlepszą cenę średniej jakości zielska dla każdego stanu.
//        4. Na każdy możliwy rok pokaż stan, w którym dało się najtaniej kupić jakikolwiek towar.
//        4*(dla ambitnych). To samo co wyżej tylko na każdy dostępny "rok-miesiąc"
//        5. Posortuj wpisy latami.