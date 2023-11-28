package com.example.legelenforcement;

import com.example.legelenforcement.Controller.victim;
import com.example.legelenforcement.View.check_email;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Forgot_pass extends victim
{
    public TextField provide_mail, auth_mail, auth_code, user_N;
    public PasswordField new_pass, confirm_pass;
    public Button log_in;
    @FXML
    private FontAwesomeIconView cross;
    @FXML
    private FontAwesomeIconView back_forgot;
    @FXML
    private FontAwesomeIconView back_OTP;
    public Label message, new_pass_message, auth_mail_message, code_message;
    public static int code;
    static String fp ;
    static check_email checkEmail = new check_email();
    @FXML
    void CROSS(MouseEvent event) throws IOException{
        Global.closeStage(cross);
    }
    @FXML
    void BACK_FORGOT(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/VICTIM/FORGOT/forgotPass.fxml"));
        Global.switch_scene(root,event);
    }
    @FXML
    void BACK_OTP(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/VICTIM/FORGOT/OTP.fxml"));
        Global.switch_scene(root,event);
    }

    public boolean check_email(String u,String e) throws FileNotFoundException {
        File infoFile2 = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + u + "/info.txt");

        Scanner sc = new Scanner(infoFile2);

        sc.useDelimiter("\n");

        String p = sc.next();
        p = sc.next();
        p = sc.next();
        p = sc.next();
        p = sc.next();
        p = sc.next();

//        if(p.equals(e))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
        check_email checkEmail = new check_email();
        return check_email.isEmailValid(p,e);
    }

    public void victim_otp_verify(ActionEvent event) throws IOException {

        boolean check = checkEmail.isEmailValid(auth_mail.getText());

        if (auth_mail.getText().isBlank() && user_N.getText().isBlank()) {
            message.setText("Fill out all the fields to proceed.");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ev -> message.setText("")));
            timeline.play();
        } else if (auth_mail.getText().isBlank() || !check) {
            message.setText(" Provide an authentication mail");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ev -> message.setText("")));
            timeline.play();
        } else if (user_N.getText().isBlank()) {
            message.setText("Provide your Username");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ev -> message.setText("")));
            timeline.play();
        } else {
            boolean p = check_email(user_N.getText(), auth_mail.getText());

            if (p) {
                try {
                    fp = user_N.getText();
                    Mail_background mail_background_task = new Mail_background(auth_mail.getText());
                    Thread thread = new Thread(mail_background_task);
                    thread.setDaemon(true);
                    thread.start();

                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/VICTIM/FORGOT/OTP.fxml"));
                    Global.switch_scene(root, event);
                } catch (Exception e) {
                    auth_mail_message.setText("Email not sent");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev -> auth_mail_message.setText("")));
                    timeline.play();
                }
            } else {
                message.setText("Email not found");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev -> message.setText("")));
                timeline.play();
            }
        }
    }

    public void victim_create_pass(ActionEvent event) throws IOException {

        if(auth_code.getText().isBlank())
        {
            code_message.setText("Code cannot be blank");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev-> code_message.setText("")));
            timeline.play();
        }
        else
        {
            if(auth_code.getText().equals(String.valueOf(code)))
            {
                Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/VICTIM/FORGOT/createNewPass.fxml"));
                Global.switch_scene(root,event);
            }
            else
            {
                code_message.setText("Code doesn't match");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev-> code_message.setText("")));
                timeline.play();
            }
        }
    }

    public void close(ActionEvent event) throws IOException {

        String tnew = new_pass.getText();
        String tconfirm = confirm_pass.getText();

        if(new_pass.getText().isBlank() || confirm_pass.getText().isBlank())
        {
            new_pass_message.setText("New password cannot be empty");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev-> new_pass_message.setText("")));
            timeline.play();
        }

        else if(!new_pass.getText().equals(confirm_pass.getText()))
        {
            new_pass_message.setText("Passwords do not match");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev-> new_pass_message.setText("")));
            timeline.play();
        }
        else
        {
            try
            {
                File path = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + fp + "/info.txt");
                Scanner sc = new Scanner(path);
                ArrayList<String> lines = new ArrayList<>();

                sc.useDelimiter("\n");

                String p = sc.next();
                String l1 = p;
                p = sc.next();
                String l2 = p;
                p = sc.next();
                String l3 = p;
                p = sc.next();
                String l4 = p;
                p = sc.next();
                String l5 = p;
                p = sc.next();
                String l6 = p;
                p = sc.next();
                String l7 = p;
                p = sc.next();
                String l8 = p;
                p = sc.next();
                String l9 = p;
                p = sc.next();
                String l10 = p;
                p = sc.next();
                String l11 = p;
                p = sc.next();
                String l12 = p;

                BufferedWriter writer = new BufferedWriter(new FileWriter(path));

                writer.write(l1 + "\n");
                writer.write(l2 + "\n");
                writer.write(l3 + "\n");
                writer.write(l4 + "\n");
                writer.write(l5 + "\n");
                writer.write(l6 + "\n");
                writer.write(l7 + "\n");
                writer.write(l8 + "\n");
                writer.write(tnew + "\n");
                writer.write(l10 + "\n");
                writer.write(l11 + "\n");
                writer.write(l12 + "\n");
                writer.close();

                Global.closeStage(CLOSE);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}

