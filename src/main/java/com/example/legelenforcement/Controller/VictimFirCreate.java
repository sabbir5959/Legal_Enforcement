package com.example.legelenforcement.Controller;

import com.example.legelenforcement.View.log_in;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.util.Duration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class VictimFirCreate extends Victim_Login {
    @FXML
    private ComboBox<String> crime = new ComboBox<>();
    @FXML
    private ComboBox<String> location = new ComboBox<>();
    @FXML
    private DatePicker dateOfCrime;
    @FXML
    private PasswordField passwordHidden;
    static log_in log = new log_in();
    public void set_login(log_in lern)
   {
       log = lern;
//       i=1;
   }
//   static int i =1;
    public boolean fir_user() throws IOException {
        String tcomplainNo = complainNo.getText();
        String tlocation = location.getValue();
        String tcrime = crime.getValue();
        String tdescription = description.getText();
        LocalDate crimeDate = dateOfCrime.getValue();

        File userFile = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + log.getUser() +"/"+crimeDate);
        boolean is_user_file_created = userFile.mkdir();

        File infoFile = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + log.getUser() +"/"+ crimeDate + "/FIR.txt");
        infoFile.createNewFile();
        FileWriter writer = new FileWriter(infoFile);
        writer.write(tcomplainNo + "\n");
        writer.write(tlocation + "\n");
        writer.write(tcrime + "\n");
        writer.write(crimeDate + "\n");
        writer.write(tdescription + "\n");
        writer.close();

        return true;
    }
    public void submit_fir(ActionEvent event) throws IOException {

        if(complainNo.getText().isBlank() || location.getValue().isBlank() || crime.getValue().isBlank() || description.getText().isBlank())
        {
            wrong_msg.setText("Fill out all the fields to proceed.");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent-> labelShow.setText("")));
            timeline.play();
        }
        boolean isUserCreated = fir_user();
        if (isUserCreated) {
            label_anchor.setVisible(true);
            msg_show.setVisible(true);
            msg_show.setText("Submit Successfully");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), actionEvent-> label_anchor.setVisible(false)));
            timeline.play();
        }
        else return;
    }
}
