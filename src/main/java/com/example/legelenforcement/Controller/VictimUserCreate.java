package com.example.legelenforcement.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.*;
import javafx.util.Duration;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VictimUserCreate extends victim{
    public TextField vic_user, full_name, email, mobile, user_name, address, father_name, mother_name, dateOfbirth, complainNo;
    public PasswordField pass, confirmPass;
    public RadioButton male, female, other, married, unmarried;
    public ToggleGroup gender, marry;
    public Label labelShow, msg_show, wrong_msg;
    static String img ;
    public void IMG(String i){
        img = i;
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
            if (file.getName().equals(full_name) && file.getName().equals(email) && file.getName().equals(mobile)) {
                // System.out.println("Account already exists");
                labelShow.setText("Account already exists.");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent-> labelShow.setText("")));
                timeline.play();
            }
        }

        File userFile = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + tuser_name);
        boolean is_user_file_created = userFile.mkdir();

        File infoFile = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + tuser_name + "/info.txt");
        infoFile.createNewFile();

        FileWriter writer = new FileWriter(infoFile);
        writer.write(tname + "\n");
        writer.write(tuser_name + "\n");
        writer.write(tfather + "\n");
        writer.write(tmother + "\n");
        writer.write(tmobile + "\n");
        writer.write(temail + "\n");
        writer.write(taddress + "\n");
        writer.write(tbirthDate + "\n");
        writer.write(tpass + "\n");
        writer.write(tgender + "\n");
        writer.write(tmarry + "\n");
        writer.write(img+ "\n");
        writer.close();

        return true;
    }
}

