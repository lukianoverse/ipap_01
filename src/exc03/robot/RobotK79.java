package exc03.robot;

import java.util.HashSet;
import java.util.Set;

import static exc03.robot.Direction.*;

public class RobotK79 {

    final static Position HOME = new Position(0, 0);
    static Set<Position> travelled = new HashSet<>();
    static Position currentPosition;
    static Direction currentDirection;
    static boolean intersectionFound;

    static void reset() {
        travelled.clear();
        currentPosition = HOME;
        travelled.add(currentPosition);
        currentDirection = UP;
        intersectionFound = false;
    }

    static {
        reset();
    }

    static void makeAStep(Direction direction) {
        Position destination;
        switch (direction) {
            case UP -> destination = currentPosition.getUp();
            case RIGHT -> destination = currentPosition.getRight();
            case DOWN -> destination = currentPosition.getDown();
            case LEFT -> destination = currentPosition.getLeft();
            default -> destination = currentPosition;
        }
        if (travelled.contains(destination))
            intersectionFound = true;
        currentPosition = destination;
        travelled.add(currentPosition);
    }

    static void runACommand(char input) {
        switch (input) {
            case 'L' -> currentDirection = Direction.values()[(currentDirection.ordinal() + 3) % 4];
            case 'S' -> makeAStep(currentDirection);
            case 'R' -> currentDirection = Direction.values()[(currentDirection.ordinal() + 1) % 4];
            default -> IO.println("неизвестная команда " + input);
        }
    }

    static long findFirstIntersection(String route) {
        char[] commands = route.toCharArray();
        int stepsCounter = 0;
        for (char command : commands) {
            if (command == 'S')
                stepsCounter++;
            runACommand(command);
            if (intersectionFound)
                return stepsCounter;
        }
        return -1;
    }


    static void main() {
        String ROUTE_1 = "SSLSLSLSSRSRS";
        String ROUTE_2 = "LSSSS";

        IO.print("Путь: " + ROUTE_1);
        IO.println(" Пересечение на: " + findFirstIntersection(ROUTE_1));

        reset();
        IO.print("Путь: " + ROUTE_2);
        IO.println(" Пересечение на: " + findFirstIntersection(ROUTE_2));

    }


}

