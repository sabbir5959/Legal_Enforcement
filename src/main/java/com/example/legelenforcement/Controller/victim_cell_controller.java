package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.USER;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
public class victim_cell_controller implements Initializable
{

    public USER user;
    public victim_cell_controller(USER user) {
        this.user = user;
    }

    @FXML
    public Circle dp;

    @FXML
    private Label name;

    @FXML
    private FontAwesomeIconView r;
    @FXML
    private FontAwesomeIconView w;
    @FXML
    private Label show;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        name.setText(user.getName());
        show.setText(user.getDate());

        //System.out.println(user.getVic_img());

        String p = user.getVic_img();
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        if(!user.getDate().equals("No FIR"))
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

        if(!user.getDate().equals("No FIR")) {
//            Victim_case vc = new Victim_case();
//            vc.set_user(user);


            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/POLICE/victim_&_case.fxml"));
            try {


                Global.createStage(fxmlLoader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
