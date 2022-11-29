package Sidebars.DealerSidebar;

import Auths.SignIn.SignInController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class DealerSidebarController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button MyProductsBtn;

    @FXML
    private Button RetailersListBtn;


    @FXML
    void handleMyProductsBtn(ActionEvent event) {

    }

    @FXML
    void handleRetailersListBtn(ActionEvent event) {

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

}