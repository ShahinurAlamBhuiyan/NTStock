package Dashboards.CustomerDashboard;

import Auths.SignIn.UserInformation;
import Dashboards.SoldProductInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SingleProductsController {
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
    @FXML
    void handleAddToCart(ActionEvent event) {

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
    }
}
