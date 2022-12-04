package Dashboards.AdministratorDashboard;

import Auths.SignIn.UserInformation;
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

public class AllRetailersController implements Initializable {
    @FXML
    private TableView<UserInformation> AllRetailersTable;
    @FXML
    private TableColumn<UserInformation, String> RetailerName;
    @FXML
    private TableColumn<UserInformation, String> RetailerAddress;
    @FXML
    private TableColumn<UserInformation, String> RetailerContact;

    @FXML
    private Label TotalRetailerLabel;





    ArrayList<UserInformation> usersInfo = new ArrayList<UserInformation>();
    ObservableList<UserInformation> retailerListR = FXCollections.observableArrayList(usersInfo);

    void getAllRetailers() {
        try{
            File file  = new File("AllTextFiles/All-Users/usersSignUpInfo.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
            for(UserInformation user : usersInfo){
                if(user.getRole().equals("Retailer")){
                    retailerListR.add(user);
                }
            }
            TotalRetailerLabel.setText("Total Retailers: "+ retailerListR.size());

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllRetailers();
        RetailerName.setCellValueFactory(new PropertyValueFactory<UserInformation, String>("username"));
        RetailerAddress.setCellValueFactory(new PropertyValueFactory<UserInformation, String>("email"));
        RetailerContact.setCellValueFactory(new PropertyValueFactory<UserInformation, String>("birthday"));


        AllRetailersTable.setItems(retailerListR);
    }


}
