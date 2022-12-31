package Dashboards.AdministratorDashboard;

import Dashboards.SoldProductInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;


public class ProductPricingController {

    @FXML
    private TextField ProductPriceTF;

    @FXML
    private TextField productNameTF;

    @FXML
    private TextField searchProductTF;
    ArrayList<SoldProductInformation> productsInfo = new ArrayList<SoldProductInformation>();
    ArrayList<SoldProductInformation> matchedProducts = new ArrayList<>();
    @FXML
    void handleSearch(ActionEvent event) throws FileNotFoundException {
        if(!searchProductTF.getText().equals("")){
            File file  = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                productsInfo.add(new SoldProductInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
            for(SoldProductInformation product : productsInfo){
                if(product.getProductId().equals(searchProductTF.getText())){
                    matchedProducts.add(product);
                }
            }
            if(matchedProducts.size() > 0){
                productNameTF.setText(matchedProducts.get(0).getProductName());
                ProductPriceTF.setText(matchedProducts.get(0).getProductPerPrice());
            }
        }
    }

    @FXML
    void handleUpdate(ActionEvent event) throws IOException {
        File file = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
        Scanner readers = new Scanner(file);
        String newLine="";
        while(readers.hasNext()){
            String line = readers.nextLine();
            if(line.contains(matchedProducts.get(0).getProductId()) && line.contains(matchedProducts.get(0).getProductName())){
               line =  line.replace(matchedProducts.get(0).getProductName(), productNameTF.getText());
               line =  line.replace(matchedProducts.get(0).getProductPerPrice(), ProductPriceTF.getText());
            }
            newLine =newLine+ line+"\n";
        }
            FileWriter writer = new FileWriter("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
            writer.write(newLine);
            writer.close();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Updated!");
        alert.setContentText("Product updated successfully.");
        alert.showAndWait();
        productNameTF.setText(null);
        ProductPriceTF.setText(null);
        searchProductTF.setText(null);
    }
}
// merge with shahin