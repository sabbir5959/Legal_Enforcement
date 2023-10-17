package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
public class victim implements Initializable {
    public Button CLOSE ;
    public TextField full_name, email, mobile, user_name, address, father_name, mother_name, dateOfbirth;
    public PasswordField pass, confirmPass;
    public ToggleGroup gender, marry;
    public RadioButton male, female, other, married, unmarried;
    public Text success_message;
    public Label labelShow;

    @FXML
    private ImageView img1;
    @FXML
    private PasswordField passwordHidden;
    @FXML
    private CheckBox check_box;
    @FXML
    private TextField passwordText;

    @FXML
    void changeVisibility(ActionEvent event) {
        if (check_box.isSelected()) {
            passwordText.setText(passwordHidden.getText());
            passwordText.setVisible(true);
            passwordHidden.setVisible(false);
            return;
        }
        passwordHidden.setText(passwordText.getText());
        passwordHidden.setVisible(true);
        passwordText.setVisible(false);
    }

    @FXML
    private void insert_photo(ActionEvent event) throws IOException {
        FileChooser ch = new FileChooser();
        FileChooser.ExtensionFilter exxtfilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter exxtfilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        ch.getExtensionFilters().addAll(exxtfilterJPG, exxtfilterPNG);
        File file = ch.showOpenDialog(null);
        Image image = new Image(file.toURI().toString());
        img1.setImage(image);
    }

    public void back_home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_user(ActionEvent event) throws IOException {

        if (full_name.getText().isBlank() || user_name.getText().isBlank() || father_name.getText().isBlank() || mother_name.getText().isBlank()
        || email.getText().isBlank() || address.getText().isBlank() || pass.getText().isBlank() || confirmPass.getText().isBlank() || dateOfbirth.getText().isBlank()
        || mobile.getText().isBlank() || (male.isSelected() || female.isSelected() || other.isSelected())) {
            labelShow.setText("Fill out all the fields to proceed.");}

//        else if (!Objects.equals(pass.getText(), confirmPass.getText())) {
//            labelShow.setText("Password and confirm password must be same");}

            boolean isUserCreated = create_user();
            if (!isUserCreated) return;

            Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimUser.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    public void back_victim(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimUser.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public boolean create_user() throws IOException {
        String tname = full_name.getText();
        String tuser_name = user_name.getText();
        String tfather = father_name.getText();
        String tmother = mother_name.getText();
        String temail = email.getText();
        String taddress = address.getText();
        String tpass = pass.getText();
        String tconfirmPass = confirmPass.getText();
        String tbirthDate = dateOfbirth.getText();
        String tmobile = mobile.getText();
        RadioButton genderButton = (RadioButton) gender.getSelectedToggle();
        String tgender = genderButton.getText();
        RadioButton marryButton = (RadioButton) marry.getSelectedToggle();
        String tmarry = marryButton.getText();

        File user_folder = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/");
        boolean is_user_folder_created = user_folder.mkdir();

        File[] files = user_folder.listFiles();

        assert files != null;
        for (File file : files) {
            if (file.getName().equals(full_name)) {
                System.out.println("Account already exists");
                return false;
            }
        }

        File userFile = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + tname);
        boolean is_user_file_created = userFile.mkdir();

        File infoFile = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + tname + "/info.txt");
        infoFile.createNewFile();

        FileWriter writer = new FileWriter(infoFile);
        writer.write(tname + "\n");
        writer.write(tfather + "\n");
        writer.write(tmother + "\n");
        writer.write(tmobile + "\n");
        writer.write(temail + "\n");
        writer.write(taddress + "\n");
        writer.write(tbirthDate + "\n");
        writer.write(tpass + "\n");
        writer.write(tgender + "\n");
        writer.write(tmarry + "\n");
        writer.close();

        return true;
    }

