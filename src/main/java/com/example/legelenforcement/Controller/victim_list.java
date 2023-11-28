package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.USER;
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

public class victim_list  implements Initializable {
    @FXML
    private FontAwesomeIconView cross;
    USER user1 = new USER();

    @FXML
    private ListView<USER> victim_view;
    private ObservableList<USER> observableList;
    public void view_history() throws FileNotFoundException {

        observableList = FXCollections.observableArrayList();
        sett_items();
        victim_view.setItems(observableList);
        victim_view.setCellFactory(victim_view -> new victim_list_cell_factory());
    }

    public void sett_items() throws FileNotFoundException {

        String directoryPath = "E:/Java Code/Java Files/Sign Up/Victim Sign Up";
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {
                    if (fileOrDir.isDirectory()) {
                        String c1= fileOrDir.getName();

                        USER newUser = get_victim(c1);

                        observableList.add(newUser);

                    }
                }
            }
        }
    }

    public USER set_FIR(String c,USER user) throws FileNotFoundException {

        File directory = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + c);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {
                    if (fileOrDir.isDirectory()) {
                        String c1 = fileOrDir.getName();
//                        System.out.println("here date " + c1);
                        File infoFile2 = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + c + "/" + c1 + "/FIR.txt");

                        if (infoFile2.exists()) {
                            Scanner sc = new Scanner(infoFile2);

                            sc.useDelimiter("\n");

                            String l1 = sc.next();
                            user.setComplainNo(l1);
                            String l2 = sc.next();
                            user.setLocation(l2);
                            String l3 = sc.next();
                            user.setCrime(l3);
                            String l4 = sc.next();
                            user.setDate(l4);
                            String l5 = sc.next();
                            user.setDescription(l5);

                            sc.close();
                        }
                        break;
                    }

                    else {
//                        System.out.println("No FIR");
                        user.setComplainNo("No FIR");
                        user.setLocation("No FIR");
                        user.setCrime("No FIR");
                        user.setDate("No FIR");
                        user.setDescription("No FIR");
                    }
                }
            }
        }
        return user;
    }

    public USER get_victim(String c) throws FileNotFoundException {

        File infoFile2 = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/"+c+"/info.txt");

        USER user = new USER();

        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);

            sc.useDelimiter("\n");

            String l1 = sc.next();
            String l2 = sc.next();
            user.setName(l2);
            //System.out.println("here " + l2);
            String l3 = sc.next();
            String l4 = sc.next();
            String l5 = sc.next();
            user.setPhone(l5);
            String l6 = sc.next();
            user.setEmail(l6);
            String l7 = sc.next();
            user.setAddress(l7);
            String l8 = sc.next();
            user.setDob(l8);
            String l9 = sc.next();
            String l10 = sc.next();
            String l11 = sc.next();
            String l12 = sc.next();
            user.setVic_img(l12);

            sc.close();
        }
        USER user1 = set_FIR(c,user);
        return user;
    }
    public void official(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }
    public void complaint_list(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/Criminal_List.fxml"));
        Global.switch_scene(root,event);
    }
    public void police_list(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/Police.fxml"));
        Global.switch_scene(root,event);
    }
    public void police_profile(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/profile.fxml"));
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
    public void newPDFpage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/criminalLaw.fxml"));
        Global.switch_scene(root,event);
    }

    public void about(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/DASHBOARD/AboutUs/about.fxml"));
        Global.createStage(fxmlLoader);
    }
    @FXML
    void CROSS(MouseEvent event) throws IOException{
        Global.closeStage(cross);
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
