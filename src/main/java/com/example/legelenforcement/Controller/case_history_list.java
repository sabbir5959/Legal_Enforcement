package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.FIR;
import com.example.legelenforcement.View.USER;
import com.example.legelenforcement.View.log_in;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class case_history_list  implements Initializable {

    @FXML
    private FontAwesomeIconView cross;
    static log_in log = new log_in();
    public void set_log(log_in log) {
        this.log = log;
    }

    @FXML
    private ListView<FIR> victim_view;
    private ObservableList<FIR> observableList;
    public void view_history() throws FileNotFoundException {

        observableList = FXCollections.observableArrayList();
        set_FIR(log.getUser());
        victim_view.setItems(observableList);
        victim_view.setCellFactory(victim_view -> new case_history_cell_factory());
    }

    @FXML
    void CROSS(MouseEvent event) throws IOException{
        Global.closeStage(cross);
    }

    public void set_FIR(String c) throws FileNotFoundException {

        File directory = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + c);

        if (directory.exists() && directory.isDirectory()) {

            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {
                    if (fileOrDir.isDirectory()) {
                        String c1 = fileOrDir.getName();

                        File infoFile2 = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + c + "/" + c1 + "/FIR.txt");

                        if (infoFile2.exists()) {

                            FIR fir = new FIR();
                            Scanner sc = new Scanner(infoFile2);

                            sc.useDelimiter("\n");

                            String l1 = sc.next();
                            fir.setComplainNo(l1);
                            String l2 = sc.next();
                            fir.setLocation(l2);
                            String l3 = sc.next();
                            fir.setCrime(l3);
                            String l4 = sc.next();
                            fir.setDate(l4);

                            sc.close();

                            observableList.add(fir);
                        }

                    }
                }
            }
        }
    }

    public void official(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }
    public void victim_fir(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimFIR.fxml"));
        Global.switch_scene(root,event);
    }
    public void back_victim(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimUser.fxml"));
        Global.switch_scene(root, event);
    }
    public void victim_profile(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/Victim/victimProfile.fxml"));
        Global.switch_scene(root,event);
    }
    public void police_user(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/policeUser.fxml"));
        Global.switch_scene(root,event);
    }
    public void back_home(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
