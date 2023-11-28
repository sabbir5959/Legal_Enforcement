package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.person;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VICTIM_profile implements Initializable {

    public FontAwesomeIconView cross;
    @FXML
    private Label VFname;
    public Circle circle, circle2;
    @FXML
    private Label Vaddress;
    @FXML
    private Label Vemail;
    @FXML
    private Label Vfather;
    @FXML
    private Label Vmobile;
    @FXML
    private Label Vmother;
    @FXML
    private Label Vname;
    @FXML
    private Label full;
    @FXML
    private Label fullN;
    @FXML
    private ImageView img1;
    static person per = new person();
    public void set_person(person per)
    {
        this.per = per;
    }

    public void CROSS(MouseEvent event) throws IOException{
        Global.closeStage(cross);
    }
    public void back_home(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }
    public void back_victim(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimUser.fxml"));
        Global.switch_scene(root, event);
    }

    public void complain_list(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/VICTIM/complaintList.fxml"));
        Global.switch_scene(root,event);
    }

    public void victim_fir(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimFIR.fxml"));
        Global.switch_scene(root,event);
    }

    public void dashboard_img(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Vemail.setText(per.getTemail());
        Vname.setText(per.getTuser_name());
        VFname.setText(per.getTname());
        Vfather.setText(per.getTfather());
        Vmother.setText(per.getTmother());
        Vaddress.setText(per.getTaddress());
        Vmobile.setText(per.getTmobile());
        full.setText(per.getTname());
        fullN.setText(per.getTname());

        String p = per.getTimage();
        per.setTimage(p);
        Image image = new Image(p);
        circle.setFill(new ImagePattern(image));
        circle2.setFill(new ImagePattern(image));
    }
}
