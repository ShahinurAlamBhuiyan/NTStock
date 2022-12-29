package Dashboards.CustomerDashboard;

import Auths.SignIn.FXMLScene;
import Auths.SignIn.UserInformation;
import Auths.SignUp.SignUpController;
import Dashboards.DashboardsController;
import Dashboards.SoldProductInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SingleProductsController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private VBox productBox;
    @FXML
    private ImageView productImage;

    @FXML
    private Label productName;
    @FXML
    private Label productPrice;

    @FXML
    private Label retailerName;
    private String productId;
    private String retailerEmail;
    @FXML
    void handleAddToCart(ActionEvent event) throws IOException {
        try {
            FXMLScene scene = FXMLScene.load("/Dashboards/CustomerDashboard/ProductDetails.fxml");
            Parent root = scene.root;
            // sending data for dashboard. --------------------------------
            ProductDetailsController productDetailsController = (ProductDetailsController) scene.controller;
            productDetailsController.setInformation(productId, retailerEmail);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("NTStock");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleViewDetails(ActionEvent event) {

    }
    public void setData(SoldProductInformation soldProductInformation){
            ArrayList<UserInformation> retailers = new ArrayList<>();
        try{
            File file = new File("AllTextFiles/Retailers/"+soldProductInformation.getRetailerEmail()+"Retailer"+soldProductInformation.getRetailerId()+".txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext()){
                retailers.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        productBox.setStyle("-fx-border-radius: 20;" +"-fx-background-radius: 20;" +
                "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.1),10,0,0,10);" +
                "-fx-background-color: rgb(32,73,46);"+
                "-fx-border-color: green;");
        productName.setText("Name: "+soldProductInformation.getProductName());
        productPrice.setText("Price: $"+soldProductInformation.getProductPerPrice());
        retailerName.setText("Retailer: "+ retailers.get(0).getFirstName()+ " "+retailers.get(0).getLastName());
        this.productId = soldProductInformation.getProductId();
        this.retailerEmail = soldProductInformation.getRetailerEmail();
    }
}
// merge with main
