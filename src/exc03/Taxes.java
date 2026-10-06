package exc03;

public class Taxes {

    /**
     * Определяет, какая из фирм больше всех даёт в бюджет.
     * @param companies список фирм, платящих налоги.
     *
     * @return порядковый номер в списке, соответствующий фирме,
     *      которая должна быть признана лучшим налогоплательщиком.
     *      Если таких фирм несколько, номер наименьший из номеров.
     *      Если список пуст, возвращается 0.
     */
    static int findChampion(TaxationCase companies) {
        int maxProceeds = 0;
        int bestTaxpayerIndex = -1;
        for (int i = 0; i < companies.incomes.length; i++) {
            int proceeds = companies.incomes[i] * companies.rates[i];
            if (proceeds > maxProceeds) {
                maxProceeds = proceeds;
                bestTaxpayerIndex = i;
            }
        }
        // в расчётах процентов деления на 100 не производится, ибо,
        // во-первых, по условиям задачи, налоговики НЕ изучали математику,
        // во-вторых, это никак не сказывается на результате вычислений.
        return bestTaxpayerIndex + 1;
    }


    void main() {
        IO.println(findChampion(new TaxationCase(new int[]{1}, new int[]{1})));
        IO.println(findChampion(new TaxationCase(new int[]{1, 2}, new int[]{3, 2})));
        IO.println(findChampion(new TaxationCase(new int[]{100, 1, 50}, new int[]{0, 100, 3})));
    }

    /**
     * Запись, представляющая отчёт о сборе налогов с ряда фирм в Некотором Государстве.
     * Содержит целочисленный массив собранных с каждой фирмы за текущий отчётный период
     * сумм и параллельный ему целочисленный массив ставок налогообложения, применявшихся
     * к каждой из них. Количество фирм в отчёте соответствует длине каждого из этих массивов.
     * Номер фирмы соответствует {@code i + 1}, где {@code i} - индекс в массиве.
     *
     * @param incomes an array of income values
     * @param rates   an array of tax rates corresponding to each income
     */
    record TaxationCase(int[] incomes, int[] rates) {}
}

