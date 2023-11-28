package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.check_email;
import com.example.legelenforcement.View.check_mobile;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
public class victimOrder extends Victim_Login{

//    @FXML
//    private FontAwesomeIconView cross;
//    @FXML
//    void CROSS(MouseEvent event) throws IOException
//    {
//        Global.closeStage(cross);
//    }

    static check_email checkEmail = new check_email();
    static check_mobile checkMobile = new check_mobile();
    public Circle circle, circle2;
    @FXML
    private DatePicker DATE;

    public void dashboard_img(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }

    public void victim_user(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimUser.fxml"));
        Global.switch_scene(root,event);
    }

    @FXML
    private void insert_photo(MouseEvent event) throws IOException {
        FileChooser ch= new FileChooser();
        File file = ch.showOpenDialog(null);
        String p = file.toURI().toString();
        person.setTimage(p);
        Image image = new Image(p);
        circle.setFill(new ImagePattern(image));
        IMG(p);
    }
    public void victim_users (ActionEvent event) throws IOException {
        boolean check = checkEmail.isEmailValid(email.getText());
        boolean check2 = checkMobile.isValid(mobile.getText());

        if (full_name.getText().isEmpty() || user_name.getText().isEmpty() || father_name.getText().isEmpty() || mother_name.getText().isEmpty()
                || email.getText().isEmpty() || address.getText().isEmpty() || pass.getText().isEmpty() || confirmPass.getText().isEmpty() || (DATE.getValue()==null)
                || mobile.getText().isEmpty() || (!male.isSelected()&& !female.isSelected()&&!other.isSelected()) || (!married.isSelected()&&!unmarried.isSelected()) || person.getTimage().isEmpty()) {

            labelShow.setText("Fill out all the fields to proceed.");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent-> labelShow.setText("")));
            timeline.play();
            return;}
        else{

            if (!pass.getText().equals(confirmPass.getText())) {
                labelShow.setText("Password and confirm password must be same");//42
                return;}
            else if(!check){
                    labelShow.setText("Provide an authentication mail");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), actionEvent -> labelShow.setText("")));
                    timeline.play();
                    return;
            } else if (!check2) {
                    labelShow.setText("Please check your mobile number");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), actionEvent -> labelShow.setText("")));
                    timeline.play();
                    return;
            }
        }

          boolean isUserCreated = create_user();
           if (!isUserCreated) return;

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimUser.fxml"));
        Global.switch_scene(root,event);
    }
}
