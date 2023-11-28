package com.example.legelenforcement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.*;

import java.io.IOException;
import java.util.EventObject;

public class Global {
    private static Scene scene;
    private Parent root;
    private Stage stage;



    public static void createStage(FXMLLoader fxmlLoader) throws IOException
    {
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Legal Enforcement System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Legal Enforcement System");
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("Image/logoblack.png")));
        stage.initStyle(javafx.stage.StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void switch_scene(Parent root, EventObject event) throws IOException
    {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
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
