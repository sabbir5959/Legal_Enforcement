package com.example.legelenforcement.Controller;

import com.example.legelenforcement.HelloApplication;
import com.example.legelenforcement.View.FIR;
import com.example.legelenforcement.View.USER;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class case_history_cell_factory extends ListCell<FIR> {

    protected void updateItem(FIR c, boolean empty) {
        super.updateItem(c, empty);

        if(empty || c == null) {

            setText(null);
            setGraphic(null);

        }

        else
        {
            // System.out.println(co.getName());
            // System.out.println("here1 " + c.getName());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXML/POLICE/case_list_cell.fxml"));
            case_history_cell_controller victimCellController = new case_history_cell_controller(c);
            fxmlLoader.setController(victimCellController);
            setText(null);

            try { setGraphic(fxmlLoader.load());}
            catch (IOException e) { e.printStackTrace(); }
        }
    }
}
