package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.FIR;
import com.example.legelenforcement.View.USER;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class judges_assign_case_cell_controller implements Initializable {

    public USER user1;
    public judges_assign_case_cell_controller(USER user1) {
        this.user1 = user1;
    }
    @FXML
    private Label complainNO;
    @FXML
    private Label crime;
    @FXML
    private AnchorPane danchore;
    @FXML
    private Circle dp;
    @FXML
    private Label location;
    @FXML
    private Label name;
    @FXML
    private FontAwesomeIconView r;
    @FXML
    private Label show;
    @FXML
    private FontAwesomeIconView w;


    @Override
    public void initialize(URL url, ResourceBundle resources) {
        name.setText(user1.getName());
        show.setText(user1.getDate());

        //System.out.println(user.getVic_img());

        String p = user1.getVic_img();
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        if(!user1.getDate().equals("No FIR"))
        {
            w.setVisible(true);
            r.setVisible(false);
        }

        else
        {
            w.setVisible(false);
            r.setVisible(true);
        }

        name.setOnMouseClicked(MouseEvent -> go_inbox());

    }

    public void go_inbox ()  {

        if(!user1.getDate().equals("No FIR")) {
//            Victim_case vc = new Victim_case();
//            vc.set_user(user1);

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/JUDGES/vic_case.fxml"));
            try {
                vic_case_fxml vc = new vic_case_fxml();
                vc.set_user(user1);

                Global.createStage(fxmlLoader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
