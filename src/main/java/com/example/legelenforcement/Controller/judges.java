package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
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
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class judges implements Initializable {

    public Button CLOSE;
    @FXML
    private PasswordField pass_hidden;
    @FXML
    private CheckBox Check;
    @FXML
    private TextField pass_text;

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
    public void comp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/complaintList.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void judge_email(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/JUDGES/FORGOT/forgotPass.fxml"));
        Global.createStage(fxmlLoader);
    }
    public void close(ActionEvent event) throws IOException {
        Global.closeStage(CLOSE);
    }

    public void judge_otp_verify(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/FORGOT/OTP.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void judge_create_pass(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/FORGOT/createNewPass.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void judge_user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/judgesUser.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void judge_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/judgeProfile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void newPDF(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/criminalLaw.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void back_home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void officials(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        web.setVisible(false);
        img11.setVisible(true);
    }
}


//    instagram.setOnMouseClicked(MouseEvent -> {
//        try {
//            Desktop.getDesktop().browse(new URI("https://www.instagram.com"));}
//        catch (IOException | URISyntaxException e)
//        {
//            throw new RuntimeException(e);
//        }
//    });


//web.getEngine().load("https://www.google.com/maps/search/hospital/@23.8461791,90.3345295,13z/data=!3m1!4b1?entry=ttu");

//        public void victim_user() throws IOException {
//        currentUserType="victim";
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/VICTIM/victimUser.fxml"));
//        Global.createStage(fxmlLoader);
//        Global.closeStage(victim_login_button);
//    }

//        public void judge_user() throws IOException {
//        currentUserType="judge";
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/JUDGES/judgesUser.fxml"));
//        Global.createStage(fxmlLoader);
//        Global.closeStage(judge_login_button);
//    }

//    public void police_user() throws IOException {
//        currentUserType="police";
//        System.out.println(currentUserType);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/POLICE/policeUser.fxml"));
//        Global.createStage(fxmlLoader);
//        Global.closeStage(police_login_button);
//    }