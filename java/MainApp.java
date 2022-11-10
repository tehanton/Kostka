import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    static List<String> playersNamesList = new ArrayList<String>();
    static List<Player> playersInstances = new ArrayList<Player>();
    static int currentPlayerInstance;

    @Override
    public void start(Stage primaryStage) {

        SelectionScene firstSceneObject = new SelectionScene();


        primaryStage.setScene(firstSceneObject.FirstSceneShow(primaryStage));
        primaryStage.setTitle("Roll the dice!");
        primaryStage.setWidth(500);
        primaryStage.setHeight(650);
        primaryStage.show();

    }

    static int getPlayer(Node current) {
        int instancePlayer;
        System.out.println("..........");
        System.out.println(current);
        System.out.println(PlayScene.listOfScenes.get(1));

        if (current == PlayScene.listOfScenes.get(0)) {
            instancePlayer = 0;
            currentPlayerInstance = 0;
            System.out.println("Instance One");
        } else if (current == PlayScene.listOfScenes.get(1)) {
            instancePlayer = 1;
            currentPlayerInstance = 1;
            System.out.println("Instance Two");
        } else if (current == PlayScene.listOfScenes.get(2)) {
            instancePlayer = 2;
            currentPlayerInstance = 2;
            System.out.println("Instance Three");
        } else {
            instancePlayer = 3;
            currentPlayerInstance = 3;
            System.out.println("Instance Four");
        }



        return instancePlayer;
    }

}
