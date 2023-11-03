package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.fileReadWrite;
import com.example.legelenforcement.View.log_in;
import com.example.legelenforcement.View.person;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Victim_Login extends VictimUserCreate {
     public Label VFname , Vname , Vfather , Vmother , Vemail, Vaddress ;
    public TextField vic_user, full_name, email, mobile, user_name, address, father_name, mother_name, dateOfbirth, complainNo;
    @FXML
    private Label error_text1;
    public Button CLOSE ;
    public PasswordField pass, confirmPass;
    public TextArea description;
    public AnchorPane label_anchor = new AnchorPane();
    @FXML
    private ImageView img1;
    @FXML
    private PasswordField passwordHidden;
    @FXML
    private CheckBox check_box;
     static log_in log = new log_in();
     static person person = new person();

    public void victim_login(ActionEvent event) throws IOException {
        String tuser = vic_user.getText();
        String tpass = passwordHidden.getText();

        log = new log_in(tuser, tpass);
        if (log.getUser().isBlank() || log.getPassword().isBlank())
        {
            error_text1.setText("  Fill out all the fields to proceed");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> error_text1.setText("")));
            timeline.play();
        }

        if (log.getUser().length() > 0 && log.getPassword().length() > 0) {
            File infoFile2 = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + log.getUser() + "/info.txt");

            if (infoFile2.exists()) {
                Scanner sc = new Scanner(infoFile2);

                sc.useDelimiter("\n");

                String p = sc.next();
                person.setTname(p);
                p = sc.next();
                person.setTuser_name(p);
                p = sc.next();
                person.setTfather(p);
                p = sc.next();
                person.setTmother(p);
                p = sc.next();
                person.setTmobile(p);
                p = sc.next();
                person.setTemail(p);
                p = sc.next();
                person.setTaddress(p);
                p = sc.next();
                person.setTbirthDate(p);
                p = sc.next();
                person.setTpass(p);
                p = sc.next();
                person.setTgender(p);
                p=sc.next();
                person.setTmarry(p);
                p=sc.next();
                person.setTimage(p);

                System.out.println(person.getTpass().length());
                System.out.println(log.getPassword().length());

                if (person.getTpass().equals(log.getPassword())) {
                    VictimFirCreate fir = new VictimFirCreate();
                    fir.set_login(log);
                    VICTIM_profile victimProfile = new VICTIM_profile();
                    victimProfile.set_person(person);
                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimProfile.fxml"));
                    Global.switch_scene(root,event);

                } else {
                    error_text1.setText("        Password doesn't match");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> error_text1.setText("")));
                    timeline.play();
                }

            } else {
                error_text1.setText("Please check username/password");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> error_text1.setText("")));
                timeline.play();
            }
        }

    }

}


