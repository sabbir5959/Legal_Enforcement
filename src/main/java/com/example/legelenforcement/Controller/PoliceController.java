package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.Police;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class PoliceController implements Initializable {
    @FXML
    private FontAwesomeIconView cross;

    @FXML
    private TableColumn<Police, String> BatchCol;

    @FXML
    private TableColumn<Police, String> NoCol;

    @FXML
    private TextField filter;

    @FXML
    private TableColumn<Police, String> joindateCol;

    @FXML
    private TableColumn<Police, String> nameCol;

    @FXML
    private TableView<Police> policelist;

    @FXML
    private TableColumn<Police, String> rankCol;

    @FXML
    private Label searchLabel;
    ObservableList<Police> PoliceList;
    PoliceConnection dc;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    public WebView web= new WebView();
    public ImageView img2 = new ImageView();

    @FXML
    void CROSS(MouseEvent event) throws IOException{
        Global.closeStage(cross);
    }

    public void complaint_list(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/Criminal_List.fxml"));
        Global.switch_scene(root,event);
    }

    public void police_user(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/policeUser.fxml"));
        Global.switch_scene(root,event);
    }

    public void police_profile(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/profile.fxml"));
        Global.switch_scene(root,event);
    }

    public void newPDFpage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/criminalLaw.fxml"));
        Global.switch_scene(root,event);
    }
    @FXML
    public void open_web(ActionEvent event) throws URISyntaxException, IOException{
        web.setVisible(true);
        web.getEngine().load("http://bdlaws.minlaw.gov.bd/laws-of-bangladesh.html");
    }

    public void official(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }

    public void back_home(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }

    public void officials(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }

    public void vic_profile(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/Case_list.fxml"));
        Global.switch_scene(root,event);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        web.setVisible(false);
        img2.setVisible(true);

        dc = new PoliceConnection();
        Connection conn = PoliceConnection.Connect();
        PoliceList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM officers " +
                    "ORDER BY " +
                    "CASE " +
                    "  WHEN `Rank` = 'Commissioner' THEN 1 " +
                    "  WHEN `Rank` = 'DeputyCheif' THEN 2 " +
                    "  WHEN `Rank` = 'Captain' THEN 3 " +
                    "  WHEN `Rank` = 'Liutenant' THEN 4 " +
                    "  WHEN `Rank` = 'Sergeant' THEN 5 " +
                    "  ELSE 6 " +
                    "END";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {

                PoliceList.add(new Police(rs.getString("ID"), rs.getString("BatchNo"), rs.getString("Name"), rs.getString("Rank"), rs.getString("JoinDate")));
            }

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        NoCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        BatchCol.setCellValueFactory(new PropertyValueFactory<>("BatchNo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        rankCol.setCellValueFactory(new PropertyValueFactory<>("Rank"));
        joindateCol.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
        policelist.setItems(PoliceList);

        FilteredList<Police> filteredData = new FilteredList<>(PoliceList, b -> true);
        filter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(police -> {
                if (newValue == null || newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (police.getID().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (police.getBatchNo().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (police.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (police.getRank().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return police.getJoinDate().toLowerCase().contains(lowerCaseFilter);
                }
            });
        });
        SortedList<Police> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(policelist.comparatorProperty());
        policelist.setItems(sortedData);
    }

}