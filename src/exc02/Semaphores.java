package exc02;

import java.util.Arrays;

public class Semaphores {
    static String INPUT = """
                        7 10
                        5 1
                        3 2
                        7 1
                        5 2
                        7 4
                        6 5
                        6 4
                        7 5
                        2 1
                        5 3
                        """;

    static int N, M;


    /**
     * Анализирует и валидирует входные данные.
     * Первая строка должна содержать целые N и M, где N это количество
     * узлов, а M это количество тоннелей. Следующие M строк содержат
     * описание тоннелей. Функция устанавливает статические N и M
     * и возвращает обрезанные строки тоннелей.
     *
     * @param input сырой ввод согласно условию с сайта acmp.ru
     * @return массив из M строк, описывающих тоннель, если входные данные
     * валидны, иначе, если валидация провалена, — {@code null}
     */
    static String[] prepareTunnels(String input) {
        String[] lines = input.split("\n");
        String[] baseValues = lines[0].trim().split("\\s+");
        N = Integer.parseInt(baseValues[0]);
        M = Integer.parseInt(baseValues[1]);

        // удостоверяем, что узлов от 1 до 100
        if (N <= 0 || N > 100) return null;
        // удостоверяем, что тоннелей от 0 до N(N-1)/2 (т.е. 4950)
        if (M < 0 || M > N * (N - 1) / 2) return null;
        // удостоверяем, что количество строк тоннелей
        // соответствует их заявленному количеству
        if (lines.length != M + 1) return null;

        String[] tunnels = new String[M]; // модель сырых тоннелей
        for (int i = 1; i <= M; i++)
            tunnels[i - 1] = lines[i].trim();

        return tunnels;
    }

    /**
     * Подсчитывает количество семафоров для каждого узла.
     * Каждый тоннель задаётся строкой вида "a b", где a и b — номера узлов.
     * Для каждого тоннеля увеличиваются счётчики семафоров на обоих его концах.
     *
     * @param tunnels массив строк с описанием тоннелей
     * @return строковое представление массива счётчиков семафоров;
     *         либо {@code null}, если координаты выходят за пределы
     *         существующего диапазона узлов 1..N
     */
    static String countSemaphores(String[] tunnels) {
        int[] semaphores = new int[N]; // модель узлов
        for (String tunnel : tunnels) {
            String[] values = tunnel.split("\\s+");
            if (values.length != 2) return null;
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);

            // удостоверяем, что координаты концов тоннелей
            // соответствуют существующим узлам
            if (a < 1 || a > N || b < 1 || b > N)
                return null;

            semaphores[a - 1]++;
            semaphores[b - 1]++;
        }
        return Arrays.toString(semaphores);
    }


    void main() {
        String[] tunnelLines = prepareTunnels(INPUT);
        if (tunnelLines == null) {
            IO.println("Некорректное описание структуры данных");
            return;
        }
        String semaphoresReport = countSemaphores(tunnelLines);
        if (semaphoresReport == null) {
            IO.println("Некорректные данные тоннелей");
            return;
        }
        IO.println("Мышиный король повелел светофоризировать "
                + N + " узлов, связываемых " + M + " тоннелями.\n"
                + "Количество светофоров на узлах по их порядку: " + semaphoresReport);
    }
}
