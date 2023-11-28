package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class victim implements Initializable {
    public Button CLOSE ;
    public TextField vic_user, full_name, email, mobile, user_name, address, father_name, mother_name, dateOfbirth, complainNo;
    public PasswordField pass, confirmPass;
    public ToggleGroup gender, marry;
    public RadioButton male, female, other, married, unmarried;
    public Text success_message;
    public Label labelShow, msg_show, wrong_msg;
    public TextArea description;
    public AnchorPane label_anchor = new AnchorPane();
    @FXML
    private ImageView img1;
    @FXML
    private PasswordField passwordHidden;
    @FXML
    private CheckBox check_box;
    @FXML
    private TextField passwordText;
    @FXML
    private ComboBox<String> location = new ComboBox<>();
    private String[]  location_value= {"Mirpur-1", "Mirpur-2","Mirpur-10", "Mirpur-11", "Mirpur-12", "Mirpur-13", "Mirpur-14" };
    @FXML
    private ComboBox<String> crime = new ComboBox<>();
    private String[]  crime_value= {"Murder", "Robbery","Snatching", "kidnapping", "Drug abuse", "Trafficking", "Theft", "Bulgary", "Assault"};
    @FXML
    private DatePicker dateOfCrime;
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
    private void insert_photo(MouseEvent event) throws IOException {
        FileChooser ch = new FileChooser();
        FileChooser.ExtensionFilter exxtfilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter exxtfilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        ch.getExtensionFilters().addAll(exxtfilterJPG, exxtfilterPNG);
        File file = ch.showOpenDialog(null);
        Image image = new Image(file.toURI().toString());
        img1.setImage(image);
    }
    public void back_home(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }
    public void back_victim(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimUser.fxml"));
        Global.switch_scene(root,event);
    }
    public void victim_reg(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimReg.fxml"));
        Global.switch_scene(root,event);
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
        Global.switch_scene(root,event);
    }
    public void victim_profile(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimProfile.fxml"));
        Global.switch_scene(root,event);
    }
    public void victim_create_pass(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/VICTIM/FORGOT/createNewPass.fxml"));
        Global.switch_scene(root,event);
    }
    public void complain_list(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/VICTIM/complaintList.fxml"));
        Global.switch_scene(root,event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        location.getItems().addAll(location_value);
        crime.getItems().addAll(crime_value);
        label_anchor.setVisible(false);
    }
}