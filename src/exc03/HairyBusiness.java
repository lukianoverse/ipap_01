package exc03;

import java.util.Arrays;

public class HairyBusiness {

    /*    ☮     ☮     ☮     ☮     ☮     ☮     ☮     ☮     ☮     ☮     ☮     ☮
    ☮   Was she told when she was young that pain would lead to pleasure?
        Did she understand it when they said                                ☮
    ☮   That a man must SELL HIS HAIR to earn his day of leisure?
        Will she still believe it when he's dead?                           ☮
    ☮    ☮     ☮     ☮     ☮     ☮     ☮     ☮     ☮     ☮     ☮     ☮     */

    /**
     * Говорит, будет ли ещё до конца периода день с ценой не меньшей,
     * чем цена на текущий день.
     *
     * @param day  индекс текущего дня
     * @param span массив с ценами по дням
     * @return {@code ИСТИННО}, если существует индекс {@code i > day}, при котором
     * {@code span[i] >= span[day]}, иначе {@code ЛОЖНО}
     */
    static boolean willBeBetter(int day, int[] span) {
        for (int i = day + 1; i < span.length; i++)
            if (span[day] <= span[i])
                return true;
        return false;
    }

    /**
     * Вычисляет максимально возможный куш от аналитической торговли хаером.
     *
     * <p>Хаер отрастает по одному пункту в день. Для каждого дня {@code i} функция проверяет,
     * будет ли до конца периода лучшая (или такая же) цена, прибегая к {@code willBeBetter(i, prices)}.
     * Если лучшей цены уже не будет, в этот день {@code i} волосы состригаются и продаются
     * по текущей цене, выручка добавляется в карман.</p>
     *
     * @param prices цены на каждый день расчётного периода
     * @return количество средств на кармане по истечении периода
     */
    static int earnMaximum(int[] prices) {
        int earning = 0;
        int lastHaircutDay = -1;

        for (int i = 0; i < prices.length; i++)
            if (!willBeBetter(i, prices)) {
                earning += prices[i] * (i - lastHaircutDay);
                lastHaircutDay = i;
            }

        return earning;
    }
    // на самом деле если будущая цена незначительно ниже текущей,
    // то при некоторых условиях всё равно выгодно её подождать,
    // но для этого нужен дополнительный расчёт (больше ли дней
    // проходит, чем разница) — который нам делать лень
    /*
        Everybody seems to think I'm lazy
        I don't mind, I think they're crazy
        Running everywhere at such a speed
        Till they find, there's no need
     */


    void main(String[] args) {

        int[] SPAN_1 = {73, 31, 96, 24, 46};
        int[] SPAN_2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] SPAN_3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        var CASES = new int[][]{SPAN_1, SPAN_2, SPAN_3};

        for (var span : CASES) {
            IO.print("Це́ны по дням: " + Arrays.toString(span));
            IO.println(" Выручка: " + earnMaximum(span));
        }

    }
}
