package kr01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KR2_Lukianov {
    /*
        Написать код, который решает следующие задачи:

        1. Запросить у пользователя параметры (длину и ширину)
         ДВУХ Прямоугольников. Вывести сумму площадей этих фигур.

        2. Запросить у пользователя параметры (длину и ширину)
         ТРЕХ Прямоугольников, сравнить их периметры.
         Если все периметры равны, вывести "все периметры равны"
         Если любые 2 периметра равны, вывести "два периметра равны"
         Если все периметры разные вывести "периметры разные"

        3. Запросить у пользователя параметры (длину и ширину)
         5 Прямоугольников
         Вычислить и вывести среднюю площадь.
     */
    static Scanner input = new Scanner(System.in);

    static class Rectangle {
        int length;
        int width;

        Rectangle(int length, int width) {
            this.length = length;
            this.width = width;
        }

        int getArea() {
            return length * width;
        }

        int getPerimeter() {
            return 2 * (length + width);
        }
    }

    static Rectangle[] requestRectanglesFromUser(int howMany) {
        Rectangle[] data = new Rectangle[howMany];
        for (int i = 0; i < howMany; i++) {
            IO.println("Введи длину и ширину прямоугольника №%d через пробел:".formatted(i + 1));
            String[] parts = input.nextLine().split(" ");
            int length = Integer.parseInt(parts[0]);
            int width = Integer.parseInt(parts[1]);
            data[i] = new Rectangle(length, width);
        }
        return data;
    }

    static void task01() {
        Rectangle[] data = requestRectanglesFromUser(2);
        int totalArea = 0;
        for (Rectangle r : data)
            totalArea += r.getArea();
        IO.println("Сумма их площадей " + totalArea);
    }

    private void task02() {
        Rectangle[] data = requestRectanglesFromUser(3);
        int perimeter1 = data[0].getPerimeter();
        int perimeter2 = data[1].getPerimeter();
        int perimeter3 = data[2].getPerimeter();

        String verdict = "периметры разные";
        if (perimeter1 == perimeter2 && perimeter2 == perimeter3)
            verdict = "все периметры равны";
        else if (perimeter1 == perimeter2 || perimeter1 == perimeter3 || perimeter2 == perimeter3)
            verdict = "два периметра равны";

        IO.println(verdict);

        Set<Integer> perimeters = new HashSet<>();
        for (Rectangle r : data)
            perimeters.add(r.getPerimeter());
        switch (perimeters.size()) {
            case 1:
                IO.println("все периметры равны");
                break;
            case 2:
                IO.println("два периметра равны");
                break;
            default:
                IO.println("периметры разные");
        }

    }

    private void task03() {
        Rectangle[] data = requestRectanglesFromUser(5);
        double totalArea = 0;
        for (Rectangle r : data)
            totalArea += r.getArea();
        IO.println("Средняя площадь " + totalArea / data.length);
    }

    void main() {
        task01();
        task02();
        task03();
    }
}
