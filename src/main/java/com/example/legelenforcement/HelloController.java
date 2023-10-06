package com.example.legelenforcement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    private ImageView img1;

    @FXML
    private void insert_photo(ActionEvent event) throws IOException {
        FileChooser ch= new FileChooser();
        FileChooser.ExtensionFilter exxtfilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter exxtfilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        ch.getExtensionFilters().addAll(exxtfilterJPG,exxtfilterPNG);
        File file = ch.showOpenDialog(null);
        Image image = new Image(file.toURI().toString());
        img1.setImage(image);
    }



//    public void victim_user() throws IOException {
//        currentUserType="victim";
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/VICTIM/victimUser.fxml"));
//        Global.createStage(fxmlLoader);
//        Global.closeStage(victim_login_button);
//    }

    public void victim_user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Victim/victimUser.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_reg(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Victim/victimReg.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Victim/victimProfile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_fir(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Victim/victimFIR.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void back_home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void complain_list(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/VICTIM/complaintList.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void complaint_list(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/POLICE/complain.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void comp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/JUDGES/complaintList.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_email(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/VICTIM/FORGOT/forgotPass.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_otp_verify(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/VICTIM/FORGOT/OTP.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_create_pass(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/VICTIM/FORGOT/createNewPass.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void police_email(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/POLICE/FORGOT/forgotPass.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void police_otp_verify(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/POLICE/FORGOT/OTP.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void police_create_pass(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/POLICE/FORGOT/createNewPass.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void vic_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/POLICE/vict_Profile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void judge_email(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/JUDGES/FORGOT/forgotPass.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void judge_otp_verify(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/JUDGES/FORGOT/OTP.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void judge_create_pass(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/JUDGES/FORGOT/createNewPass.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void official(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/DASHBOARD/official.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public void judge_user() throws IOException {
//        currentUserType="judge";
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/JUDGES/judgesUser.fxml"));
//        Global.createStage(fxmlLoader);
//        Global.closeStage(judge_login_button);
//    }

    public void judge_user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/JUDGES/judgesUser.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void judge_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/JUDGES/judgeProfile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void newPDF(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/JUDGES/criminalLaw.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void police_user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/POLICE/policeUser.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void police_list(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/POLICE/officers.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


//    public void police_user() throws IOException {
//        currentUserType="police";
//        System.out.println(currentUserType);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/POLICE/policeUser.fxml"));
//        Global.createStage(fxmlLoader);
//        Global.closeStage(police_login_button);
//    }
    public void police_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/POLICE/profile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void officials(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/DASHBOARD/official.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void newPDFpage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/POLICE/criminalLaw.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

   @FXML
    private WebView web;
    @FXML
    public void open_web(ActionEvent event) throws URISyntaxException, IOException{
        web.getEngine().load("http://bdlaws.minlaw.gov.bd/laws-of-bangladesh.html");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

//web.getEngine().load("https://www.google.com/maps/search/hospital/@23.8461791,90.3345295,13z/data=!3m1!4b1?entry=ttu");