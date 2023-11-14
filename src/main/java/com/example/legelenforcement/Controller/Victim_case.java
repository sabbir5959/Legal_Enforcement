package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.USER;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Victim_case implements Initializable {

    @FXML
    private FontAwesomeIconView close;
    @FXML
    private Label vc_address, vc_complainNo, vc_crime, vc_date, vc_dob, vc_email, vc_location, vc_name, vc_phone;
    @FXML
    private TextField vc_description;

    @FXML
    public Circle dp = new Circle();

    public static USER user = new USER();

    public void set_user(USER user)
    {
        this.user = user;
    }

    public void CLOSE(MouseEvent event) throws IOException {
        Global.closeStage(close);
    }

    public void official(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }

    public void dashboard_img(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        vc_name.setText(user.getName());
        vc_address.setText(user.getAddress());
        vc_complainNo.setText(user.getComplainNo());
        vc_crime.setText(user.getCrime());
        vc_date.setText(user.getDate());
        vc_dob.setText(user.getDob());
        vc_email.setText(user.getEmail());
        vc_location.setText(user.getLocation());
        vc_phone.setText(user.getPhone());
        vc_description.setText(user.getDescription());

        String p = user.getVic_img();
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));
    }
}
