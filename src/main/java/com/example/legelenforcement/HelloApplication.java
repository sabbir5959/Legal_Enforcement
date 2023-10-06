package com.example.legelenforcement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 800);
        stage.setResizable(false);
        stage.setTitle("Legal Enforcement System");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("Image/logoblack.png")));
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}

//        String css = this .getClass().getResource("learner_signup1.css").toExternalForm();
//        String css1 = this .getClass().getResource("loginpage.css").toExternalForm();
//        String css2 = this .getClass().getResource("Dashboard.css").toExternalForm();

//        scene.getStylesheets().add(css);
//        scene.getStylesheets().add(css1);
//        scene.getStylesheets().add(css2);