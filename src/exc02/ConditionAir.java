package exc02;

import java.util.Set;

public class ConditionAir {
    static String SITUATION_1 = """
            10 20
            heat
            """;
    static String SITUATION_2 = """
            10 20
            freeze
            """;

    static final Set<String> MODES =
            Set.of("freeze", "heat", "auto", "fan");

    static boolean isNotValid(int roomT, int desiredT, String mode) {
        return roomT < -50 || roomT > 50 || desiredT < -50 || desiredT > 50
                || !MODES.contains(mode);
    }

    static String runConditioningForAnHour(String command) {
        String[] parts = command.split("\\s+");
        int roomT = Integer.parseInt(parts[0]);
        int desiredT = Integer.parseInt(parts[1]);
        String mode = parts[2];

        if (isNotValid(roomT, desiredT, mode)) {
            return "Некорректные данные";
        }

        int resultingT = roomT; // если вовсе не станет работать, Т останется прежней

        switch (mode) {
            case "freeze":
                resultingT = Math.min(roomT, desiredT);
                break;
            case "heat":
                resultingT = Math.max(roomT, desiredT);
                break;
            case "auto":
                resultingT = desiredT;
                break;
            case "fan":
                break;
        }


        return "Температура в комнате через час: " + resultingT;
    }

    void main() {
        IO.println("1.\n" + SITUATION_1 + runConditioningForAnHour(SITUATION_1));
        IO.println();
        IO.println("2.\n" + SITUATION_2 + runConditioningForAnHour(SITUATION_2));
    }
}
