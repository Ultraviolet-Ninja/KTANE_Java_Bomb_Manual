/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Main
 */

package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("expert.fxml"));
        primaryStage.setTitle("Keep Talking and Nobody Explodes");
        Scene scene = new Scene(root, 850, 600);
        scene.getStylesheets().add(getClass().getResource("designs.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:src\\KTANE logo.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
