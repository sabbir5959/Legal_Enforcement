package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class police_controller implements Initializable {

    public Button CLOSE ;
    @FXML
    private PasswordField passHidden;
    @FXML
    private CheckBox checkBox;
    @FXML
    private TextField passText;
    @FXML
    public WebView web= new WebView();
    public ImageView img2 = new ImageView();

    @FXML
    void change(ActionEvent event){
        if(checkBox.isSelected()){
            passText.setText(passHidden.getText());
            passText.setVisible(true);
            passHidden.setVisible(false);
            return;
        }
        passHidden.setText(passText.getText());
        passHidden.setVisible(true);
        passText.setVisible(false);
    }

    public void police_otp_verify(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/FORGOT/OTP.fxml"));
        Global.switch_scene(root,event);
    }

    public void police_create_pass(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/FORGOT/createNewPass.fxml"));
        Global.switch_scene(root,event);
    }

    public void vic_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/Case_list.fxml"));
        Global.switch_scene(root,event);
    }

//    public void police_email(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/POLICE/FORGOT/forgotPass.fxml"));
//        Global.createStage(fxmlLoader);
//    }
    public void close(ActionEvent event) throws IOException {
        Global.closeStage(CLOSE);
    }

    public void complaint_list(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/Criminal_List.fxml"));
        Global.switch_scene(root,event);
    }

    public void police_user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/policeUser.fxml"));
        Global.switch_scene(root,event);
    }

    public void police_list(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/Police.fxml"));
        Global.switch_scene(root,event);
    }

    public void police_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/profile.fxml"));
        Global.switch_scene(root,event);
    }

    public void newPDFpage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/criminalLaw.fxml"));
        Global.switch_scene(root,event);
    }
    @FXML
    public void open_web(ActionEvent event) throws URISyntaxException, IOException{
        web.setVisible(true);
        web.getEngine().load("http://bdlaws.minlaw.gov.bd/laws-of-bangladesh.html");
    }

    public void official(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }

    public void back_home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }

    public void officials(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        web.setVisible(false);
        img2.setVisible(true);
    }
}


