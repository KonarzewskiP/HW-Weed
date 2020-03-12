package weedData;


import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataImporter dataImporter = new DataImporter("D:\\JavaProjects\\SDA\\programowanie2\\" +
                "HW-Weed\\src\\main\\resources\\marijuana-street-price-clean.csv");
        WeedStatistics weedStatistics = new WeedStatistics(dataImporter.readStates());



        Map<String ,StateWithAvgPrices> statesWithAvgPrices = weedStatistics.statesWithAvgPricesList();
        for (Map.Entry<String, StateWithAvgPrices> st :statesWithAvgPrices.entrySet()) {
            System.out.println(st.getKey());
            System.out.println("H:"+st.getValue().getAvgHigh()+"/M:"+st.getValue().getAvgMedium()+"/L:"+st.getValue().getAvgHigh());
        }

        System.out.println(weedStatistics.stateWithBestHighWeedPrice());
    }
}
//        1. Sprawdź, który stan ma ogółem najlepsze średnie ceny trawy. (ignoruj wpisy, dla których brakuje danych)
//        2. Pokaż 5 najniższych cen wysokiej jakości palenia.
//        3. Pokaż historycznie najlepszą cenę średniej jakości zielska dla każdego stanu.
//        4. Na każdy możliwy rok pokaż stan, w którym dało się najtaniej kupić jakikolwiek towar.
//        4*(dla ambitnych). To samo co wyżej tylko na każdy dostępny "rok-miesiąc"
//        5. Posortuj wpisy latami.