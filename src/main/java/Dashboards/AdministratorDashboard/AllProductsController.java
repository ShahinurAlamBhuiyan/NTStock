package Dashboards.AdministratorDashboard;

import Auths.SignIn.UserInformation;
import Dashboards.SoldProductInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AllProductsController  implements Initializable {

    @FXML
    private TableView<SoldProductInformation> AllProductsTable;

    @FXML
    private Button BgButton;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductID;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductPrice;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductQuantity;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductsName;

    @FXML
    private TableColumn<SoldProductInformation, String> RetailerName;

    @FXML
    private Label TotalProductLabel;
    ArrayList<SoldProductInformation> productsInfo = new ArrayList<SoldProductInformation>();
    ObservableList<SoldProductInformation> productListR = FXCollections.observableArrayList(productsInfo);

    void getAllProducts() {
        try{
            File file  = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                productsInfo.add(new SoldProductInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
            for(SoldProductInformation product : productsInfo){
//                if(user.getRole().equals("Dealer")){
                    productListR.add(product);
//                }
            }
            TotalProductLabel.setText("Total Products: "+ productListR.size());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllProducts();
        ProductID.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productId"));
        ProductsName.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productName"));
        RetailerName.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("retailerId"));
        ProductQuantity.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productQuantity"));
        ProductPrice.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productPerPrice"));

        AllProductsTable.setItems(productListR);
    }
}
