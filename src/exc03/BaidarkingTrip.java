package exc03;

import java.util.Arrays;
import java.util.Scanner;

public class BaidarkingTrip {

    static Scanner input = new Scanner(System.in);
    static int casesCount = 0;

    /**
     * Преобразует строку в массив целых чисел.
     *
     * @param text           исходная строка, содержащая числа через пробел
     * @param expectedAmount ожидаемое количество чисел; если не равно 0, то
     *                       количество значений в строке должно быть равно ему.
     * @return массив целых чисел, извлечённых из строки
     * @throws RuntimeException      если текст пуст, или количество чисел не совпадает
     *                               с ожидаемым (при expectedAmount != 0)
     * @throws NumberFormatException если в строке встретится нечисловое значение
     */
    static int[] parseNumbers(String text, int expectedAmount) {
        if (text.isEmpty())
            throw new RuntimeException("Ввод ничего не содержит");

        String[] parts = text.trim().split("\\s+");

        if (expectedAmount != 0 && parts.length != expectedAmount)
            throw new RuntimeException("Здесь надо именно %d чисел, а получено %d"
                    .formatted(expectedAmount, parts.length));

        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            result[i] = Integer.parseInt(parts[i]);
        return result;
    }

    /**
     * Получает ввод от пользователя.
     *
     * @param prompt          приглашение, выводимое пользователю
     * @param argumentsAmount ожидаемое количество аргументов
     * @return полученный от пользователя массив целых чисел
     */
    static int[] getInput(String prompt, int argumentsAmount) {
        IO.println(prompt);
        return parseNumbers(input.nextLine(), argumentsAmount);
    }

    /**
     * Получает ввод от пользователя.
     *
     * @param prompt приглашение, выводимое пользователю
     * @return полученный от пользователя массив целых чисел
     */
    static int[] getInput(String prompt) {
        return getInput(prompt, 0);
    }

    /**
     * Вычисляет минимально необходимое количество байдарок для путешествия.
     *
     * <p>Функция сортирует полученные {@code веса́ пассажиров} и рассказывает,
     * как она рассаживает пассажиров по лодкам (стараясь объединить самого
     * толстого с самым тощим в один экипаж).</p>
     *
     * @param weights  массив с массами пассажиров
     * @param carrying грузоподъемность одной байдарки
     * @return минимально необходимое для путешествия количество лодок;
     * возвращает {@code 0}, если нет пассажиров, или если вес кого-то
     * из них превышает грузоподъёмность плавсредства.
     */
    static int calculateKayaks(int[] weights, int carrying) {
        if (weights.length == 0) {
            IO.println("Нет пассажиров — не нужны и лодки.");
            return 0;
        }
        Arrays.sort(weights);
        if (weights[weights.length - 1] > carrying) {
            IO.println("Нужно пересмотреть список участников," +
                    " так как чья-то масса превышает грузоподъемность плавсредства.");
            return 0;
        }

        int lightestIndex = 0;
        int heaviestIndex = weights.length - 1;
        int kayakNumber = 0;

        while (lightestIndex <= heaviestIndex) {
            kayakNumber++;
            int heaviest = weights[heaviestIndex];
            int load = heaviest;
            IO.print("Садим в %d-ую байдарку путешественника с массой %d"
                    .formatted(kayakNumber, heaviest));
            int lightest = weights[lightestIndex];
            if (lightest + heaviest <= carrying) {
                load += lightest;
                IO.print(" и с массой %d".formatted(lightest));
                lightestIndex++;
            }
            heaviestIndex--;
            IO.println(" (загрузка %d%%)"
                    .formatted(Math.round(load * 100.0 / carrying)));
        }

        return kayakNumber;
    }

    static void processCase(String inputBlock) {
        IO.println(inputBlock);
        String[] lines = inputBlock.strip().split("\n");
        if (lines.length != 2) {
            IO.println("Некорректные данные.");
            return;
        }

        int[] params = parseNumbers(lines[0], 2);
        int groupSize = params[0];
        int carrying = params[1];
        int[] weights = parseNumbers(lines[1], groupSize);

        processCase(groupSize, carrying, weights);
    }

    static void processCase(int groupSize, int carrying, int[] weights) {
        IO.println("Группа №" + ++casesCount);
        if (weights.length != groupSize) {
            IO.println("Некорректные данные.");
            return;
        }
        int result = calculateKayaks(weights, carrying);
        IO.println("Минимальное количество байдарок для такой группы: " + result + "\n");
    }

    void main() {
        processCase("""
                4 135
                50 74 60 82
                """);
        processCase("""
                6 135
                50 120 74 60 100 82
                """);
        while (true) {
            IO.println("Нажмите 'Ввод' для ввода ещё одной группы");
            if (!IO.readln().isBlank())
                break;

            int[] params = getInput(
                    "Введите размер группы и грузоподъёмность через пробел",
                    2);
            int groupSize = params[0];
            int carrying = params[1];

            int[] weights = getInput("Введите через пробел веса́ " +
                    "собирающихся в байдарочное путешествие: ", groupSize);
            processCase(groupSize, carrying, weights);
        }


    }
}
