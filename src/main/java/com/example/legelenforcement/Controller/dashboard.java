package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class dashboard implements Initializable {

    public Text CLOSE ;

    public void back_home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }

    public void about(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/DASHBOARD/AboutUs/about.fxml"));
        Global.createStage(fxmlLoader);
    }
    public void close(MouseEvent event) throws IOException {
        Global.closeStage(CLOSE);
    }

    public void sabbir(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/AboutUs/Sabbir.fxml"));
        Global.switch_scene(root,event);
    }

    public void anika(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/AboutUs/Anika.fxml"));
        Global.switch_scene(root,event);
    }

    public void maisha(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/AboutUs/Maisha.fxml"));
        Global.switch_scene(root,event);
    }

    public void back_about(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/AboutUs/about.fxml"));
        Global.switch_scene(root,event);
    }

    public void official(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }

    public void victim_reg(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimReg.fxml"));
        Global.switch_scene(root,event);
    }

    public void victim_user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimUser.fxml"));
        Global.switch_scene(root,event);
    }

    public void police_user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/policeUser.fxml"));
        Global.switch_scene(root,event);
    }

    public void judge_user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/judgesUser.fxml"));
        Global.switch_scene(root,event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void sabbir_fb(MouseEvent mouseEvent) {try{
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/Sabbir141368"));}
    catch (IOException | URISyntaxException ex){throw new RuntimeException(ex);}};
    public void sabbir_insta(MouseEvent mouseEvent) {try{
        Desktop.getDesktop().browse(new URI("https://www.instagram.com/s_sabbir_r/"));}
    catch (IOException | URISyntaxException ex){throw new RuntimeException(ex);}};
    public void sabbir_git(MouseEvent mouseEvent) {try{
        Desktop.getDesktop().browse(new URI("https://github.com/sabbir5959"));}
    catch (IOException | URISyntaxException ex){throw new RuntimeException(ex);}};

    public void maisha_fb(MouseEvent mouseEvent) {try{
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/maisha2796"));}
    catch (IOException | URISyntaxException ex){throw new RuntimeException(ex);}};
    public void maisha_git(MouseEvent mouseEvent) {try{
        Desktop.getDesktop().browse(new URI("https://github.com/maisha27"));}
    catch (IOException | URISyntaxException ex){throw new RuntimeException(ex);}};

    public void anika_fb(MouseEvent mouseEvent) {try{
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/profile.php?id=100030710132298&mibextid=ZbWKwL"));}
    catch (IOException | URISyntaxException ex){throw new RuntimeException(ex);}};
    public void anika_git(MouseEvent mouseEvent) {try{
        Desktop.getDesktop().browse(new URI("https://github.com/AnikaTasnim03"));}
    catch (IOException | URISyntaxException ex){throw new RuntimeException(ex);}};


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



