package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class dashboard  implements Initializable {

    @FXML
    public Label psite = new Label();
    @FXML
    private FontAwesomeIconView cross;
    @FXML
    private FontAwesomeIconView cross1;
    @FXML
    private ImageView js1 = new ImageView();
    @FXML
    private AnchorPane p1;
    @FXML
    public Label jsite = new Label();
    @FXML
    private ImageView ps1;

    @FXML
    void CROSS(MouseEvent event) throws IOException{
        Global.closeStage(cross);
    }
    @FXML
    void CROSS1(MouseEvent event) throws IOException{
        Global.closeStage(cross1);
    }

    public Text CLOSE ;

    public void back_home(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }

    public void about(MouseEvent event) throws IOException {
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

    public void official(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }

    public void victim_reg(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimReg.fxml"));
        Global.switch_scene(root,event);
    }

    public void victim_user(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimUser.fxml"));
        Global.switch_scene(root,event);
    }

    public void police_user(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/policeUser.fxml"));
        Global.switch_scene(root,event);
    }

    public void judge_user(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/judgesUser.fxml"));
        Global.switch_scene(root,event);
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


    public void judges_site(MouseEvent event) {

            psite.setVisible(true);
            ps1.setVisible(true);
            jsite.setVisible(false);
            js1.setVisible(false);

        TranslateTransition slide = new TranslateTransition();

        slide.setDuration(Duration.seconds(0.6));
        slide.setNode(p1);
        slide.setToX(-1);
        slide.play();

    }
    public void police_site(MouseEvent event) {

            jsite.setVisible(true);
            js1.setVisible(true);
            psite.setVisible(false);
            ps1.setVisible(false);

        TranslateTransition slide = new TranslateTransition();

        slide.setDuration(Duration.seconds(0.6));
        slide.setNode(p1);
        slide.setToX(700);
        slide.play();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jsite.setVisible(false);
        js1.setVisible(false);
    }
}

