package Dashboards.CustomerDashboard;

import Dashboards.SoldProductInformation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CustomerHomeController implements Initializable {
    private List<SoldProductInformation> allProducts;
    @FXML
    private GridPane productContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allProducts = new ArrayList<>(productList());
        int column = 0;
        int row = 1;
        try{
            for(SoldProductInformation product : allProducts){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("SingleProducts.fxml"));
                VBox productBox = fxmlLoader.load();
                SingleProductsController singleProductsController = fxmlLoader.getController();
                singleProductsController.setData(product);

                if(column == 4){
                    column = 0;
                    ++row;
                }

                productContainer.add(productBox, column++, row);
                GridPane.setMargin(productBox, new Insets(15));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private List<SoldProductInformation> productList(){
        List<SoldProductInformation> products = new ArrayList<>();
            try{
                File file  = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
                Scanner fileReader = new Scanner(file);
                while(fileReader.hasNext())
                {
                    products.add(new SoldProductInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        return products;
    }
}
