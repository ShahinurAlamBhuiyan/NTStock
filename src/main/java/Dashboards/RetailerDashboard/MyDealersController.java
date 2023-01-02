package Dashboards.RetailerDashboard;

import Dashboards.SoldProductInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import static Slides.SlideOne.SlideOne.loggedInUserEmail;

public class MyDealersController implements Initializable {

    @FXML
    private TableColumn<SoldProductInformation, String> DealerContact;

    @FXML
    private TableColumn<SoldProductInformation, String> DealerName;

    @FXML
    private TableView<SoldProductInformation> DealerTableView;

    @FXML
    private TableColumn<SoldProductInformation, String> LastDate;

    @FXML
    private TableColumn<SoldProductInformation, String> TotalPrice;

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
                if (product.getRetailerEmail().equals(loggedInUserEmail)) {
                    productListR.add(product);
                }
            }
//            TotalProductLabel.setText("Total Product: "+ productListR.size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllProducts();
        DealerName.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("dealerName"));
        DealerContact.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("dealerEmail"));
        TotalPrice.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("productTotalPrice"));
        LastDate.setCellValueFactory(new PropertyValueFactory<SoldProductInformation, String>("buyingDate"));
        DealerTableView.setItems(productListR);
    }
}
