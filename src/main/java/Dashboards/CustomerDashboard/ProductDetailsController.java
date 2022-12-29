package Dashboards.CustomerDashboard;

import Dashboards.SoldProductInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ProductDetailsController {
    @FXML
    private Label ProductName;

    @FXML
    private Label ProductPrice;

    List<SoldProductInformation> matchedProducts = new ArrayList<SoldProductInformation>();
    @FXML
    void handleBuyBtn(ActionEvent event) throws IOException {
        File file = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
        Scanner readers = new Scanner(file);
        String newLine="";
        while(readers.hasNext()){
            String line = readers.nextLine();
            if(line.contains(matchedProducts.get(0).getProductId()) && line.contains(matchedProducts.get(0).getProductName())){
                line =  line.replace(matchedProducts.get(0).getProductQuantity(), String.valueOf(Integer.parseInt(matchedProducts.get(0).getProductQuantity())-1));
            }
            newLine =newLine+ line+"\n";
        }
        FileWriter writer = new FileWriter("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
        writer.write(newLine);
        writer.close();
    }

    public void setInformation(String productId, String retailerEmail){
        List<SoldProductInformation> allProducts = new ArrayList<SoldProductInformation>();
        try{
            File file  = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                allProducts.add(new SoldProductInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        int i = 0;
        System.out.println("Size of all products " + allProducts.size());
        while(allProducts.size() > 0){
            if(allProducts.get(i).getProductId().equals(productId) && allProducts.get(i).getRetailerEmail().equals(retailerEmail)){
                ProductName.setText("Name: "+allProducts.get(i).getProductName());
                ProductPrice.setText("Price: " + allProducts.get(i).getProductPerPrice());
                matchedProducts.add(allProducts.get(i));
                System.out.println("matched!");
                break;
            }
            i++;
        }
    }

}
