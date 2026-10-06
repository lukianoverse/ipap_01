package exc02;

import static java.lang.Integer.parseInt;

public class BoltsAndNuts {
    static String STORAGE_1 = """
            1000 10 100
            1200 20 90
            """;
    static String STORAGE_2 = """
            5000 15 23
            4000 17 22
            """;

    static boolean isNotValid(String entry) {
        String[] parts = entry.split(" ");
        if (parts.length != 3) return true;
        int items = parseInt(parts[0]);
        int lost = parseInt(parts[1]);
        int price = parseInt(parts[2]);

        return items < 100 || items > 30000 || items % 100 != 0
                || lost < 0 || lost > 100
                || price < 1 || price > 100;
    }

    static int calculateDamage(String storageEntry) {
        String[] lines = storageEntry.split("\n");
        if (lines.length != 2 || isNotValid(lines[0]) || isNotValid(lines[1])) {
            IO.println("Ошибка в входных данных");
            return -1;
        }
        String[] boltsData = lines[0].split(" ");
        String[] nutsData = lines[1].split(" ");
        int boltsInitialAmount = parseInt(boltsData[0]);
        int boltsLostPercentage = parseInt(boltsData[1]);
        int boltsPrice = parseInt(boltsData[2]);
        int nutsInitialAmount = parseInt(nutsData[0]);
        int nutsLostPercentage = parseInt(nutsData[1]);
        int nutsPrice = parseInt(nutsData[2]);

        int boltsRemained = boltsInitialAmount * (100 - boltsLostPercentage) / 100;
        int nutsRemained = nutsInitialAmount * (100 - nutsLostPercentage) / 100;

        int suitableItems = Math.min(boltsRemained, nutsRemained);
        int lostBolts = boltsInitialAmount - suitableItems;
        int lostNuts = nutsInitialAmount - suitableItems;

        int totalDamage = lostBolts * boltsPrice + lostNuts * nutsPrice;

        return totalDamage;
    }

    void main() {
        String[] STORAGES = {STORAGE_1, STORAGE_2};
        for (String storage : STORAGES) {
            IO.println("Отчёт со склада:\n" + storage);
            IO.println("Сумма ущерба: " + calculateDamage(storage));
            IO.println();
        }
    }

}
