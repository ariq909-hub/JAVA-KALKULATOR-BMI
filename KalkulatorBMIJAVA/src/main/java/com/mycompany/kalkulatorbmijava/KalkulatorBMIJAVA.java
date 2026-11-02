package com.mycompany.kalkulatorbmijava;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KalkulatorBMIJAVA extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        URL url = new File("src/main/resources/view/BMIView.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Scene scene = new Scene(root, 400, 350);
        stage.setTitle("Kalkulator BMI JavaFX");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}