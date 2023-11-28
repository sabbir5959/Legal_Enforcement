package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.View.USER;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class vic_case_fxml  implements Initializable {

    @FXML
    private FontAwesomeIconView close;

    @FXML
    private Circle dp;

    @FXML
    private Label vc_address;

    @FXML
    private Label vc_complainNo;

    @FXML
    private Label vc_crime;

    @FXML
    private Label vc_date;

    @FXML
    private Label vc_description;

    @FXML
    private Label vc_dob;

    @FXML
    private Label vc_email;

    @FXML
    private Label vc_location;

    @FXML
    private Label vc_name;

    @FXML
    private Label vc_phone;

    public static USER user = new USER();

    public void set_user(USER user)
    {
        this.user = user;
    }

    @FXML
    void CLOSE(MouseEvent event) {
        Global.closeStage(close);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vc_address.setText(user.getAddress());
        vc_complainNo.setText(user.getComplainNo());
        vc_crime.setText(user.getCrime());
        vc_date.setText(user.getDate());
        vc_description.setText(user.getDescription());
        vc_dob.setText(user.getDob());
        vc_email.setText(user.getEmail());
        vc_location.setText(user.getLocation());
        vc_name.setText(user.getName());
        vc_phone.setText(user.getPhone());

        String p = user.getVic_img();
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));


    }
}
