package exc03;

import java.util.stream.IntStream;

public class JumpTripper {

    static double distance(Point a, Point b) {
        return Math.hypot(a.x() - b.x(), a.y() - b.y());
    }

    static boolean isFrogReachable(Point point, Point frogPosition, int tongueLength) {
        return distance(point, frogPosition) <= tongueLength;
    }

    // наконец-то мы прошли стремы́, и стало можно их использовать!
    static int findDevourmentPoint(Point[] points, Point frogPosition, int tongueLength) {
        return IntStream.range(0, points.length)
                .filter(i -> isFrogReachable(points[i], frogPosition, tongueLength))
                .findFirst()
                .orElse(-1)
                + 1;
    }

    static void analyzeSituation(String input) {
        if (input == null || input.isBlank()) {
            IO.println("пустая ситуация");
            return;
        }
        String[] lines = input.split("\n");
        String[] values = lines[0].split(" ");
        if (values.length != 4) {
            IO.println("в первой строке не четыре значения");
            return;
        }
        int numberOfPoints = Integer.parseInt(values[0]);
        if (numberOfPoints != lines.length - 1) {
            IO.println("количество заявленных и определённых точек не совпадает");
            return;
        }
        Point frogPosition = new Point(Integer.parseInt(values[1]), Integer.parseInt(values[2]));
        int tongueLength = Integer.parseInt(values[3]);

        Point[] points = new Point[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            String[] data = lines[i + 1].split(" ");
            if (data.length != 2) {
                IO.println("в строке %d не две координаты".formatted(i + 2));
                return;
            }
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            points[i] = new Point(a, b);
        }
        int devourmentPoint = findDevourmentPoint(points, frogPosition, tongueLength);
        IO.println(
                devourmentPoint == 0 ?
                        "Yes" :
                        devourmentPoint
        );
    }

    void main() {
        String[] SITUATIONS = {
                """
                3 0 0 1
                2 0
                1 1
                0 1
                """,
                """
                2 0 0 100
                1 1
                2 2
                """,
                """
                3 0 0 1
                1 1
                2 2
                3 3
                """
        };
        for (String situation : SITUATIONS)
            analyzeSituation(situation);
    }

}

record Point(int x, int y) {
}