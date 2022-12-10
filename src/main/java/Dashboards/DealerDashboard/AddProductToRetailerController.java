package Dashboards.DealerDashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.time.LocalDate;

import static Slides.SlideOne.SlideOne.*;


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
    private TextField RetailerEmailTF;

    @FXML
    void handleCalculateBtn(ActionEvent event) {
        int perPrice = Integer.parseInt(ProductPerPriceTF.getText());
        int quantity = Integer.parseInt(ProductQuantityTF.getText());
        int totalPrice =  perPrice * quantity;
        ProductTotalPriceTF.setText(String.valueOf(totalPrice));
    }

    @FXML
    void handleAddBtn(ActionEvent event) {
        System.out.println("button clicked");

        if(!ProductNameTF.getText().equals("")
            && !ProductIDTF.getText().equals("")
                && !ProductPerPriceTF.getText().equals("")
                && !ProductQuantityTF.getText().equals("")
                && !RetailerEmailTF.getText().equals("")
                && !RetailerIDTF.getText().equals("")
        ){ // if all filled
            String filePath = "AllTextFiles/SoldProducts/AllDealersSoldProducts.txt";
            try{
                FileWriter writer = new FileWriter(filePath, true);
                writer.write(ProductNameTF.getText()+" " + ProductIDTF.getText()+" " + ProductPerPriceTF.getText()+" "+ProductQuantityTF.getText()+" " + ProductTotalPriceTF.getText()+" "+RetailerEmailTF.getText()+" "+RetailerIDTF.getText()+ " "+loggedInUserEmail+ " "+loggedInUserID + " "+loggedInUserName+" "+ LocalDate.now()+ "\n");
                writer.close();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Congratulations!");
                alert.setContentText("Product Added Successfully!");
                alert.showAndWait();
                ProductIDTF.clear();
                ProductNameTF.clear();
                ProductPerPriceTF.clear();
                ProductQuantityTF.clear();
                ProductTotalPriceTF.clear();
                RetailerIDTF.clear();
                RetailerEmailTF.clear();
            }catch(Exception e){
                System.out.println(e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrong!");
                alert.setContentText("Something wrong in opening file!");
                alert.showAndWait();
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong!");
            alert.setContentText("Please, fill all fields!");
            alert.showAndWait();
        }
    }

}
