package Dashboards.DealerDashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddProductToRetailerController {

    @FXML
    private TextField ProductIDTF;

    @FXML
    private TextField ProductNameTF;

    @FXML
    private TextField ProductPerPriceTF;

    @FXML
    private TextField ProductQuantityTF;

    @FXML
    private TextField ProductTotalPriceTF;

    @FXML
    private TextField RetailerIDTF;

    @FXML
    private TextField RetailerNameTF;

    @FXML
    void handleAddBtn(ActionEvent event) {
        System.out.println("button clicked");

        if(!ProductNameTF.getText().equals("")
            && !ProductIDTF.getText().equals("")
                && !ProductPerPriceTF.getText().equals("")
                && !ProductQuantityTF.getText().equals("")
                && !RetailerNameTF.getText().equals("")
                && !RetailerIDTF.getText().equals("")
        ){


        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong!");
            alert.setContentText("Please, fill all fields!");
            alert.showAndWait();
        }
    }

}
