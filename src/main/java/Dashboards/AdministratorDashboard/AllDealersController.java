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

public class AllDealersController implements Initializable {
    @FXML
    private TableView<UserInformation> AllDealersTable;
    @FXML
    private TableColumn<UserInformation, String> DealerName;
    @FXML
    private TableColumn<UserInformation, String> DealerAddress;
    @FXML
    private TableColumn<UserInformation, String> DealerContact;

    @FXML
    private Label TotalDealerLabel;

    ArrayList<UserInformation> usersInfo = new ArrayList<UserInformation>();
    ObservableList<UserInformation> dealerListR = FXCollections.observableArrayList(usersInfo);

    void getAllDealers() {
        try{
            File file  = new File("AllTextFiles/All-Users/usersSignUpInfo.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
            for(UserInformation user : usersInfo){
                if(user.getRole().equals("Dealer")){
                    dealerListR.add(user);
                }
            }
            TotalDealerLabel.setText("Total Dealers: "+ dealerListR.size());

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllDealers();
        DealerName.setCellValueFactory(new PropertyValueFactory<UserInformation, String>("userName"));
        DealerAddress.setCellValueFactory(new PropertyValueFactory<UserInformation, String>("email"));
        DealerContact.setCellValueFactory(new PropertyValueFactory<UserInformation, String>("contactNo"));


        AllDealersTable.setItems(dealerListR);
    }


}
