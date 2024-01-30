package com.test.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static Stage testStage;


    @Override
    public void start(Stage stage) throws IOException {
        testStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("test.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),650,450);
        stage.setTitle("Grocery store!");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException{

        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        testStage.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}
