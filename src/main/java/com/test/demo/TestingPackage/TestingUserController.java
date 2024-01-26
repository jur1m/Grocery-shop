package com.test.demo.TestingPackage;

import com.test.demo.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TestingUserController extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("UserAdministrationView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Grocery store!");
        stage.setScene(scene);
        stage.show();
    }
}
