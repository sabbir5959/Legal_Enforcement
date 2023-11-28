package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.log_in;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class judge_login extends judges{
    public TextField USER;
    public FontAwesomeIconView cross;
    @FXML
    private PasswordField pass_hidden;
    @FXML
    private Label error;
    log_in log = new log_in();

    @FXML
    void CROSS(MouseEvent event) throws IOException{
        Global.closeStage(cross);
    }

    public void judge_login(ActionEvent event) throws IOException {
        String tuser = USER.getText();
        String tpass = pass_hidden.getText();
        log = new log_in(tuser, tpass);
        if (log.getUser().isBlank() || log.getPassword().isBlank())
        {
            error.setText("  Fill out all the fields to proceed");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> error.setText("")));
            timeline.play();
        }

        if (log.getUser().length() > 0 && log.getPassword().length() > 0) {
            File file = new File("E:/Java Code/Java Files/Sign Up/Judges Sign Up/" + log.getUser() + "/info.txt");
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                String p = sc.next();
                p = sc.next();

                judges_assign_case_list judge = new judges_assign_case_list();
                judge.set_log(log);
                if (p.equals(log.getPassword())) {
                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/judgeProfile.fxml"));
                    Global.switch_scene(root, event);
                } else {
                    error.setText("    Password doesn't match    ");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> error.setText("")));
                    timeline.play();
                }

            } else {
                error.setText("Please check username/password");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> error.setText("")));
                timeline.play();
            }
        }
    }


    public void facebook(MouseEvent mouseEvent) {try{
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/"));}
    catch (IOException | URISyntaxException ex){throw new RuntimeException(ex);}};
    public void github(MouseEvent mouseEvent) {try{
        Desktop.getDesktop().browse(new URI("https://github.com/"));}
    catch (IOException | URISyntaxException ex){throw new RuntimeException(ex);}};
    public void instagram(MouseEvent mouseEvent) {try{
        Desktop.getDesktop().browse(new URI("https://www.instagram.com/"));}
    catch (IOException | URISyntaxException ex){throw new RuntimeException(ex);}};

}
