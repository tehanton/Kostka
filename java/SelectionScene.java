import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;


public class SelectionScene {


    public Scene FirstSceneShow(Stage stage) {

        Button buttonForward = new Button("Forward");
        buttonForward.setMaxWidth(290);

        Label welcome = new Label("What are the players' names?");
        welcome.setFont(new Font("Arial", 24));
        Label player1NameLabel = new Label("Player's 1 name:");
        Label player2NameLabel = new Label("Player's 1 name:");

        RadioButton radioPlayer3 = new RadioButton("Player's 3 name:");
        RadioButton radioPlayer4 = new RadioButton("Player's 4 name:");
        radioPlayer4.setDisable(true);
        TextField namePlayer1 = new TextField("Adam");
        TextField namePlayer2 = new TextField("Ola");
        TextField namePlayer3 = new TextField();
        TextField namePlayer4 = new TextField();

        player1NameLabel.setLayoutX(80);
        player1NameLabel.setLayoutY(100);
        player2NameLabel.setLayoutX(80);
        player2NameLabel.setLayoutY(150);
        radioPlayer3.setLayoutX(80);
        radioPlayer3.setLayoutY(200);
        radioPlayer4.setLayoutX(80);
        radioPlayer4.setLayoutY(250);

        namePlayer1.setLayoutX(200);
        namePlayer1.setLayoutY(100);
        namePlayer2.setLayoutX(200);
        namePlayer2.setLayoutY(150);
        namePlayer3.setLayoutX(200);
        namePlayer3.setLayoutY(200);
        namePlayer4.setLayoutX(200);
        namePlayer4.setLayoutY(250);

        welcome.setLayoutX(130);
        buttonForward.setLayoutX(200);
        buttonForward.setLayoutY(350);
        buttonForward.setStyle("-fx-font-size: 2em; ");


        PlayScene playSceneObject = new PlayScene();

        buttonForward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String stringName1 = namePlayer1.getText();
                String stringName2 = namePlayer2.getText();
                String stringName3 = namePlayer3.getText();
                String stringName4 = namePlayer4.getText();
                if (analyzeResults(stringName1, stringName2, stringName3, stringName4, radioPlayer3, radioPlayer4)) {
                    return;
                } else {
                    stage.setScene(playSceneObject.PlaySceneShow(stage));
                }
            }
        });

        radioPlayer3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (radioPlayer4.isDisabled()) {
                    radioPlayer4.setDisable(false);
                }
                else {
                    radioPlayer4.setDisable(true);
                    namePlayer4.clear();
                    radioPlayer4.setSelected(false);
                    System.out.println("test");

                }

            }
        });



        Group group = new Group();
        group.getChildren().add(player1NameLabel);
        group.getChildren().add(player2NameLabel);
        group.getChildren().add(radioPlayer3);
        group.getChildren().add(radioPlayer4);
        group.getChildren().add(namePlayer1);
        group.getChildren().add(namePlayer2);
        group.getChildren().add(namePlayer3);
        group.getChildren().add(namePlayer4);
        group.getChildren().add(buttonForward);
        group.getChildren().add(welcome);
        Scene sceneSelection = new Scene(group);

        sceneSelection.setFill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.web("#9ed4ee")),     //colors
                new Stop(1, Color.web("#c3c5c6")))
        );
        return sceneSelection;


    }

    public boolean analyzeResults(String name1, String name2, String name3, String name4, RadioButton player3, RadioButton player4) {
        Alert unselectedName = new Alert(Alert.AlertType.NONE, "Player not selected", ButtonType.APPLY);
        unselectedName.setContentText("Name has been provided, but the player is not selected.");
        Alert alertWrongSelection = new Alert(Alert.AlertType.NONE, "Player name missing", ButtonType.APPLY);
        alertWrongSelection.setContentText("Selected a player, but no name has been provided");

        if (Objects.equals(name1, "")) {
            System.out.println("Missing name 1");
            alertWrongSelection.show();
            return true;
        } else if (Objects.equals(name2, "")) {
            System.out.println("Missing name 2");
            alertWrongSelection.show();
            return true;
        } else if (player3.isSelected() & Objects.equals(name3, "")) {
            System.out.println("p3 selected, empty");
            alertWrongSelection.show();
            return true;
        } else if (player4.isSelected() & Objects.equals(name4, "")) {
            System.out.println("p4 selected, empty");
            alertWrongSelection.show();
            return true;
        } else if (!player3.isSelected() & !Objects.equals(name3, "")) {
            System.out.println("Unselected player");
            unselectedName.show();
            return true;
        } else if (!player4.isSelected() & !Objects.equals(name4, "")) {
            System.out.println("Unselected player");
            unselectedName.show();
            return true;
        }
        else {
            MainApp.playersNamesList.add(name1);
            MainApp.playersNamesList.add(name2);
            if (player3.isSelected()) {
                MainApp.playersNamesList.add(name3);
            }
            if (player4.isSelected()) {
                MainApp.playersNamesList.add(name4);
            }
            System.out.println(MainApp.playersNamesList);
            return false;
        }

    }

}
