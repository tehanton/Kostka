import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

public class GeneratingElements {
    // checking zero results - if selected on purpose by the player
    public static boolean checkingZeroRes(Player currentInstance, Integer number) {
        if (currentInstance.playerResultBox.isEmpty() || currentInstance.playerResultBox.get(number).isDisabled()) {
            return false;
        }
        else return true;
    }

    public static GridPane addName(GridPane scenaLewa, String nameOfThePlayer, Player playerInstance) {
        scenaLewa.getChildren().removeIf(n -> n instanceof Label);

        Map<String, Integer> playerResultsMap = playerInstance.getPlayerCategoryPoints();

        Label labelName = new Label("Now playing: " + nameOfThePlayer);
        labelName.setPadding(new Insets(6));
        labelName.setFont(new Font("Arial Black", 14));
        scenaLewa.add(labelName, 1, 1, 4, 1);

        Label onesName = new Label("   One: ");
        scenaLewa.add(onesName, 2, 3);

        Label pane = new Label(" ");
        scenaLewa.add(pane, 1, 2);

        if (playerResultsMap.get("one").equals(0) & GeneratingElements.checkingZeroRes(playerInstance, 0))
        {
            System.out.println("HERE IS TEST");
            //System.out.println(playerInstance.playerResultBox);
            Label onesResult = new Label(MainEngine.onesCalc());
            scenaLewa.add(onesResult, 4, 3);
        }
        else {
            Label oneResult = new Label(String.valueOf(playerResultsMap.get("one")));
            scenaLewa.add(oneResult, 4, 3);
        }

        Label twosName = new Label("   Two: ");
        scenaLewa.add(twosName, 2, 4);

        if (playerResultsMap.get("two").equals(0)) {
            Label twosResult = new Label(MainEngine.twosCalc());
            scenaLewa.add(twosResult, 4, 4);
        }
        else {
            Label twosResult = new Label(String.valueOf(playerResultsMap.get("two")));
            scenaLewa.add(twosResult, 4, 4);
        }

        Label threesName = new Label("   Three: ");
        scenaLewa.add(threesName, 2, 5);

        if (playerResultsMap.get("three").equals(0)) {
            Label threesResult = new Label(MainEngine.threesCalc());
            scenaLewa.add(threesResult, 4, 5);
        }
        else {
            Label threesResult = new Label(String.valueOf(playerResultsMap.get("three")));
            scenaLewa.add(threesResult, 4, 5);
        }

        Label foursName = new Label("   Four: ");
        scenaLewa.add(foursName, 2, 6);

        if (playerResultsMap.get("four").equals(0)) {
            Label foursResult = new Label(MainEngine.foursCalc());
            scenaLewa.add(foursResult, 4, 6);
        }
        else {
            Label foursResult = new Label(String.valueOf(playerResultsMap.get("four")));
            scenaLewa.add(foursResult, 4, 6);
        }

        Label fivesName = new Label("   Five: ");
        scenaLewa.add(fivesName, 2, 7);

        if (playerResultsMap.get("five").equals(0)) {
            Label fivesResult = new Label(MainEngine.fivesCalc());
            scenaLewa.add(fivesResult, 4, 7);
        }
        else {
            Label fivesResult = new Label(String.valueOf(playerResultsMap.get("five")));
            scenaLewa.add(fivesResult, 4, 7);
        }

        Label sixesName = new Label("   Six: ");
        scenaLewa.add(sixesName, 2, 8);

        if (playerResultsMap.get("six").equals(0)) {
            Label sixesResult = new Label(MainEngine.sixesCalc());
            scenaLewa.add(sixesResult, 4, 8);
        }
        else {
            Label sixesResult = new Label(String.valueOf(playerResultsMap.get("six")));
            scenaLewa.add(sixesResult, 4, 8);
        }

        Label threeOfKind = new Label("   Three Of A Kind: ");
        scenaLewa.add(threeOfKind, 2, 9);

        if (playerResultsMap.get("threeof").equals(0)) {
            Label threeOfLabel = new Label(MainEngine.threeOfKindCalc());
            scenaLewa.add(threeOfLabel, 4, 9);
        }
        else {
            Label threeOfLabel = new Label(String.valueOf(playerResultsMap.get("threeof")));
            scenaLewa.add(threeOfLabel, 4, 9);
        }

        Label fourOfKind = new Label("   Four Of A Kind: ");
        scenaLewa.add(fourOfKind, 2, 10);

        if (playerResultsMap.get("fourof").equals(0)) {
            Label fourOfLabel = new Label(MainEngine.fourOfKindCalc());
            scenaLewa.add(fourOfLabel, 4, 10);
        }
        else {
            Label fourOfLabel = new Label(String.valueOf(playerResultsMap.get("fourof")));
            scenaLewa.add(fourOfLabel, 4, 10);
        }

        Label fullHouse = new Label("   Full House: ");
        scenaLewa.add(fullHouse, 2, 11);

        if (playerResultsMap.get("full").equals(0)) {
            Label fullLabel = new Label(MainEngine.fullHouseCalc());
            scenaLewa.add(fullLabel, 4, 11);
        }
        else {
            Label fullLabel = new Label(String.valueOf(playerResultsMap.get("full")));
            scenaLewa.add(fullLabel, 4, 11);
        }

        Label smallStraight = new Label("   Small Straight: ");
        scenaLewa.add(smallStraight, 2, 12);

        if (playerResultsMap.get("small").equals(0)) {
            Label smallLabel = new Label(MainEngine.smallStraightCalc());
            scenaLewa.add(smallLabel, 4, 12);
        }
        else {
            Label smallLabel = new Label(String.valueOf(playerResultsMap.get("small")));
            scenaLewa.add(smallLabel, 4, 12);
        }

        Label largeStraight = new Label("   Large Straight: ");
        scenaLewa.add(largeStraight, 2, 13);

        if (playerResultsMap.get("big").equals(0)) {
            Label largeLabel = new Label(MainEngine.largeStraightCalc());
            scenaLewa.add(largeLabel, 4, 13);
        }
        else {
            Label largeLabel = new Label(String.valueOf(playerResultsMap.get("big")));
            scenaLewa.add(largeLabel, 4, 13);
        }

        Label general = new Label("   General: ");
        scenaLewa.add(general, 2, 14);

        if (playerResultsMap.get("general").equals(0)) {
            Label generalLabel = new Label(MainEngine.generalCalc());
            scenaLewa.add(generalLabel, 4, 14);
        }
        else {
            Label generalLabel = new Label(String.valueOf(playerResultsMap.get("general")));
            scenaLewa.add(generalLabel, 4, 14);
        }

        Label chance = new Label("   Chance: ");
        scenaLewa.add(chance, 2, 15);

        if (playerResultsMap.get("chance").equals(0)) {
            Label chanceLabel = new Label(MainEngine.chanceCalc());
            scenaLewa.add(chanceLabel, 4, 15);
        }
        else {
            Label chanceLabel = new Label(String.valueOf(playerResultsMap.get("chance")));
            scenaLewa.add(chanceLabel, 4, 15);
        }

        unlockUnselectedResultBoxes(playerInstance);




        return scenaLewa;
    }
    public static GridPane addLeftCheckboxes(GridPane scenaLewa, Player playerInstance, Button throwButton) {

        CheckBox checkOne = new CheckBox();
        checkOne.setPadding(new Insets(2));
        scenaLewa.add(checkOne,1, 3);
        playerInstance.playerResultBox.add(checkOne);
        CheckBox checkTwo = new CheckBox();
        checkTwo.setPadding(new Insets(2));
        scenaLewa.add(checkTwo,1, 4);
        playerInstance.playerResultBox.add(checkTwo);
        CheckBox checkThree = new CheckBox();
        checkThree.setPadding(new Insets(2));
        scenaLewa.add(checkThree,1, 5);
        playerInstance.playerResultBox.add(checkThree);
        CheckBox checkFour = new CheckBox();
        checkFour.setPadding(new Insets(2));
        scenaLewa.add(checkFour,1, 6);
        playerInstance.playerResultBox.add(checkFour);
        CheckBox checkFive = new CheckBox();
        checkFive.setPadding(new Insets(2));
        scenaLewa.add(checkFive,1, 7);
        playerInstance.playerResultBox.add(checkFive);
        CheckBox checkSix = new CheckBox();
        checkSix.setPadding(new Insets(2));
        scenaLewa.add(checkSix,1, 8);
        playerInstance.playerResultBox.add(checkSix);
        CheckBox checkThreeOfKind = new CheckBox();
        checkThreeOfKind.setPadding(new Insets(2));
        scenaLewa.add(checkThreeOfKind,1, 9);
        playerInstance.playerResultBox.add(checkThreeOfKind);
        CheckBox checkFourOfKind = new CheckBox();
        checkFourOfKind.setPadding(new Insets(2));
        scenaLewa.add(checkFourOfKind,1, 10);
        playerInstance.playerResultBox.add(checkFourOfKind);
        CheckBox checkFullHouse = new CheckBox();
        checkFullHouse.setPadding(new Insets(2));
        scenaLewa.add(checkFullHouse,1, 11);
        playerInstance.playerResultBox.add(checkFullHouse);
        CheckBox checkSmallStraight = new CheckBox();
        checkSmallStraight.setPadding(new Insets(2));
        scenaLewa.add(checkSmallStraight,1, 12);
        playerInstance.playerResultBox.add(checkSmallStraight);
        CheckBox checkLargeStraight = new CheckBox();
        checkLargeStraight.setPadding(new Insets(2));
        scenaLewa.add(checkLargeStraight,1, 13);
        playerInstance.playerResultBox.add(checkLargeStraight);
        CheckBox checkGeneral = new CheckBox();
        checkGeneral.setPadding(new Insets(2));
        scenaLewa.add(checkGeneral,1, 14);
        playerInstance.playerResultBox.add(checkGeneral);
        CheckBox checkChance = new CheckBox();
        checkChance.setPadding(new Insets(2));
        scenaLewa.add(checkChance,1, 15);
        playerInstance.playerResultBox.add(checkChance);



        playerInstance.playerResultBox.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(0).setDisable(true);
                playerInstance.setPlayerCategoryPoints("one", Integer.parseInt(MainEngine.onesCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(0));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(1).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(1).setDisable(true);
                playerInstance.setPlayerCategoryPoints("two", Integer.parseInt(MainEngine.twosCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(1));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();

            }
        });

