package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.FIR;
import com.example.legelenforcement.View.USER;
import com.example.legelenforcement.View.log_in;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class judges_assign_case_list implements Initializable {
    @FXML
    private FontAwesomeIconView cross;
    static log_in log = new log_in();
    USER user1 = new USER();
    public void set_log(log_in log) {
        this.log = log;
    }
    @FXML
    private ListView<USER> assign_case_list;
    private ObservableList<USER> observableList;
    public void view_history() throws FileNotFoundException {

        observableList = FXCollections.observableArrayList();
        sett_items();
        assign_case_list.setItems(observableList);
        assign_case_list.setCellFactory(victim_view -> new judges_assign_case_cell_factory());
    }

//    public void set_FIR(String c) throws FileNotFoundException {
//
//        File directory = new File("E:/Java Code/Java Files/Sign Up/Judges Sign Up/" + c + "/case");
//
//        if (directory.exists() && directory.isDirectory()) {
//
//            File[] filesAndDirs = directory.listFiles();
//
//            if (filesAndDirs != null) {
//                for (File fileOrDir : filesAndDirs) {
//                    if (fileOrDir.isDirectory()) {
//                        String c1 = fileOrDir.getName();
//
//                        File infoFile2 = new File("E:/Java Code/Java Files/Sign Up/Judges Sign Up/" + c + "/case/" + c1 + "/info.txt");
//
//                        if (infoFile2.exists()) {
//
//                            FIR fir = new FIR();
//                            Scanner sc = new Scanner(infoFile2);
//
//                            sc.useDelimiter("\n");
//
//                            String l1 = sc.next();
//                            fir.setComplainNo(l1);
//                            String l2 = sc.next();
//                            fir.setLocation(l2);
//                            String l3 = sc.next();
//                            fir.setCrime(l3);
//                            String l4 = sc.next();
//                            fir.setDate(l4);
//
//                            sc.close();
//
//                            observableList.add(fir);
//                        }
//                    }
//                }
//            }
//        }
//    }

//    public USER set_FIR(String c,USER user) throws FileNotFoundException {
//
//        File directory = new File("E:/Java Code/Java Files/Sign Up/Judges Sign Up/" + c + "/case");
//
//        // Check if the directory exists
//        if (directory.exists() && directory.isDirectory()) {
//            // List the files and subdirectories in the directory
//            File[] filesAndDirs = directory.listFiles();
//
//            if (filesAndDirs != null) {
//                for (File fileOrDir : filesAndDirs) {
//                    if (fileOrDir.isDirectory()) {
//                        String c1 = fileOrDir.getName();
////                        System.out.println("here date " + c1);
//                        File infoFile2 = new File("E:/Java Code/Java Files/Sign Up/Judges Sign Up/" + c + "/case/" + c1 + "/info.txt");
//
//                        if (infoFile2.exists()) {
//                            FIR fir = new FIR();
//                            Scanner sc = new Scanner(infoFile2);
//
//                            sc.useDelimiter("\n");
//
//                            String l1 = sc.next();
//                            user.setComplainNo(l1);
//                            String l2 = sc.next();
//                            user.setLocation(l2);
//                            String l3 = sc.next();
//                            user.setCrime(l3);
//                            String l4 = sc.next();
//                            user.setDate(l4);
//                            String l5 = sc.next();
//                            user.setDescription(l5);
//
//                            sc.close();
//                        }
//                        break;
//                    }
//
//                    else {
////                        System.out.println("No FIR");
//                        user.setComplainNo("No FIR");
//                        user.setLocation("No FIR");
//                        user.setCrime("No FIR");
//                        user.setDate("No FIR");
//                        user.setDescription("No FIR");
//                    }
//                }
//            }
//        }
//        return user;
//    }

    public USER get_victim(String c) throws FileNotFoundException {

        File infoFile2 = new File("E:/Java Code/Java Files/Sign Up/Judges Sign Up/" + log.getUser() + "/case/" + c + "/info.txt");

        USER user = new USER();

        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);

            sc.useDelimiter("\n");

            String l1 = sc.next();
            user.setName(l1);
            String l2 = sc.next();
            user.setLocation(l2);
            //System.out.println("here " + l2);
            String l3 = sc.next();
            user.setComplainNo(l3);
            String l4 = sc.next();
            user.setCrime(l4);
            String l5 = sc.next();
            user.setDate(l5);
            String l6 = sc.next();
            user.setDob(l6);
            String l7 = sc.next();
            user.setEmail(l7);
            String l8 = sc.next();
            user.setAddress(l8);
            String l9 = sc.next();
            user.setPhone(l9);
            String l10 = sc.next();
            user.setDescription(l10);
            String l11 = sc.next();
            user.setVic_img(l11);


            sc.close();
        }
        //USER user1 = set_FIR(c,user);
        return user;
    }

    public void sett_items() throws FileNotFoundException {

        String directoryPath = "E:/Java Code/Java Files/Sign Up/Judges Sign Up/" + log.getUser() + "/case";
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
    public void back_home(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }
    public void judge_profile(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/judgeProfile.fxml"));
        Global.switch_scene(root,event);
    }
    public void judge_user(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/JUDGES/judgesUser.fxml"));
        Global.switch_scene(root,event);
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

