import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;

import java.util.Map;

public class TopFrame extends TilePane {

    public static void calculatePoints(Player instancePlayer) {
        int counter = 0;
        for (Label pointsLabel : PlayScene.playerPointsCount) {
            Map<String, Integer> points = MainApp.playersInstances.get(counter).getPlayerCategoryPoints();
            int sumPoints = 0;
            for (int point: points.values()) {
                sumPoints = sumPoints + point;
            }
            pointsLabel.setFont(new Font("Calibri", 15));
            pointsLabel.setText(MainApp.playersNamesList.get(counter) + ": " + sumPoints + "  ");


            counter++;
        }
        PlayScene.throwsLeftLabel.setText("Throws remaining: " + String.valueOf(instancePlayer.getNumberOfThrowsLeft()));



    }



}




