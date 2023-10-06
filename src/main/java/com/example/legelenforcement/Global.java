package com.example.legelenforcement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.*;

import java.io.IOException;

public class Global {
    public static void createStage(FXMLLoader fxmlLoader) throws IOException
    {
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = new Stage();
        stage.setTitle("Legal Enforcement System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void closeStage(Node node)
    {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
