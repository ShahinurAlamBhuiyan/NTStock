package Dashboards.DealerDashboard;

import Dashboards.SoldProductInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import static Slides.SlideOne.SlideOne.loggedInUserEmail;

public class MyTransactionsController implements Initializable {

    @FXML
    private TableColumn<SoldProductInformation, String> LastSellingDate;

    @FXML
    private TableView<SoldProductInformation> MyRetaielrList;

    @FXML
    private TableColumn<SoldProductInformation, String> PricePerUnit;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductName;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductQuantity;

    @FXML
    private TableColumn<SoldProductInformation, String> RetailerName;

    @FXML
    private TableColumn<SoldProductInformation, String> RetailerUID;

    @FXML
    private TableColumn<SoldProductInformation, String> TotalPrice;
    @FXML
    private Text TotalTransactionsLabel;

    ArrayList<SoldProductInformation> productsInfo = new ArrayList<SoldProductInformation>();
    ObservableList<SoldProductInformation> productListR = FXCollections.observableArrayList(productsInfo);

    void getAllProducts() {
        try{
            File file  = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                productsInfo.add(new SoldProductInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next(), fileReader.next()));
            }
            for(SoldProductInformation product : productsInfo){
                if(product.getDealerEmail().equals(loggedInUserEmail)) productListR.add(product);
            }
            TotalTransactionsLabel.setText("Total Transactions: "+ productListR.size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllProducts();
        RetailerName.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("retailerName"));
        RetailerUID.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("retailerId"));
        ProductName.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productName"));
        ProductQuantity.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productQuantity"));
        PricePerUnit.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productPerPrice"));
        TotalPrice.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productTotalPrice"));
        LastSellingDate.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("buyingDate"));
//
//        AllProductsTable.setItems(productListR);
        MyRetaielrList.setItems(productListR);
    }
}
