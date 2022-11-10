import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainEngine {

    public static String onesCalc() {
        return String.valueOf(Collections.frequency(Player.playerPointsThrown, 1));

    }

    public static String twosCalc() {
        return String.valueOf((Collections.frequency(Player.playerPointsThrown, 2)) * 2);

    }

    public static String threesCalc() {
        return String.valueOf((Collections.frequency(Player.playerPointsThrown, 3)) * 3);

    }

    public static String foursCalc() {
        return String.valueOf((Collections.frequency(Player.playerPointsThrown, 4)) * 4);

    }

    public static String fivesCalc() {
        return String.valueOf((Collections.frequency(Player.playerPointsThrown, 5)) * 5);

    }
    public static String sixesCalc() {
        return String.valueOf((Collections.frequency(Player.playerPointsThrown, 6)) * 6);

    }

    public static String threeOfKindCalc() {
        String result = "0";
        for (int throwResult : Player.playerPointsThrown) {
            if (Collections.frequency(Player.playerPointsThrown, throwResult) > 2) {
                result = String.valueOf(throwResult * 3);
            }

        }
        return result;
    }

    public static String fourOfKindCalc() {
        String result = "0";
        for (int throwResult : Player.playerPointsThrown) {
            if (Collections.frequency(Player.playerPointsThrown, throwResult) > 3) {
                result = String.valueOf(throwResult * 4);
            }

        }
        return result;
    }

    public static String fullHouseCalc() {
        String result = "0";
        for (int throwThree : Player.playerPointsThrown) {
            if (Collections.frequency(Player.playerPointsThrown, throwThree) == 3) {
                for (int throwTwo : Player.playerPointsThrown) {
                    if ((Collections.frequency(Player.playerPointsThrown, throwTwo) == 2) && throwTwo != throwThree) {
                        result = "25";
                    }
                }
            }
        }
        return result;
    }

    public static String smallStraightCalc() {
        String result = "0";
        if (Player.playerPointsThrown.containsAll(Arrays.asList(1, 2, 3, 4, 5)) && !Player.playerPointsThrown.contains(0)) {
            result = "30";
        }
        return result;
    }

    public static String largeStraightCalc() {
        String result = "0";
        if (Player.playerPointsThrown.containsAll(Arrays.asList(2, 3, 4, 5, 6)) && !Player.playerPointsThrown.contains(0)) {
            result = "40";
        }
        return result;
    }

    public static String generalCalc() {
        String result = "0";
        for (int throwResult : Player.playerPointsThrown) {
            if (Collections.frequency(Player.playerPointsThrown, throwResult) > 4 && !Player.playerPointsThrown.contains(0)) {
                result = "50";
            }
        }
        return result;
    }

    public static String chanceCalc() {
        int result = 0;
        for (int throwResult : Player.playerPointsThrown) {
            result = result + throwResult;
        }
        return String.valueOf(result);
    }

}
