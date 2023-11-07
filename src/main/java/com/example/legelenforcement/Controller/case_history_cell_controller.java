
package com.example.legelenforcement.Controller;

        import com.example.legelenforcement.Global;
        import com.example.legelenforcement.HelloApplication;
        import com.example.legelenforcement.View.USER;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.paint.ImagePattern;
        import javafx.scene.shape.Circle;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;
        import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
public class case_history_cell_controller implements Initializable
{

    public USER user;
    public case_history_cell_controller(USER user) {
        this.user = user;
    }

    @FXML
    private Label complainNO;

    @FXML
    private Label crime;



    @FXML
    private Label location;

    @FXML
    private FontAwesomeIconView r;

    @FXML
    private Label show;

    @FXML
    private FontAwesomeIconView w;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        complainNO.setText(user.getComplainNo());
        crime.setText(user.getCrime());
        location.setText(user.getLocation());
        show.setText(user.getDate());

        w.setVisible(false);
        r.setVisible(false);

    }

    public void go_inbox ()  {



    }


}
