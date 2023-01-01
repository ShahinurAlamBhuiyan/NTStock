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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private String productId;
    private String retailerEmail;
    List<SoldProductInformation> matchedProducts = new ArrayList<SoldProductInformation>();

    void handleUpdateStockerMethod() throws IOException, ParseException {
        // Updating method...
        FXMLScene scene = FXMLScene.load("/Dashboards/CustomerDashboard/CustomerHome.fxml");
        CustomerHomeController customerHomeController = (CustomerHomeController) scene.controller;
        customerHomeController.isStocker();
    }
    @FXML
    void handleAddToCart(ActionEvent event) throws IOException, ParseException {
        handleUpdateStockerMethod();
        List<SoldProductInformation> allProducts = new ArrayList<SoldProductInformation>();
        try{
            File file  = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                allProducts.add(new SoldProductInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next() ,fileReader.next()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int i = 0;
        while(allProducts.size() > 0){
            if(allProducts.get(i).getProductId().equals(productId) && allProducts.get(i).getRetailerEmail().equals(retailerEmail)){
                matchedProducts.add(allProducts.get(i));
                break;
            }
            i++;
        }

        File file = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
        Scanner readers = new Scanner(file);
        String newLine="";
        while(readers.hasNext()){
            String line = readers.nextLine();
            if(line.contains(matchedProducts.get(0).getProductId()) && line.contains(matchedProducts.get(0).getProductName())){
                line =  line.replace(matchedProducts.get(0).getProductQuantity()+" ", String.valueOf(Integer.parseInt(matchedProducts.get(0).getProductQuantity())-1)+" ");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String currentTime = dtf.format(now);
                line = line.replace(matchedProducts.get(0).getPrevSellTime(), currentTime);
            }
            newLine =newLine+ line+"\n";
        }
        FileWriter writer = new FileWriter("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
        writer.write(newLine);
        writer.close();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Purchased!");
        alert.setContentText("Product purchased successfully.");
        alert.showAndWait();
    }
    public void setData(SoldProductInformation soldProductInformation){
            ArrayList<UserInformation> retailers = new ArrayList<>();
        try{
            File file = new File("AllTextFiles/Retailers/"+soldProductInformation.getRetailerEmail()+"Retailer"+soldProductInformation.getRetailerId()+".txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext()){
                retailers.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
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
