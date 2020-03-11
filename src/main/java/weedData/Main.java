package weedData;

public class Main {
    public static void main(String[] args) {
        DataImporter dataImporter = new DataImporter("D:\\JavaProjects\\SDA\\programowanie2\\" +
                "HW-Weed\\src\\main\\resources\\marijuana-street-price-clean.csv");
        WeedStatistics weedStatistics = new WeedStatistics(dataImporter.readStates());

        for (StateUSA s :weedStatistics.getStates()) {
            System.out.println(s);
        }

    }
}