        playerInstance.playerResultBox.get(2).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(2).setDisable(true);
                playerInstance.setPlayerCategoryPoints("three", Integer.parseInt(MainEngine.threesCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(2));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(3).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(3).setDisable(true);
                playerInstance.setPlayerCategoryPoints("four", Integer.parseInt(MainEngine.foursCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(3));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(4).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(4).setDisable(true);
                playerInstance.setPlayerCategoryPoints("five", Integer.parseInt(MainEngine.fivesCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(4));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(5).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(5).setDisable(true);
                playerInstance.setPlayerCategoryPoints("six", Integer.parseInt(MainEngine.sixesCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(5));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(6).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(6).setDisable(true);
                playerInstance.setPlayerCategoryPoints("threeof", Integer.parseInt(MainEngine.threeOfKindCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(6));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(7).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(7).setDisable(true);
                playerInstance.setPlayerCategoryPoints("fourof", Integer.parseInt(MainEngine.fourOfKindCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(7));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(8).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(8).setDisable(true);
                playerInstance.setPlayerCategoryPoints("full", Integer.parseInt(MainEngine.fullHouseCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(8));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(9).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(9).setDisable(true);
                playerInstance.setPlayerCategoryPoints("small", Integer.parseInt(MainEngine.smallStraightCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(9));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(10).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(10).setDisable(true);
                playerInstance.setPlayerCategoryPoints("big", Integer.parseInt(MainEngine.largeStraightCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(10));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(11).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(11).setDisable(true);
                playerInstance.setPlayerCategoryPoints("general", Integer.parseInt(MainEngine.generalCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(11));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        playerInstance.playerResultBox.get(12).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playerInstance.playerResultBox.get(12).setDisable(true);
                playerInstance.setPlayerCategoryPoints("chance", Integer.parseInt(MainEngine.chanceCalc()));
                playerInstance.lockedResultCheckboxes.add(playerInstance.playerResultBox.get(12));
                throwButton.setDisable(true);
                lockResultsBoxes(playerInstance);
                TopFrame.calculatePoints(playerInstance);
                PlayScene.lockAllDices();
            }
        });

        return scenaLewa;

    }

    public static void lockResultsBoxes (Player currentInstance) {
        for (CheckBox lockingBox : currentInstance.playerResultBox) {
            lockingBox.setDisable(true);

        }
    }



    public static void unlockUnselectedResultBoxes (Player currentInstance) {
        for (CheckBox unlockingBox : currentInstance.playerResultBox) {
            if (!currentInstance.lockedResultCheckboxes.contains(unlockingBox)) {
                unlockingBox.setDisable(false);
            }
        }
    }




    public static GridPane createDices(GridPane scenaPrawa) throws FileNotFoundException {

        Map<Integer, String> diceImages = new LinkedHashMap<Integer, String>();
        diceImages.put(0, "images/k0.png");
        diceImages.put(1, "images/k1.png");
        diceImages.put(2, "images/k2.png");
        diceImages.put(3, "images/k3.png");
        diceImages.put(4, "images/k4.png");
        diceImages.put(5, "images/k5.png");
        diceImages.put(6, "images/k6.png");

        //PlayScene.diceCheckboxes.clear();

        int counter = 0;
        for (int i : Player.playerPointsThrown) {

            ImageView diceImg = new ImageView(new Image(diceImages.get(i)));
            diceImg.setFitHeight(50);
            diceImg.setFitWidth(50);
            scenaPrawa.add(diceImg, 2, counter + 1);

            if (PlayScene.diceCheckboxes.isEmpty() || PlayScene.diceCheckboxes.size() < 5){
                PlayScene.diceCheckboxes.add(new CheckBox()); // add checkbox to the list
                scenaPrawa.add(PlayScene.diceCheckboxes.get(counter), 1, counter + 1);
            }

            int lockedBoxCounter = 1;
            if (Player.numberOfThrowsLeft == 3 || Player.numberOfThrowsLeft == 0) {
                for (CheckBox lockingDiceCheckboxes : PlayScene.diceCheckboxes) {
                    lockingDiceCheckboxes.setDisable(true);
                }
            }

            else for (CheckBox lockingDiceCheckboxes : PlayScene.diceCheckboxes) {
                if (!PlayScene.lockedDices.contains(lockedBoxCounter)) {
                    lockingDiceCheckboxes.setDisable(false);
                    lockedBoxCounter++;
                }

            }

            counter++;
        }


        return scenaPrawa;
    }


}
