package Dashboards.CustomerDashboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ComplainBoxController {
    @FXML
    private TextField ComEmailTF;

    @FXML
    private TextField ContactNoTF;

    @FXML
    private DatePicker DateOfComTF;

    @FXML
    private TextArea DescriptionTF;

    @FXML
    private TextField RetailerOrDealerNameTF;

    @FXML
    private TextField ShopNameTF;

    @FXML
    void handleSubmitBtn(ActionEvent event) {

    }

}
