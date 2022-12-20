package Dashboards.RetailerDashboard;

import Auths.SignIn.FXMLScene;
import Auths.SignIn.SignInController;
import Auths.SignIn.UserInformation;
import Dashboards.DashboardsController;
import Dashboards.SoldProductInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import static Slides.SlideOne.SlideOne.*;

public class MyProductsController implements Initializable {

    @FXML
    private TableView<SoldProductInformation> MyProductsTable;

    @FXML
    private TableColumn<SoldProductInformation, String> BuyingDate;

    @FXML
    private TableColumn<SoldProductInformation, String> Total;


    @FXML
    private TableColumn<SoldProductInformation, String> ProductName;
    @FXML
    private TableColumn<SoldProductInformation, String> DealerName;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductPerPrice;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductQuantity;

    @FXML
    private Text TotalProductLabel;
    private String userEmail;
    private String userId;

    ArrayList<SoldProductInformation> productsInfo = new ArrayList<SoldProductInformation>();
    ObservableList<SoldProductInformation> productsList = FXCollections.observableArrayList(productsInfo);

    public void getMyAllProducts() {
        try{
            File file  = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                productsInfo.add(new SoldProductInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
            for(SoldProductInformation product : productsInfo){
                if(product.getRetailerEmail().equals(loggedInUserEmail) && product.getRetailerId().equals(loggedInUserID)){
                    productsList.add(product);
                    System.out.println("adding");
                }
            }
            TotalProductLabel.setText("Total Products: "+ productsList.size());

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getMyAllProducts();
        ProductName.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productName"));
        ProductPerPrice.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productPerPrice"));
        ProductQuantity.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productQuantity"));
        Total.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productTotalPrice"));
        BuyingDate.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("buyingDate"));
        DealerName.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("dealerName"));

        MyProductsTable.setItems(productsList);
    }
}
