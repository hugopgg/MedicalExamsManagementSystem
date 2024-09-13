package com.inf5153;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fx extends Application {
    private static Stage primaryStage;
    private static Map<String, Object> controllers = new HashMap<>();

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        loadMainScene();
    }

    public static void loadMainScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(Fx.class.getResource("/com/inf5153/Main.fxml"));
        Parent root = loader.load();
        controllers.put("MainController", loader.getController());

        Scene scene = new Scene(root);
        // scene.getStylesheets().add("/com/inf5153/styles.css");
        primaryStage.setScene(scene);
        // primaryStage.setTitle("UHCC");
        primaryStage.show();
    }

    public static Object getController(String name) {
        return controllers.get(name);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


