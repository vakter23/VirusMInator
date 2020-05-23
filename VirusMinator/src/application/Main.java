package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL url = new File("src/application/vue/tilemap.fxml").toURI().toURL();
            loader.setLocation(url);
            BorderPane root = new BorderPane();
            root = loader.load();
            Scene scene = new Scene(root, 1600, 800);
            primaryStage.setResizable(true);
            primaryStage.setFullScreen(true);
            primaryStage.setTitle("VirusMinator");
            primaryStage.setScene(scene);
            primaryStage.show();
            root.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}