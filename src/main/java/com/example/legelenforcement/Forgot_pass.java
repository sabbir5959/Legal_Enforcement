//package com.example.legelenforcement;
//
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.util.Duration;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import java.util.Scanner;
//
//public class Forgot_pass implements Initializable
//{
//    public AnchorPane first_pane;
//    public FontAwesomeIconView close_icon;
//    public TextField provide_mail;
//    public Button first_next;
//    public AnchorPane second_pane;
//    public FontAwesomeIconView back_button_second_pane;
//    public TextField auth_mail;
//    public Button second_next;
//    public AnchorPane third_pane;
//    public FontAwesomeIconView back_button_third_pane;
//    public TextField auth_code;
//    public Button third_pane_next;
//    public AnchorPane fourth_pane;
//    public FontAwesomeIconView back_button_fourth_pane;
//    public PasswordField new_pass;
//    public PasswordField confirm_pass;
//    public FontAwesomeIconView unmask_pass;
//    public FontAwesomeIconView unslashed_unmask_pass;
//    public TextField unmasked_new_pass;
//    public TextField unmasked_confirm_pass;
//    public Button set_password;
//    public AnchorPane last_pane;
//    public Button log_in;
//    public Label message;
//    public Label new_pass_message;
//    public Label auth_mail_message;
//    public Label code_message;
//    public static int code;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//    }
//    private void existence_of_account()
//    {
//        if(provide_mail.getText().isBlank())
//        {
//            message.setText("Provide an email address");
//            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event-> message.setText("")));
//            timeline.play();
//        }
//        elsea
//        {
//            Object Fpath = new Object();
//            File file = new File(Fpath.data_path+"Data/Client/"+provide_mail.getText());
//            if(file.exists()) second_pane.setVisible(true);
//            else
//            {
//                message.setText("Account not found");
//                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event-> {message.setText(""); provide_mail.clear();}));
//                timeline.play();
//            }
//
//        }
//    }
//
//    private void send_email()
//    {
//        if(auth_mail.getText().isBlank())
//        {
//            auth_mail_message.setText("Provide an authentication mail");
//            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event-> auth_mail_message.setText("")));
//            timeline.play();
//        }
//        else
//        {
//            try
//            {
//                JavaMail javaMail = new JavaMail(auth_mail.getText());
//                Thread thread = new Thread(javaMail);
//                thread.setDaemon(true);
//                thread.start();
//
//                third_pane.setVisible(true);
//            }
//            catch (Exception e)
//            {
//                auth_mail_message.setText("Email not sent");
//                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event-> auth_mail_message.setText("")));
//                timeline.play();
//            }
//        }
//    }
//
//    private void check_security_code()
//    {
//        if(auth_code.getText().isBlank())
//        {
//            code_message.setText("Code cannot be blank");
//            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event-> code_message.setText("")));
//            timeline.play();
//        }
//        else
//        {
//            if(auth_code.getText().equals(String.valueOf(code))) set_fourth_pane();
//            else
//            {
//                code_message.setText("Code do not match");
//                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event-> code_message.setText("")));
//                timeline.play();
//            }
//        }
//    }
//
//    private void set_fourth_pane()
//    {
//        fourth_pane.setVisible(true);
//        new_pass.setVisible(true);
//        confirm_pass.setVisible(true);
//        unmasked_new_pass.setVisible(false);
//        unmasked_confirm_pass.setVisible(false);
//        unslashed_unmask_pass.setVisible(false);
//
//        new_pass.textProperty().bindBidirectional(unmasked_new_pass.textProperty());
//        confirm_pass.textProperty().bindBidirectional(unmasked_confirm_pass.textProperty());
//
//        unmask_pass.setOnMouseClicked(MouseEvent ->
//        {
//            new_pass.setVisible(false);
//            confirm_pass.setVisible(false);
//            unmasked_new_pass.setVisible(true);
//            unmasked_confirm_pass.setVisible(true);
//            unslashed_unmask_pass.setVisible(true);
//            unmask_pass.setVisible(false);
//        });
//
//        unslashed_unmask_pass.setOnMouseClicked(MouseEvent ->
//        {
//            new_pass.setVisible(true);
//            confirm_pass.setVisible(true);
//            unmasked_new_pass.setVisible(false);
//            unmasked_confirm_pass.setVisible(false);
//            unslashed_unmask_pass.setVisible(false);
//            unmask_pass.setVisible(true);
//        });
//
//
//        set_password.setOnMouseClicked(MouseEvent -> update_password());
//    }
//
//    private void update_password()
//    {
//        if(new_pass.getText().isBlank() || confirm_pass.getText().isBlank())
//        {
//            new_pass_message.setText("New password cannot be empty");
//            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event-> new_pass_message.setText("")));
//            timeline.play();
//        }
//
//        if(!new_pass.getText().equals(confirm_pass.getText()))
//        {
//            new_pass_message.setText("Passwords do not match");
//            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event-> new_pass_message.setText("")));
//            timeline.play();
//        }
//        else
//        {
//            String mail, name, gender, bdate, facebook, home;
//
//            try
//            {
//                File file = new File(Fpath.data_path+"Data/Client/"+provide_mail.getText()+"/name-pass.txt");
//                Scanner sc = new Scanner(file);
//
//                mail = sc.next();
//                sc.next();
//                sc.nextLine();
//                name = sc.nextLine();
//                gender =  sc.next();
//                bdate = sc.next();
//                facebook = sc.next();
//                sc.nextLine();
//                home = sc.nextLine();
//
//                sc.close();
//
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