    public void victim_reg(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimReg.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimProfile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_fir(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimFIR.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_email(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/VICTIM/FORGOT/forgotPass.fxml"));
        Global.createStage(fxmlLoader);
    }
    public void close(ActionEvent event) throws IOException {
        Global.closeStage(CLOSE);
    }

    public void victim_otp_verify(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/VICTIM/FORGOT/OTP.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void victim_create_pass(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/VICTIM/FORGOT/createNewPass.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void complain_list(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/VICTIM/complaintList.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}


//    int i=0;
//    @FXML
//    private Text text;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        text.setText(String.valueOf(i));
//        final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e->{
//            i++;
//            text.setText(String.valueOf(i));
//
//        }));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
//    }

//    Timeline timeline = new Timeline(
//            new KeyFrame(Duration.seconds(1), event -> {
//                textProperty.set("New Text");
//            })
//    );
//    timeline.setCycleCount(Timeline.INDEFINITE);
//            timeline.play();



//if (!full_name.getText().isBlank() && !user_name.getText().isBlank() && !father_name.getText().isBlank() && !mother_name.getText().isBlank()
//        && !email.getText().isBlank() && !address.getText().isBlank() && !pass.getText().isBlank() && !confirmPass.getText().isBlank() && !dateOfbirth.getText().isBlank()
//        && !mobile.getText().isBlank() && (male.isSelected() || female.isSelected() || other.isSelected())) {
//        return;
//        }
//        Timeline timeline = new Timeline(
//            new KeyFrame(Duration.seconds(2), e -> {
//                success_message.setStyle("-fx-text-fill: #a81e14");
//                success_message.setText("Errrorrr");
//            })
//    );
//    timeline.setCycleCount(Timeline.INDEFINITE);
//            timeline.play();
//    }
//
//
//        else {
//        success_message.setStyle("-fx-text-fill: #a81e14");
//        success_message.setText("Fill out all the fields to proceed.");
//        }
//        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> success_message.setText("")));
//        timeline.play();



//    private void create_button_clicked()
//    {
//        if(create_account_button.getText().equals("Next"))
//        {
//            if(!first_name.getText().isBlank() && !last_name.getText().isBlank() && !password.getText().isBlank() && !corfirm_password.getText().isBlank()
//                    && !date_of_birth.getValue().toString().isBlank() && (male.isSelected() || female.isSelected() || other.isSelected()))
//            {
//                if(password.getText().equals(corfirm_password.getText()))
//                {
//                    first_name.setVisible(false);
//                    last_name.setVisible(false);
//                    password.setVisible(false);
//                    corfirm_password.setVisible(false);
//                    date_of_birth.setVisible(false);
//                    male.setVisible(false);
//                    female.setVisible(false);
//                    other.setVisible(false);
//
//                    email_id.setVisible(true);
//                    email_id_icon.setVisible(true);
//                    facebook_id.setVisible(true);
//                    fb_id_icon.setVisible(true);
//                    home_address.setVisible(true);
//                    home_address_icon.setVisible(true);
//                    back_button.setVisible(true);
//                    agree_to_policy.setVisible(true);
//                    terms_and_condition.setVisible(true);
//                    rest_of_the_message.setVisible(true);
//                    success_message.setVisible(true);
//
//                    create_account_button.setText("Create Account");
//                    personal_info_text.setText("Social Information");
//                    success_message.setText("");
//                }
//                else
//                {
//                    success_message.setStyle("-fx-text-fill: #a81e14");
//                    success_message.setText("Passwords don't match");
//                }
//            }
//            else
//            {
//                success_message.setStyle("-fx-text-fill: #a81e14");
//                success_message.setText("Fill out all the fields to proceed.");
//            }
//        }
//        else if(create_account_button.getText().equals("Create Account"))
//        {
//            if(!email_id.getText().isBlank() && !facebook_id.getText().isBlank() && !home_address.getText().isBlank())
//            {
//                if(agree_to_policy.isSelected())
//                {
//                    try
//                    {
//                        File file = new File(Fpath.data_path+"Data/Client/"+email_id.getText());
//                        if(file.exists())
//                        {
//                            success_message.setText("Account Already exists");
//                            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event->success_message.setText("")));
//                            timeline.play();
//                            return;
//                        }
//
//                        create_client_file();
//
//                        success_message.setStyle("-fx-text-fill: green");
//                        success_message.setText("Account Creation Successful.");
//
//                        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), event ->
//                        {
//                            create_account_button.setText("Next");
//
//                            first_name.setVisible(true); first_name.clear();
//                            last_name.setVisible(true); last_name.clear();
//                            password.setVisible(true); password.clear();
//                            corfirm_password.setVisible(true); corfirm_password.clear();
//                            date_of_birth.setVisible(true); date_of_birth.setValue(null);
//                            male.setVisible(true); male.setSelected(false);
//                            female.setVisible(true); female.setSelected(false);
//                            other.setVisible(true); other.setSelected(false);
//
//                            email_id.setVisible(false); email_id.clear();
//                            email_id_icon.setVisible(false);
//                            facebook_id.setVisible(false); facebook_id.clear();
//                            fb_id_icon.setVisible(false);
//                            home_address.setVisible(false); home_address.clear();
//                            home_address_icon.setVisible(false);
//                            back_button.setVisible(false);
//                            agree_to_policy.setVisible(false);
//                            terms_and_condition.setVisible(false);
//                            rest_of_the_message.setVisible(false);
//                            success_message.setVisible(false);
//                        }));
//                        timeline.setCycleCount(1);
//                        timeline.play();
//                    }
//                    catch (IOException e)
//                    {
//                        success_message.setStyle("-fx-text-fill: #a81e14");
//                        success_message.setText("Account Creation Failed");
//                    }
//                }
//                else
//                {
//                    success_message.setStyle("-fx-text-fill: #a81e14");
//                    success_message.setText("Agree to terms and condition to proceed.");
//                }
//            }
//            else
//            {
//                success_message.setStyle("-fx-text-fill: #a81e14");
//                success_message.setText("Fill out all the fields to proceed.");
//            }
//        }
//
//        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event->success_message.setText("")));
//        timeline.play();
//    }



