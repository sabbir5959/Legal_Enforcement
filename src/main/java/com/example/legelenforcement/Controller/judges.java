package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.USER;
import com.example.legelenforcement.View.log_in;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class judges implements Initializable {

    @FXML
    private Label j1 = new Label();
    @FXML
    private Label j2 = new Label();
    @FXML
    private Text j3 = new Text();
    @FXML
    private Text j4 = new Text();
    public Button CLOSE;
    public FontAwesomeIconView cross;
    @FXML
    private PasswordField pass_hidden;
    @FXML
    private CheckBox Check;
    @FXML
    private TextField pass_text;
    static log_in log = new log_in();
    public void set_log(log_in log)
    {
        this.log = log;
    }


    @FXML
    void CROSS(MouseEvent event) throws IOException{
        Global.closeStage(cross);
    }

    @FXML
    void Visibility(ActionEvent event){
        if(Check.isSelected()){
            pass_text.setText(pass_hidden.getText());
            pass_text.setVisible(true);
            pass_hidden.setVisible(false);
            return;
        }
        pass_hidden.setText(pass_text.getText());
        pass_hidden.setVisible(true);
        pass_text.setVisible(false);
    }
    public void comp(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/complaintList.fxml"));
        Global.switch_scene(root,event);
    }

//    public void judge_email(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/JUDGES/FORGOT/forgotPass.fxml"));
//        Global.createStage(fxmlLoader);
//    }
    public void close(ActionEvent event) throws IOException {
        Global.closeStage(CLOSE);
    }

//    public void judge_otp_verify(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/FORGOT/OTP.fxml"));
//        Global.switch_scene(root,event);
//    }
//
//    public void judge_create_pass(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/FORGOT/createNewPass.fxml"));
//        Global.switch_scene(root,event);
//    }
    public void judge_user(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/judgesUser.fxml"));
        Global.switch_scene(root,event);
    }

    public void judge_profile(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/judgeProfile.fxml"));
        Global.switch_scene(root,event);
    }

    public void newPDF(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/criminalLaw.fxml"));
        Global.switch_scene(root,event);
    }

    public void back_home(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }

    public void officials(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }
    public void about(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/DASHBOARD/AboutUs/about.fxml"));
        Global.createStage(fxmlLoader);
    }

    @FXML
    public WebView web= new WebView();
    public ImageView img11 = new ImageView();

    @FXML
    public void open_web(ActionEvent event) throws URISyntaxException, IOException{
        web.setVisible(true);
        web.getEngine().load("http://bdlaws.minlaw.gov.bd/laws-of-bangladesh.html");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        j1.setText(log.getUser());
        j2.setText(log.getUser());
        j3.setText(log.getUser());
        j4.setText(log.getUser());

        web.setVisible(false);
        img11.setVisible(true);
    }
}
