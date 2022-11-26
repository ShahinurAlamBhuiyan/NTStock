package Dashboards;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardsController {
    @FXML
    private Label UserNameLebel;

    @FXML
    private Label UserTypeLebel;

    @FXML
    private Label welcomeLebel;
    public void setTxt_uEmail(String userType, String uEmail, String uPassword) {
        welcomeLebel.setText("Welcome "+userType);
    }
}
