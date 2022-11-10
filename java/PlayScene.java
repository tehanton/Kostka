import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class PlayScene {
    static List<GridPane> listOfScenes = new ArrayList<>();
    static List<CheckBox> lockedCheckboxes = new ArrayList<>();
    static List<CheckBox> diceCheckboxes = new ArrayList<>();
    static List<Integer> lockedDices = new ArrayList<>();
    static List<Label> playerPointsCount = new ArrayList<>();
    public Button throwButton = new Button("Throw!");
    static Label throwsLeftLabel = new Label();

    public static void lockAllDices() {
        for (CheckBox diceCheckbox : diceCheckboxes) {
            diceCheckbox.setDisable(true);
        }
    }


    public Scene PlaySceneShow(Stage stage) {
        MainApp.currentPlayerInstance = 0; //setting up
        BorderPane borderP = new BorderPane();
        GridPane rightView = new GridPane();
        GridPane topView = new GridPane();
        topView.setPadding(new Insets(15));
        rightView.setPadding(new Insets(45, 80, 10, 10));



        // set element on the top panel
        int playerCount = 0;
        for (String e : MainApp.playersNamesList) {
            String points = e + ": 0  ";                                    //CHANGE TO POINTS
            Label pointLabel = new Label(points);
            pointLabel.setFont(new Font("Calibri", 15));

            playerPointsCount.add(pointLabel);
            topView.add(playerPointsCount.get(playerCount), playerCount, 0); // adding name labels




            playerCount++;
        }

        borderP.setTop(topView);


        Pane randomElem = new Pane();
        randomElem.setPadding(new Insets(10, 10, 10, 10));
        rightView.add(randomElem, 1, 10);
        rightView.add(throwButton, 1, 11);


        VBox lowerPanel = new VBox();

        ImageView logoDice = new ImageView("images/dice.png");
        logoDice.setFitHeight(115);
        logoDice.setFitWidth(115);

        Button nextButton = new Button("Next player");
        Button endButton = new Button("End the game");
        nextButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        endButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        lowerPanel.getChildren().addAll(logoDice, nextButton, endButton);
        borderP.setBottom(lowerPanel);
        //TextField topText = new TextField("UPPPPPP");


        // create frames for players
        int howManyFrames = MainApp.playersNamesList.size();
        for (int i = 0; i < howManyFrames; i++) {
            listOfScenes.add(new GridPane()); // creating lost with Grids for each player
            MainApp.playersInstances.add(new Player()); // creating instances of players
            GeneratingElements.addName(listOfScenes.get(i), MainApp.playersNamesList.get(i), MainApp.playersInstances.get(i)); // adding label of a current player
            GeneratingElements.addLeftCheckboxes(listOfScenes.get(i), MainApp.playersInstances.get(i), throwButton);
            Player.setPlayerPointsThrown(0, 0, 0, 0, 0);
            Player.numberOfThrowsLeft = 3;

            System.out.println(MainApp.playersInstances);
            System.out.println("Adding for current instance: " + MainApp.playersInstances.get(i));

        }

        // create elements of the left panel
        try {
            GridPane rightPanelCreated = GeneratingElements.createDices(rightView);
            borderP.setRight(rightPanelCreated);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // switch
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Player.numberOfThrowsLeft = 3;
                rightView.getChildren().removeIf(n -> n instanceof ImageView);
                int currPlayerNumber = MainApp.getPlayer(borderP.getCenter());
                lockedDices.clear();
                Player.setPlayerPointsThrown(0, 0, 0, 0, 0);
                System.out.println(Player.playerPointsThrown);
                lockedCheckboxes.clear();

                for (CheckBox diceBoxToUnlock : diceCheckboxes) {
                    diceBoxToUnlock.setDisable(false);
                    diceBoxToUnlock.setSelected(false);
                }


                if (MainApp.getPlayer(borderP.getCenter()) == 0) {
                    borderP.setCenter(listOfScenes.get(1));
                    try {
                        GeneratingElements.createDices(rightView);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (howManyFrames > 2 && MainApp.getPlayer(borderP.getCenter()) == 1) {
                    borderP.setCenter(listOfScenes.get(2));
                    try {
                        GeneratingElements.createDices(rightView);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (howManyFrames > 3 && MainApp.getPlayer(borderP.getCenter()) == 2) {
                    borderP.setCenter(listOfScenes.get(3));
                    try {
                        GeneratingElements.createDices(rightView);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (howManyFrames == 4 && MainApp.getPlayer(borderP.getCenter()) == 3) {
                    borderP.setCenter(listOfScenes.get(0));
                    try {
                        GeneratingElements.createDices(rightView);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (howManyFrames == 3 && borderP.getCenter() == listOfScenes.get(2)) {
                    borderP.setCenter(listOfScenes.get(0));
                    try {
                        GeneratingElements.createDices(rightView);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (howManyFrames == 2 && borderP.getCenter() == listOfScenes.get(1)) {
                    borderP.setCenter(listOfScenes.get(0));
                    try {
                        GeneratingElements.createDices(rightView);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                GridPane currentScene = listOfScenes.get(currPlayerNumber);
                Player currentPlayerInstance = MainApp.playersInstances.get(currPlayerNumber);
                GeneratingElements.addName(currentScene, MainApp.playersNamesList.get(currPlayerNumber), currentPlayerInstance);
                throwButton.setDisable(false);
                TopFrame.calculatePoints(currentPlayerInstance);


            }
        });
        endButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Platform.exit();

            }
        });

        throwButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Player.numberOfThrowsLeft = Player.numberOfThrowsLeft - 1;
                int currPlayerNumber = MainApp.getPlayer(borderP.getCenter());
                Player throwingPlayer = MainApp.playersInstances.get(currPlayerNumber);
                throwingPlayer.throwDices();
                try {
                    GridPane rightPanelCreated = GeneratingElements.createDices(rightView);
                    borderP.setRight(rightPanelCreated);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                GeneratingElements.addName(listOfScenes.get(currPlayerNumber), MainApp.playersNamesList.get(currPlayerNumber), throwingPlayer);

                System.out.println("THROWS REMAINING: " + Player.numberOfThrowsLeft);

                if (throwingPlayer.getNumberOfThrowsLeft() < 1) {
                    throwButton.setDisable(true);
                } else {
                    throwButton.setDisable(false);
                }
                TopFrame.calculatePoints(throwingPlayer);

            }
        });

        diceCheckboxes.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                diceCheckboxes.get(0).setDisable(true);
                lockedDices.add(1);
                lockedCheckboxes.add(diceCheckboxes.get(0));
            }
        });

        diceCheckboxes.get(1).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                diceCheckboxes.get(1).setDisable(true);
                lockedDices.add(2);
                lockedCheckboxes.add(diceCheckboxes.get(1));
            }
        });

        diceCheckboxes.get(2).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                diceCheckboxes.get(2).setDisable(true);
                lockedDices.add(3);
                lockedCheckboxes.add(diceCheckboxes.get(2));
            }
        });

        diceCheckboxes.get(3).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                diceCheckboxes.get(3).setDisable(true);
                lockedDices.add(4);
                lockedCheckboxes.add(diceCheckboxes.get(3));
            }
        });

        diceCheckboxes.get(4).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                diceCheckboxes.get(4).setDisable(true);
                lockedDices.add(5);
                lockedCheckboxes.add(diceCheckboxes.get(4));
            }
        });


        // umiesc jedna ze scen w liscie
        borderP.setCenter(listOfScenes.get(0));



        BorderPane.setAlignment(topView, Pos.TOP_CENTER);
        BorderPane.setAlignment(rightView, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(lowerPanel, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(listOfScenes.get(0), Pos.CENTER);


        RadialGradient shadePaint = new RadialGradient(
                0, 0, 0.2, 0.5, 1, true, CycleMethod.NO_CYCLE,
                new Stop(1, Color.LIGHTSTEELBLUE),
                new Stop(0, Color.TRANSPARENT)
        );


        borderP.setBackground(new Background(new BackgroundFill(shadePaint, CornerRadii.EMPTY, Insets.EMPTY)));

        throwsLeftLabel.setText("Throws remaining: " + Player.numberOfThrowsLeft);
        topView.add(throwsLeftLabel, 0 ,1, 2, 1);


        Scene playscene = new Scene(borderP);

        stage.setScene(playscene);
        stage.show();

        return playscene;
    }

}


