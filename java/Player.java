import javafx.scene.control.CheckBox;

import java.util.*;

public class Player {


    static List<Integer> playerPointsThrown = new ArrayList<>();
    public List<CheckBox> playerResultBox = new ArrayList<>();
    static int numberOfThrowsLeft;
    public List<CheckBox> lockedResultCheckboxes = new ArrayList<>();

    public int getNumberOfThrowsLeft() {
        return numberOfThrowsLeft;
    }

    private Map<String, Integer> playerCategoryPoints = new LinkedHashMap<String, Integer>() {{
        put("one", 0);
        put("two", 0);
        put("three", 0);
        put("four", 0);
        put("five", 0);
        put("six", 0);
        put("threeof", 0);
        put("fourof", 0);
        put("full", 0);
        put("small", 0);
        put("big", 0);
        put("general", 0);
        put("chance", 0);
    }};


    public Map<String, Integer> getPlayerCategoryPoints() {
        return playerCategoryPoints;
    }

    public void setPlayerCategoryPoints(String one, int i) {
        this.playerCategoryPoints.replace(one, i);
    }

    public static void setPlayerPointsThrown(int i, int i1, int i2, int i3, int i4) {
        if (PlayScene.lockedDices.isEmpty()) {
            playerPointsThrown.clear();
            playerPointsThrown.add(i);
            playerPointsThrown.add(i1);
            playerPointsThrown.add(i2);
            playerPointsThrown.add(i3);
            playerPointsThrown.add(i4);
        }

        else {
            if (PlayScene.lockedDices.contains(1)) {
                System.out.println("NO CHANGE");
            }
            else {
                playerPointsThrown.set(0, i);

            }
            if (PlayScene.lockedDices.contains(2)) {
                System.out.println("NO CHANGE");
            }
            else {
                playerPointsThrown.set(1, i1);
            }
            if (PlayScene.lockedDices.contains(3)) {
                System.out.println("NO CHANGE");
            }
            else {
                playerPointsThrown.set(2, i2);
            }
            if (PlayScene.lockedDices.contains(4)) {
                System.out.println("NO CHANGE");
            }
            else {
                playerPointsThrown.set(3, i3);
            }
            if (PlayScene.lockedDices.contains(5)) {
                System.out.println("NO CHANGE");
            }
            else {
                playerPointsThrown.set(4, i4);
            }
        }
    }

    public List<Integer> getPlayerPointsThrown() {
        return playerPointsThrown;
    }

    public void throwDices() {
        Random throwingDice = new Random();
        setPlayerPointsThrown(throwingDice.nextInt(1, 7),
                throwingDice.nextInt(1, 7),
                throwingDice.nextInt(1, 7),
                throwingDice.nextInt(1, 7),
                throwingDice.nextInt(1, 7));
        System.out.println(playerPointsThrown);
    }


}
