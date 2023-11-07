package com.example.legelenforcement.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CaseController implements Initializable {
    public Label searchLabel;

    @FXML
    private TableColumn<Case,String> NoCol;

    @FXML
    private TableView<Case> caseList;

    @FXML
    private TableColumn<Case,String> crimeCol;

    @FXML
    private TableColumn<Case,String> dateCol;

    @FXML
    private TextField filter;

    @FXML
    private TableColumn<Case,String> locationCol;

    @FXML
    private TableColumn<Case,String> statusCol;

    ObservableList<Case>CaseList;
    //ObservableList<Criminal>List;
    CaseConnection dc;
    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        dc = new CaseConnection();
        Connection conn = CaseConnection.Connect();
        CaseList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM caselist";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                CaseList.add(new Case(rs.getString("complainid"), rs.getString("typeofcrime"), rs.getString("dateofcrime"), rs.getString("locationofcrime"), rs.getString("status")));
            }


        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        NoCol.setCellValueFactory(new PropertyValueFactory<>("complainid"));
        crimeCol.setCellValueFactory(new PropertyValueFactory<>("typeofcrime"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateofcrime"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("locationofcrime"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        //criminalList.setItems(null);

        caseList.setItems(CaseList);


        FilteredList<Case> filteredData = new FilteredList<>(CaseList, b -> true);
        filter.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(Case -> {
            if (newValue == null || newValue.isEmpty()||newValue.isBlank()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();

            if(Case.getComplainid().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (Case.getTypeofcrime().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }else if (Case.getDateofcrime().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            else if (Case.getLocationofcrime().toLowerCase().contains(lowerCaseFilter)) {
            return true;
             }
            else return Case.getStatus().toLowerCase().contains(lowerCaseFilter);
        }));
        SortedList<Case> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(caseList.comparatorProperty());
        caseList.setItems(sortedData);
    }
}