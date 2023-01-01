package Dashboards.DealerDashboard;

import Dashboards.SoldProductInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

public class MyProductsController implements Initializable {

    @FXML
    private Button BgButton;

    @FXML
    private TableView<SoldProductInformation> MyProductsTable;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductName;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductPerPrice;

    @FXML
    private TableColumn<SoldProductInformation, String> ProductQuantity;

    @FXML
    private TableColumn<SoldProductInformation, String> Total;

    @FXML
    private Text TotalProductLabel;

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

                for (SoldProductInformation product : productsInfo){
                    if (product.getDealerEmail().equals(loggedInUserEmail)) {
                        productListR.add(product);
                    }
                }
            TotalProductLabel.setText("Total Product: "+ productListR.size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllProducts();
        ProductName.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productName"));
        ProductQuantity.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productQuantity"));
        ProductPerPrice.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productPerPrice"));
        Total.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productTotalPrice"));
        MyProductsTable.setItems(productListR);
    }
}
