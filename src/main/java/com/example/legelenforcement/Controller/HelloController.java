package com.example.legelenforcement.Controller;

import com.example.legelenforcement.Global;
import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.Criminal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField Id;

    @FXML
    private TextField Name;

    @FXML
    private ComboBox<String> crimeCombo;

    @FXML
    private TableColumn<Criminal,String> NoCol;

    public Button btnDelete;

    public Button btnInsert;

    @FXML
    private TextField crime;
    @FXML
    private TextField filter;

    @FXML
    private TableColumn<Criminal,String> crimeCol;

    @FXML
    private TableColumn<Criminal,String> nameCol;
    @FXML
    private TableView<Criminal> criminalList;

    ObservableList<Criminal> CriminalList;
    //ObservableList<Criminal>List;
    DbConnection dc;

    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    public WebView web= new WebView();
    public ImageView img2 = new ImageView();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        web.setVisible(false);
        img2.setVisible(true);

        ObservableList<String> crimeOptions = FXCollections.observableArrayList();
        crimeOptions.add("Murder");
        crimeOptions.add("Homicide");
        crimeOptions.add("Stealing");
        crimeOptions.add("Robbery");
        crimeOptions.add("Kidnapping");
        crimeOptions.add("Arson");
        crimeCombo.setItems(crimeOptions);
        loadData();


    }
    private void loadData()
    {
        dc = new DbConnection();
        Connection conn = DbConnection.Connect();
        CriminalList = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM criminal_list");
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {

                CriminalList.add(new Criminal(rs.getString("idcriminal_list"), rs.getString("Criminal_name"), rs.getString("Crime")));
            }


        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        NoCol.setCellValueFactory(new PropertyValueFactory<>("idcriminal_list"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Criminal_name"));
        crimeCol.setCellValueFactory(new PropertyValueFactory<>("Crime"));

        //criminalList.setItems(null);

        criminalList.setItems(CriminalList);
        searchFilterData();
    }
    private void searchFilterData()
    {
        FilteredList<Criminal> filteredData = new FilteredList<>(CriminalList, b -> true);
        filter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Criminal -> {
                if (newValue == null || newValue.isEmpty()||newValue.isBlank()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(Criminal.getIdcriminal_list().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (Criminal.getCriminal_name().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if (Criminal.getCrime().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else
                    return false; // Does not match.
            });
        });
        SortedList<Criminal> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(criminalList.comparatorProperty());
        criminalList.setItems(sortedData);
    }
    @FXML
    void DeleteFromDataBase(ActionEvent event) {


        //dc = new DbConnection();
        Connection conn = DbConnection.Connect();
        String sql = "delete from criminal_list where Criminal_name = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Name.getText());
            pst.execute();
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        loadData();
    }

    @FXML
    void InsertIntoDataBase(ActionEvent event) {
        Connection conn = DbConnection.Connect();
        String sql = "insert into criminal_list(idcriminal_list,Criminal_name,Crime)values(?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Id.getText());
            pst.setString(2, Name.getText());
            pst.setString(3, crimeCombo.getValue());
            pst.execute();
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        loadData();

    }

    public void police_list(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/Police.fxml"));
        Global.switch_scene(root,event);
    }

    public void police_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/profile.fxml"));
        Global.switch_scene(root,event);
    }

    public void police_user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/policeUser.fxml"));
        Global.switch_scene(root,event);
    }

    public void official(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/official.fxml"));
        Global.switch_scene(root,event);
    }

    public void back_home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/DASHBOARD/fullSystem.fxml"));
        Global.switch_scene(root,event);
    }

    public void vic_profile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/Case_list.fxml"));
        Global.switch_scene(root,event);
    }

    public void newPDFpage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("FXML/POLICE/criminalLaw.fxml"));
        Global.switch_scene(root,event);
    }
    @FXML
    public void open_web(ActionEvent event) throws URISyntaxException, IOException{
        web.setVisible(true);
        web.getEngine().load("http://bdlaws.minlaw.gov.bd/laws-of-bangladesh.html");
    }
}