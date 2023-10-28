package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
public class victimOrder extends Victim_Login{
    public Circle circle, circle2;
    @FXML
    private void insert_photo(ActionEvent event) throws IOException {
        FileChooser ch= new FileChooser();
        File file = ch.showOpenDialog(null);
        String p = file.toURI().toString();
        person.setTimage(p);
        Image image = new Image(p);
        circle.setFill(new ImagePattern(image));
        circle2.setFill(new ImagePattern(image));
        IMG(p);
    }

    public void victim_user (ActionEvent event) throws IOException {

//        System.out.println(full_name.getText());
        if (full_name.getText().isEmpty() || user_name.getText().isEmpty() || father_name.getText().isEmpty() || mother_name.getText().isEmpty()
                || email.getText().isEmpty() || address.getText().isEmpty() || pass.getText().isEmpty() || confirmPass.getText().isEmpty() || dateOfbirth.getText().isEmpty()
                || mobile.getText().isEmpty() || (!male.isSelected()&& !female.isSelected()&&!other.isSelected()) || (!married.isSelected()&&!unmarried.isSelected()))
        {
            labelShow.setText("Fill out all the fields to proceed.");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent-> labelShow.setText("")));
            timeline.play();
            return;
        }
        else{
        if (!pass.getText().equals(confirmPass.getText())) {
            labelShow.setText("Password and confirm password must be same");
            return;
        }}

          boolean isUserCreated = create_user();
           if (!isUserCreated) return;

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimUser.fxml"));
        Global.switch_scene(root,event);
    }
}
