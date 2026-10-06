package exc03;

import static java.lang.Math.pow;

public class Dragons {


    int calculateTroopStrength(int headsTotal) {
        if (headsTotal <= 4)
            return headsTotal;

        int remainer = headsTotal % 3;
        return switch (remainer) {
            case 0 -> (int) pow(3, (double) headsTotal / 3);
            case 1 -> (int) (4 * pow(3, (double) (headsTotal - 4) / 3));
            case 2 -> (int) (2 * pow(3, (double) (headsTotal - 2) / 3));
            default -> 0;
        };

    }

    void main() {
        IO.println(calculateTroopStrength(6));
        IO.println(calculateTroopStrength(8));
        IO.println(calculateTroopStrength(13));
    }

}
