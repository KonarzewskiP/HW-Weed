package weedData;

public class Main {
    public static void main(String[] args) {
        DataImporter dataImporter = new DataImporter("D:\\JavaProjects\\SDA\\programowanie2\\" +
                "HW-Weed\\src\\main\\resources\\marijuana-street-price-clean.csv");
        WeedStatistics weedStatistics = new WeedStatistics(dataImporter.readStates());

/*        for (StateUSA state : weedStatistics.getStates()) {
            System.out.println(state.getStateName() + " = " + state.getStateAbbreviation());
        }*/

        weedStatistics.averageWeedPriceByState()
                .entrySet()
                .stream()
                .forEach(statesMap -> {
                    System.out.println(statesMap.getKey() + ":");
                    System.out.println("\tHigh = " + statesMap.getValue().getAverageHighPrice());
                    System.out.println("\tMedium = " + statesMap.getValue().getAverageMediumPrice());
                    System.out.println("\tLow = " + statesMap.getValue().getAverageLowPrice());
                });

/*        weedStatistics.stateWithBestHighPrice()
                .stream()
                .forEach(stateMap -> {
                    System.out.println(stateMap.getKey() + " : ");
                    System.out.printf("%.2f\n", stateMap.getValue().getAverageHighPrice());
                });
    }*/
    }
}
