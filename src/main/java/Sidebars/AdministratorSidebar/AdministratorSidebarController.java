package Sidebars.AdministratorSidebar;

import Auths.SignIn.FXMLScene;
import Auths.SignIn.SignInController;
import Dashboards.DashboardsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdministratorSidebarController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button AllDealersBtn;

    @FXML
    private Button AllRetailersListBtn;

    @FXML
    private Button ComplainsBtn;

    @FXML
    private Button ProPriceBtn;

    @FXML
    private Button ProductListBtn;

    @FXML
    void handleAllDealersBtn(ActionEvent event) {

    }
    @FXML
    void handleAllRetailersListBtn(ActionEvent event) {
    }

    @FXML
    void handleComplainsBtn(ActionEvent event) {

    }

    @FXML
    void handleLogout(ActionEvent event) {
        try {
            root = FXMLLoader.load(SignInController.class.getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            System.out.println(event);
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleProPriceBtn(ActionEvent event) {

    }

    @FXML
    void handleProductListBtn(ActionEvent event) {

    }

}
