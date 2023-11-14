package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.log_in;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Police_controller_Login extends police_controller {
    public TextField user;
    @FXML
    private PasswordField passHidden;
    @FXML
    private Label error_msg;
    log_in log = new log_in();

    public void police_login(ActionEvent event) throws IOException {
        String tuser = user.getText();
        String tpass = passHidden.getText();
        log = new log_in(tuser, tpass);
        if (log.getUser().isBlank() || log.getPassword().isBlank())
        {
            error_msg.setText("  Fill out all the fields to proceed");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> error_msg.setText("")));
            timeline.play();
        }

        if (log.getUser().length() > 0 && log.getPassword().length() > 0) {
            File file = new File("E:/Java Code/Java Files/Sign Up/Police Sign Up/" + log.getUser() + "/Info.txt");
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                String p = sc.next();
                p = sc.next();

                if (p.equals(log.getPassword())) {
                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/profile.fxml"));
                    Global.switch_scene(root, event);
                } else {
                    error_msg.setText("    Password doesn't match    ");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> error_msg.setText("")));
                    timeline.play();
                }

            } else {
                error_msg.setText("Please check username/password");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> error_msg.setText("")));
                timeline.play();
            }
        }
    }
}


